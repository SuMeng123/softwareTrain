using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace tsgl
{
    public partial class updateBook : Form
    {
        index index;
        int adminID;
        int bookId;
        public updateBook(int adminID,int bookId)
        {
            InitializeComponent();
            this.adminID = adminID;
            this.bookId = bookId;
            label1.Text = "图书编码";
            label2.Text = "图书名称";
            label3.Text = "图书作者";
            label4.Text = "是否新书";
            label5.Text = "图书种类";
            getBookZl();
        }
        public void getBookZl()
        {
            string name = "%图书类别%";
            DataSet ds = SqlHelper.ExecuteDataTable("select  *  from CL where CL_Name  like @CL_Name",
                new SqlParameter("@CL_Name", name));
            DataSet dds = SqlHelper.ExecuteDataTable("select  *  from upBook where BookID  = @bookId",
               new SqlParameter("@bookId", bookId));
            int i = 0;
            foreach (DataTable dt in ds.Tables)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    checkedListBox1.Items.Add(dr["CL_Num"].ToString());
                    foreach (DataTable dtt in dds.Tables)
                    {
                        string is_new = dtt.Rows[0]["IS_New"].ToString();
                        if(is_new == "新书")
                        {
                            radioButton1.Checked = true;
                        }
                        else
                        {
                            radioButton2.Checked = true;
                        }
                        textBox1.Text = dtt.Rows[0]["B_Num"].ToString();
                        textBox2.Text = dtt.Rows[0]["B_Name"].ToString();
                        textBox3.Text = dtt.Rows[0]["B_Au"].ToString();
                        foreach (DataRow drr in dtt.Rows)
                        {
                            if (dr["CLID"].ToString() == drr["CLID"].ToString())
                            {
                                checkedListBox1.SetItemChecked(i, true);
                            }

                        }
                    }
                    i++;
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string bm = textBox1.Text.ToString();
            if (string.IsNullOrEmpty(bm))
            {
                MessageBox.Show("编码不能为空!!!");
            }
            else
            {
                string mc = textBox2.Text.ToString();
                if (string.IsNullOrEmpty(mc))
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
                        if (checkedListBox1.CheckedItems.Count < 1)
                        {
                            MessageBox.Show("种类不能为空!!!");
                        }
                        else
                        {
                            DataSet dt = SqlHelper.ExecuteDataTable("select  *  from Book where B_Num  = @num",
                                                                    new SqlParameter("@num", bm));
                            if ((dt.Tables.Count <= 1 && dt.Tables[0].Rows.Count == 0) || Convert.ToInt32(dt.Tables[0].Rows[0]["BookID"].ToString()) == bookId)
                            {
                                string au = "可借";
                                string is_new = "普通书";
                                if (radioButton1.Checked == true)
                                {
                                    is_new = "新书";
                                }
                                string id = adminID + "";
                                SqlHelper.ExecuteNonQuery("update Book set B_Name=@B_Name,B_Au=@B_Au,B_Status=@B_Status,AdminID=@AdminID,IS_New=@IS_New,B_Num=@B_Num where BookID = @bookId",
                                                                                         new SqlParameter("@B_Name", mc)
                                                                                         , new SqlParameter("@B_Au", zh)
                                                                                         , new SqlParameter("@B_Status", au)
                                                                                         , new SqlParameter("@AdminID", id)
                                                                                         , new SqlParameter("@IS_New", is_new)
                                                                                         , new SqlParameter("@B_Num", bm),
                                                                                         new SqlParameter("@bookId", bookId)
                                                                                         );
                                SqlHelper.ExecuteNonQuery("delete from ZL  where BookID=@bookId",
                                                                                new SqlParameter("@bookId", bookId)
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
    }
}
