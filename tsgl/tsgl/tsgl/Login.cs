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
    public partial class Form1 : Form
    {
        private index index;
        private Form2 form2;
        int admin_id;
        public Form1()
        {
            InitializeComponent();
            form2 = new Form2();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string userName = textBox1.Text;
            string password = textBox2.Text;
            if (string.IsNullOrEmpty(userName))
            {
                MessageBox.Show("账号不能为空!!!");
            }
            else
            {
                if (string.IsNullOrEmpty(password))
                {
                    MessageBox.Show("密码不能为空!!!");
                }
                else
                {
                    int count = (int)SqlHelper.ExecuteScalar("select Count(*) from Admin where A_Num=@userName", new SqlParameter("@username", userName));
                    if(count<1)
                    {
                        MessageBox.Show("账号不存在!!!");
                    }
                    else
                    {
                        DataSet dt = SqlHelper.ExecuteDataTable("select * from Admin where A_Psw=@password and A_Num=@userName"
                       , new SqlParameter("@password", password)
                       , new SqlParameter("@userName", userName));
                        if (dt.Tables.Count<= 1 &&dt.Tables[0].Rows.Count ==0)
                        {
                            MessageBox.Show("密码错误!!!");
                        }
                        else
                        {
                            this.Hide();
                            
                            //form2.Show();
                            index = new index(Convert.ToInt32(dt.Tables[0].Rows[0]["Admin_ID"].ToString()),1);
                            index.Show();
                        }
                    }
                }

            }


        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
