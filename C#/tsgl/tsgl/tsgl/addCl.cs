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
    public partial class addCl : Form
    {
        index index;
        int adminID;
        public addCl(int adminID)
        {
            InitializeComponent();
            this.adminID = adminID;
            label1.Text = "图书类别";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string lb = textBox1.Text.ToString();
            if(!String.IsNullOrEmpty(lb))
            {
                DataSet ds = SqlHelper.ExecuteDataTable("select  *  from CL where CL_Num  = @CL_Num",
                                                      new SqlParameter("@CL_Num", lb)
              );
                if (ds.Tables.Count <= 1 && ds.Tables[0].Rows.Count == 0)
                {
                    string lm = "图书类别";
                    SqlHelper.ExecuteNonQuery("Insert into CL(CL_Name,CL_Num) values(@CL_Name,@CL_Num)",
                                                                                            new SqlParameter("@CL_Name", lm)
                                                                                            , new SqlParameter("@CL_Num", lb)
                                                                                            );
                    this.Hide();
                    index = new index(adminID,5);
                    index.Show();
                }
                else
                {
                    MessageBox.Show("该图书类别已存在！");
                }
            }
            else
            {
                MessageBox.Show("图书类别不能为空！");
            }
           
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            index = new index(adminID,5);
            index.Show();
        }
    }
}
