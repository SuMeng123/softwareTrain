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
    public partial class updateCl : Form
    {
        index index;
        int adminID;
        int clId;
        public updateCl(int adminID,int clId)
        {
            InitializeComponent();
            this.adminID = adminID;
            this.clId = clId;
            DataSet ds = SqlHelper.ExecuteDataTable("select  *  from CL where CLID  = @CLID",
                                                      new SqlParameter("@CLID", clId)
                                                      );
            label1.Text = ds.Tables[0].Rows[0]["CL_Name"].ToString();
            textBox1.Text = ds.Tables[0].Rows[0]["CL_Num"].ToString();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            string lb = textBox1.Text.ToString();
            if (!String.IsNullOrEmpty(lb))
            {
                DataSet ds = SqlHelper.ExecuteDataTable("select  *  from CL where CL_Num  = @CL_Num",
                                                      new SqlParameter("@CL_Num", lb)
              );
                if ((ds.Tables.Count <= 1 && ds.Tables[0].Rows.Count == 0)|| Convert.ToInt32(ds.Tables[0].Rows[0]["CLID"].ToString())==clId|| ds.Tables[0].Rows[0]["CL_Num"].ToString()!="图书类别")
                {
                    string nr = label1.Text.ToString();
                    SqlHelper.ExecuteNonQuery("update CL set CL_Name=@CL_Name,CL_Num=@CL_Num where CLID = @CLID",
                                                                                         new SqlParameter("@CL_Name", nr)
                                                                                         , new SqlParameter("@CL_Num", lb)
                                                                                         , new SqlParameter("@CLID", clId)
                                                                                         );
                    this.Hide();
                    index = new index(adminID, 5);
                    index.Show();
                }
                else
                {
                    MessageBox.Show("该图书类别已存在！");
                }
            }
            else
            {
                MessageBox.Show("参数不能为空！");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            index = new index(adminID, 5);
            index.Show();
        }
    }
}
