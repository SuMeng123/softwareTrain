using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace tsgl
{
    public partial class addInfor : Form
    {
        index index;
        int adminID;
        int inID;
        int bid;
        public addInfor(int adminID,int inID,int bid)
        {
            InitializeComponent();
            this.adminID = adminID;
            this.inID = inID;
            this.bid = bid;
            label1.Text = "是否破损";
            label2.Text = "是否丢失";
            label3.Text = "惩罚结果";
            radioButton2.Checked = true;
            radioButton4.Checked = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string date = DateTime.Now.ToLocalTime().ToString();
            string ps = "否";
            string ds = "否";
            string jg = "无";
            if (radioButton1.Checked == true)
            {
                ps = "是";
            }
            if (radioButton3.Checked == true)
            {
                ds = "是";
            }
            if (!string.IsNullOrEmpty(textBox1.Text.ToString()))
            {
                jg = textBox1.Text.ToString();
            }
            SqlHelper.ExecuteNonQuery("update Infor set H_Date = @date, IS_PS=@ps,IS_DS=@ds,JG=@jg where INID = @inid",
                                                                                         new SqlParameter("@date", date),
                                                                                         new SqlParameter("@ps", ps),
                                                                                         new SqlParameter("@ds", ds),
                                                                                         new SqlParameter("@jg", jg),
                                                                                        new SqlParameter("@inid", inID)
                                                                                        );
            DataSet email = SqlHelper.ExecuteDataTable("select  *  from sendEmail where BookID  = @BookID",
                                                       new SqlParameter("@BookID", bid));
            foreach (DataRow d in email.Tables[0].Rows)
            {
                MailAddress EmailFrom = new MailAddress("2418606562@qq.com");
                MailAddress EmailTo = new MailAddress(d["U_Email"].ToString());
                MailMessage mailMsg = new MailMessage(EmailFrom, EmailTo);
                mailMsg.Subject = "图书已到！！！";
                mailMsg.Body = "您好，您需要的" + d["DJ_Name"].ToString() + "已到！！！";
                mailMsg.Priority = MailPriority.High;
                SmtpClient spClient = new SmtpClient("smtp.qq.com");
                spClient.EnableSsl = true;
                spClient.UseDefaultCredentials = false;
                spClient.Credentials = new System.Net.NetworkCredential("2418606562@qq.com", "pbqwetkjrxzadjge");
                spClient.Send(mailMsg);
            }
            string status = "可借";
            SqlHelper.ExecuteNonQuery("update Book set B_Status=@B_Status where BookID = @bookId",
                                                                               new SqlParameter("@B_Status", status),
                                                                              new SqlParameter("@bookId", bid)
                                                                              );
            SqlHelper.ExecuteNonQuery("update DJ set DJ_Status=@DJ_Status where BookID = @BookID",
                                                                                         new SqlParameter("@DJ_Status", "已到书")
                                                                                         , new SqlParameter("@BookID", bid)
                                                                                         );
            SqlHelper.ExecuteNonQuery("delete from QS  where BookID=@BookID",
                                                            new SqlParameter("@BookID", bid)
                );
            this.Hide();
            index = new index(adminID, 3);
            index.Show();

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            index = new index(adminID, 3);
            index.Show();
        }
    }
}
