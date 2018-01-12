using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace tsgl
{
    public partial class addBook : Form
    {
        index index;
        int adminID;
        public addBook(int adminID)
        {

            InitializeComponent();
            this.adminID = adminID;
            label1.Text = "图书编码";
            label2.Text = "图书名称";
            label3.Text = "图书作者";
            label4.Text = "是否新书";
            label5.Text = "图书种类";
            radioButton1.Checked = true;
            getBookZl();
        }
        public void getBookZl()
        {
            string name = "%图书类别%";
            DataSet ds = SqlHelper.ExecuteDataTable("select  *  from CL where CL_Name  like @CL_Name",
                new SqlParameter("@CL_Name",name));
            foreach (DataTable dt in ds.Tables)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    checkedListBox1.Items.Add(dr["CL_Num"].ToString());
                }
            }
         }

        private void button1_Click(object sender, EventArgs e)
        {
            string bm = textBox1.Text.ToString();
            if(string.IsNullOrEmpty(bm))
            {
                MessageBox.Show("编码不能为空!!!");
            }
            else
            {
                string mc = textBox2.Text.ToString();
                if(string.IsNullOrEmpty(mc))
                {
                    MessageBox.Show("名称不能为空!!!");
                }
                else
                {
                    string zh = textBox3.Text.ToString();
                    if (string.IsNullOrEmpty(zh))
                    {
                        MessageBox.Show("作者不能为空!!!");
                    }
                    else
                    {
                        if(checkedListBox1.CheckedItems.Count<1)
                        {
                            MessageBox.Show("种类不能为空!!!");
                        }
                        else
                        {
                            DataSet dt = SqlHelper.ExecuteDataTable("select  *  from Book where B_Num  = @num",
                                                                    new SqlParameter("@num", bm));
                            if (dt.Tables.Count <= 1 && dt.Tables[0].Rows.Count == 0)
                            {
                                string au = "可借";
                                string is_new = "普通书";
                                if (radioButton1.Checked == true)
                                {
                                    is_new = "新书";
                                }
                                string id = adminID +"";
                                string sl = 0+"";
                                SqlHelper.ExecuteNonQuery("Insert into Book(B_Name,B_Au,B_Status,AdminID,IS_New,B_Num,B_SL) values(@B_Name,@B_Au,@B_Status,@AdminID,@IS_New,@B_Num,@B_SL)",
                                                                                         new SqlParameter("@B_Name", mc)
                                                                                         , new SqlParameter("@B_Au", zh)
                                                                                         , new SqlParameter("@B_Status", au)
                                                                                         , new SqlParameter("@AdminID", id)
                                                                                         , new SqlParameter("@IS_New", is_new)
                                                                                         , new SqlParameter("@B_Num", bm)
                                                                                          , new SqlParameter("@B_SL", sl)
                                                                                         );
                                DataSet email = SqlHelper.ExecuteDataTable("select  *  from sendEmail where DJ_Name  = @DJ_Name",
                                                        new SqlParameter("@DJ_Name", mc));
                                foreach (DataRow dr in email.Tables[0].Rows)
                                {
                                    MailAddress EmailFrom = new MailAddress("2418606562@qq.com");
                                    MailAddress EmailTo = new MailAddress(dr["U_Email"].ToString());
                                    MailMessage mailMsg = new MailMessage(EmailFrom, EmailTo);
                                    mailMsg.Subject = "图书已到！！！";
                                    mailMsg.Body = "您好，您需要的"+mc+"已到！！！";
                                    mailMsg.Priority = MailPriority.High;
                                    SmtpClient spClient = new SmtpClient("smtp.qq.com");
                                    spClient.EnableSsl = true;
                                    spClient.UseDefaultCredentials = false;
                                    spClient.Credentials = new System.Net.NetworkCredential("2418606562@qq.com", "pbqwetkjrxzadjge");
                                    spClient.Send(mailMsg);
                                }
                                SqlHelper.ExecuteNonQuery("update DJ set DJ_Status=@DJ_Status where DJ_Name = @DJ_Name",
                                                                                         new SqlParameter("@DJ_Status", "已到书")
                                                                                         , new SqlParameter("@DJ_Name", mc)
                                                                                         );
                                SqlHelper.ExecuteNonQuery("delete from QS  where Name=@Name",
                                                                                new SqlParameter("@Name", mc)
                                    );
                                foreach (object item in checkedListBox1.CheckedItems)
                                {
                                    string zl = item.ToString();
                                    DataSet ds = SqlHelper.ExecuteDataTable("select  *  from CL where CL_Num  = @CL_Num",
                                                        new SqlParameter("@CL_Num", zl));
                                    int clID = Convert.ToInt32(ds.Tables[0].Rows[0]["CLID"].ToString());
                                    DataSet db = SqlHelper.ExecuteDataTable("select  *  from Book where B_Num  = @B_Num",
                                                           new SqlParameter("@B_Num", bm));
                                    int bID = Convert.ToInt32(db.Tables[0].Rows[0]["BookID"].ToString());
                                    SqlHelper.ExecuteNonQuery("Insert into ZL(BookID,CLID) values(@BookID,@CLID)",
                                                                                            new SqlParameter("@BookID", bID)
                                                                                            , new SqlParameter("@CLID", clID)
                                                                                            );
                                }
                                
                                this.Hide();
                                index = new index(adminID,1);
                                index.Show();
                            }
                            else
                            {
                                MessageBox.Show("编码已存在!!!");
                            }
                        }
                    }
                }
                
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            index = new index(adminID,1);
            index.Show();
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void checkedListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
