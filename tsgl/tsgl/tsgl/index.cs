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
    public partial class index : Form
    {
        DataTable dtpage;
        int PageCurrent = 1;
        int PageSize = 10;
        int PageCount = 0;
        int PageTotalNum = 100;
        BindingSource bs = new BindingSource();
        private addBook book;
        int admin_id;
        int bt = 0;
        int cxS = 0;
        private updateBook upBook;
        private addCl addCl;
        private updateCl upcl;
        private addInfor infor;
        public index(int admin_id,int bt)
        {
            InitializeComponent();
            this.admin_id = admin_id;
            label1.Text = "图书编码";
            this.bt = bt;
            this.dataGridView1.DataSource = bs;
            this.dataGridView1.ReadOnly = true;
            Bind();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            bt = 1;
            cxS = 0;
            textBox1.Text = "";
            textBox1.Visible = true;
            label1.Visible = true;
            button6.Visible = true;
            button7.Text = "添加图书";
            this.dataGridView1.DataSource = bs;
            Bind();
        }
        private void button2_Click(object sender, EventArgs e)
        {
            bt = 2;
            cxS = 0;
            textBox1.Text = "";
            textBox1.Visible = true;
            label1.Visible = true;
            button6.Visible = true;
            button7.Text = "添加图书";
            this.dataGridView1.DataSource = bs;
            Bind();
        }
        private void button3_Click(object sender, EventArgs e)
        {
            bt = 3;
            cxS = 0;
            textBox1.Text = "";
            textBox1.Visible = true;
            label1.Visible = true;
            button6.Visible = true;
            button7.Text = "添加图书";
            this.dataGridView1.DataSource = bs;
            Bind();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            bt = 4;
            textBox1.Visible = false;
            label1.Visible = false;
            button6.Visible = false;
            button7.Text = "添加图书";
            this.dataGridView1.DataSource = bs;
            Bind();
        }
        private void button5_Click(object sender, EventArgs e)
        {
            bt = 5;
            textBox1.Visible = false;
            label1.Visible = false;
            button6.Visible = false;
            button7.Text = "添加常量";
            this.dataGridView1.DataSource = bs;
            Bind();
        }
        private void button6_Click(object sender, EventArgs e)
        {
            cxS = 1;
            this.dataGridView1.DataSource = bs;
            Bind();
        }
        private void button7_Click(object sender, EventArgs e)
        {
            switch (bt)
            {
                case 1:
                    this.Hide();
                    book = new addBook(admin_id);
                    book.Show();
                    break;
                case 2:
                    this.Hide();
                    book = new addBook(admin_id);
                    book.Show();
                    break;
                case 3:
                    this.Hide();
                    book = new addBook(admin_id);
                    book.Show();
                    break;
                case 4:
                    this.Hide();
                    book = new addBook(admin_id);
                    book.Show();
                    break;
                case 5:
                    this.Hide();
                    addCl = new addCl(admin_id);
                    addCl.Show();
                    break;
                default:
                    break;
            }
           
        }

        public DataTable getdtByNum(int pageNum, int pageSize,int bt)
        {
            DataTable dt = new DataTable();
            switch (bt)
            {
                case 1:
                    string status = "注销";
                    string id = "BookID";
                    string tableName = "Book";
                    string cx = textBox1.Text.ToString();
                    if(cxS == 1 && !String.IsNullOrEmpty(cx))
                    {
                        string num = "%"+cx+"%";
                        DataSet ds = SqlHelper.ExecuteDataTable("select * from (select *,ROW_NUMBER() over( order by " + id + " asc) as num from " + tableName + " p where B_Status != @status and B_Num like @num) s where s.num>@Start and s.num<@End ",
                     new SqlParameter("@Start", (pageNum - 1) * pageSize),
                     new SqlParameter("@status", status),
                     new SqlParameter("@num", num),
                     new SqlParameter("@End", pageNum * pageSize + 1)
                     );
                        PageTotalNum = (int)SqlHelper.ExecuteScalar("select count(*) from " + tableName + " where B_Status != @status and B_Num like @num",
                        new SqlParameter("@status", status),
                        new SqlParameter("@num", num)
                       );
                        dt = ds.Tables[0];
                    }
                    else
                    {
                       DataSet ds = SqlHelper.ExecuteDataTable("select * from (select *,ROW_NUMBER() over( order by " + id + " asc) as num from " + tableName + " p where B_Status != @status) s where s.num>@Start and s.num<@End ",
                     new SqlParameter("@Start", (pageNum - 1) * pageSize),
                     new SqlParameter("@status", status),
                     new SqlParameter("@End", pageNum * pageSize + 1)
                     );
                        PageTotalNum = (int)SqlHelper.ExecuteScalar("select count(*) from " + tableName + " where B_Status != @status",
                        new SqlParameter("@status", status)
                       );
                        dt = ds.Tables[0];
                    }
                    dt.Columns["B_Num"].SetOrdinal(1);
                    dt.Columns["B_Name"].SetOrdinal(2);
                    dt.Columns["B_Au"].SetOrdinal(3);
                    dt.Columns["B_Status"].SetOrdinal(4);
                    dt.Columns["IS_New"].SetOrdinal(5);
                    dt.Columns.Remove("AdminID");
                    dt.Columns.Remove("num");
                    dt.Columns["B_Num"].ColumnName = "图书编号";
                    dt.Columns["B_Name"].ColumnName = "图书名称";
                    dt.Columns["B_Au"].ColumnName = "图书作者";
                    dt.Columns["B_Status"].ColumnName = "图书状态";
                    dt.Columns["IS_New"].ColumnName = "是否新书";
                    dt.Columns["B_SL"].ColumnName = "借订数量";
                    break;
                case 2:
                     id = "INID";
                     tableName = "jBook";
                    cx = textBox1.Text.ToString();
                    if (cxS == 1 && !String.IsNullOrEmpty(cx))
                    {
                        string num = "%" + cx + "%";
                        DataSet ds = SqlHelper.ExecuteDataTable("select * from (select *,ROW_NUMBER() over( order by " + id + " asc) as num from " + tableName + " p where B_Num like @num) s where s.num>@Start and s.num<@End ",
                     new SqlParameter("@Start", (pageNum - 1) * pageSize),
                     new SqlParameter("@num", num),
                     new SqlParameter("@End", pageNum * pageSize + 1)
                     );
                        PageTotalNum = (int)SqlHelper.ExecuteScalar("select count(*) from " + tableName + " where B_Num like @num",                     
                        new SqlParameter("@num", num)
                       );
                        dt = ds.Tables[0];
                    }
                    else
                    {
                        DataSet ds = SqlHelper.ExecuteDataTable("select * from (select *,ROW_NUMBER() over( order by " + id + " asc) as num from " + tableName + " p ) s where s.num>@Start and s.num<@End ",
                      new SqlParameter("@Start", (pageNum - 1) * pageSize),
                      new SqlParameter("@End", pageNum * pageSize + 1)
                      );
                        PageTotalNum = (int)SqlHelper.ExecuteScalar("select count(*) from " + tableName                     
                       );
                        dt = ds.Tables[0];
                    }
                    dt.Columns["B_Num"].SetOrdinal(1);
                    dt.Columns["B_Name"].SetOrdinal(2);
                    dt.Columns["B_Au"].SetOrdinal(3);
                    dt.Columns["U_Snum"].SetOrdinal(4);
                    dt.Columns["U_Name"].SetOrdinal(5);
                    dt.Columns.Remove("num");
                    dt.Columns["B_Num"].ColumnName = "图书编号";
                    dt.Columns["B_Name"].ColumnName = "图书名称";
                    dt.Columns["B_Au"].ColumnName = "图书作者";
                    dt.Columns["U_Snum"].ColumnName = "读者编号";
                    dt.Columns["U_Name"].ColumnName = "读者名字";
                    break;
                case 3:
                    id = "INID";
                    tableName = "hBook";
                    cx = textBox1.Text.ToString();
                    if (cxS == 1 && !String.IsNullOrEmpty(cx))
                    {
                        string num = "%" + cx + "%";
                        DataSet ds = SqlHelper.ExecuteDataTable("select * from (select *,ROW_NUMBER() over( order by " + id + " asc) as num from " + tableName + " p where B_Num like @num) s where s.num>@Start and s.num<@End ",
                     new SqlParameter("@Start", (pageNum - 1) * pageSize),
                     new SqlParameter("@num", num),
                     new SqlParameter("@End", pageNum * pageSize + 1)
                     );
                        PageTotalNum = (int)SqlHelper.ExecuteScalar("select count(*) from " + tableName + " where B_Num like @num",
                        new SqlParameter("@num", num)
                       );
                        dt = ds.Tables[0];
                    }
                    else
                    {
                        DataSet ds = SqlHelper.ExecuteDataTable("select * from (select *,ROW_NUMBER() over( order by " + id + " asc) as num from " + tableName + " p ) s where s.num>@Start and s.num<@End ",
                      new SqlParameter("@Start", (pageNum - 1) * pageSize),
                      new SqlParameter("@End", pageNum * pageSize + 1)
                      );
                        PageTotalNum = (int)SqlHelper.ExecuteScalar("select count(*) from " + tableName
                       );
                        dt = ds.Tables[0];
                    }
                    dt.Columns["B_Num"].SetOrdinal(1);
                    dt.Columns["B_Name"].SetOrdinal(2);
                    dt.Columns["B_Au"].SetOrdinal(3);
                    dt.Columns["U_Snum"].SetOrdinal(4);
                    dt.Columns["U_Name"].SetOrdinal(5);
                    dt.Columns.Remove("num");
                    dt.Columns["B_Num"].ColumnName = "图书编号";
                    dt.Columns["B_Name"].ColumnName = "图书名称";
                    dt.Columns["B_Au"].ColumnName = "图书作者";
                    dt.Columns["U_Snum"].ColumnName = "读者编号";
                    dt.Columns["U_Name"].ColumnName = "读者名字";
                    break;
                case 4:
                    id = "QS_ID";
                    tableName = "QS";
                    DataSet ds4 = SqlHelper.ExecuteDataTable("select * from (select *,ROW_NUMBER() over( order by " + id + " asc) as num from " + tableName + " p ) s where s.num>@Start and s.num<@End ",
                          new SqlParameter("@Start", (pageNum - 1) * pageSize),
                          new SqlParameter("@End", pageNum * pageSize + 1)
                          );
                    PageTotalNum = (int)SqlHelper.ExecuteScalar("select count(*) from " + tableName + ""
                           );
                    dt = ds4.Tables[0];
                    dt.Columns.Remove("num");
                    dt.Columns.Remove("BookID");
                    dt.Columns["Status"].ColumnName = "缺书状态";
                    dt.Columns["Name"].ColumnName = "图书名称";
                    dt.Columns["Au"].ColumnName = "图书作者";
                    dt.Columns["SL"].ColumnName = "缺书数量";
                    dt.Columns["图书名称"].SetOrdinal(1);
                    dt.Columns["图书作者"].SetOrdinal(2);
                    dt.Columns["缺书状态"].SetOrdinal(3);
                    dt.Columns["缺书数量"].SetOrdinal(4);
                    break;
                case 5:
                    id = "CLID";
                    tableName = "CL";
                    DataSet dss = SqlHelper.ExecuteDataTable("select * from (select *,ROW_NUMBER() over( order by " + id + " asc) as num from " + tableName + " p ) s where s.num>@Start and s.num<@End ",
                          new SqlParameter("@Start", (pageNum - 1) * pageSize),
                          new SqlParameter("@End", pageNum * pageSize + 1)
                          );
                    PageTotalNum = (int)SqlHelper.ExecuteScalar("select count(*) from " + tableName + ""     
                           );
                    dt = dss.Tables[0];
                    dt.Columns.Remove("num");
                    dt.Columns["CL_Name"].ColumnName = "参数名称";
                    dt.Columns["CL_Num"].ColumnName = "参数内容";
                    break;
                default:
                    break;
            }
            PageCount = (int)Math.Ceiling(PageTotalNum / (float)pageSize);
            return dt;
        }

        //绑定源  
        public void Bind()
        {
            dtpage = getdtByNum(PageCurrent, PageSize,bt);
            //GetPageCount();
            bs.DataSource = dtpage;
            if (bs.DataSource != null)
            {
                //绑定数据源  
                this.bindingNavigator1.BindingSource = bs;
            }
            dataGridView1.Columns[0].Visible = false;
            if(bt == 2)
            {
                dataGridView1.Columns[6].Visible = false;
            }
            if (bt == 5)
            {
                dataGridView1.Columns[1].Width = 235;
                dataGridView1.Columns[2].Width = 235;
            }
            if (bt == 4)
            {
                dataGridView1.Columns[1].Width = 125;
                dataGridView1.Columns[2].Width = 125;
                dataGridView1.Columns[3].Width = 125;
                dataGridView1.Columns[4].Width = 125;
            }
            this.bindingNavigatorMoveFirstItem.Enabled = true;
            this.bindingNavigatorMovePreviousItem.Enabled = true;
            this.bindingNavigatorMoveNextItem.Enabled = true;
            this.bindingNavigatorMoveLastItem.Enabled = true;
            if (this.PageCurrent > this.PageTotalNum)
            {
                this.PageCurrent = this.PageTotalNum;
            }
            if (this.PageCount == 1)
            {
                this.PageCurrent = 1;
            }
            if (PageCurrent == 1)
            {
                this.bindingNavigatorMoveFirstItem.Enabled = false;
                this.bindingNavigatorMovePreviousItem.Enabled = false;
            }
            if (PageCurrent == PageCount)
            {
                this.bindingNavigatorMoveNextItem.Enabled = false;
                this.bindingNavigatorMoveLastItem.Enabled = false;
            }
            if (this.PageTotalNum == 0)
            {
                this.bindingNavigatorMoveFirstItem.Enabled = false;
                this.bindingNavigatorMovePreviousItem.Enabled = false;
                this.bindingNavigatorMoveNextItem.Enabled = false;
                this.bindingNavigatorMoveLastItem.Enabled = false;
            }

            this.bindingNavigatorPositionItem.Text = PageCurrent.ToString();
            this.bindingNavigatorPositionItem.Enabled = true;
            this.bindingNavigatorCountItem.Text = "共 " + PageCount + " 页";
            this.bindingNavigatorCountItem.Enabled = false;
        }
        
        //页数  
        private void GetPageCount()
        {
            if (this.PageTotalNum > 0)
            {
                this.PageCount = Convert.ToInt32(Math.Ceiling(Convert.ToDouble(this.PageTotalNum) / Convert.ToDouble(this.PageSize)));
            }
            else
            {
                this.PageCount = 0;
            }
        }
        private void bindingNavigatorMoveFirstItem_Click(object sender, EventArgs e)
        {
            PageCurrent = 1;
            this.Bind();
        }

        private void bindingNavigatorMovePreviousItem_Click(object sender, EventArgs e)
        {
            PageCurrent--;
            if (PageCurrent <= 0)
            {
                PageCurrent = 1;
            }
            this.Bind();
        }
        //换页
        private void bindingNavigatorMoveNextItem_Click(object sender, EventArgs e)
        {
            this.PageCurrent++;
            if (PageCurrent > PageCount)
            {
                PageCurrent = PageCount;
            }
            this.Bind();
        }

        private void bindingNavigatorMoveLastItem_Click(object sender, EventArgs e)
        {
            PageCurrent = PageCount;
            this.Bind();
        }

        private void dataGridView1_CellContentClick_1(object sender, DataGridViewCellEventArgs e)
        {
            //MessageBox.Show(dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString());
            //MessageBox.Show("demo","text",MessageBoxButtons.YesNoCancel,MessageBoxIcon.Warning);
            switch(bt)
            {
                case 1:
                    DialogResult  dr; 
                     dr = MessageBox.Show("是否注销图书？", "图书管理", MessageBoxButtons.YesNoCancel, MessageBoxIcon.Warning);
                    if(dr == DialogResult.Yes)
                    {
                        int bookId = Convert.ToInt32(dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString());
                        string status = "注销";
                        SqlHelper.ExecuteNonQuery("update Book set B_Status=@B_Status where BookID = @bookId",                                                                                   
                                                                                          new SqlParameter("@B_Status", status),
                                                                                         new SqlParameter("@bookId", bookId)
                                                                                         );
                        this.dataGridView1.DataSource = bs;
                        Bind();
                    }
                    else if(dr == DialogResult.No)
                    {
                        this.Hide();
                        int bookId = Convert.ToInt32(dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString());
                        upBook = new updateBook(admin_id, bookId);
                        upBook.Show();
                    }
                    break;
                case 2:
                    string bid = dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                    string inid = dataGridView1.Rows[e.RowIndex].Cells[6].Value.ToString();
                    dr = MessageBox.Show("是否借出图书？", "借书管理", MessageBoxButtons.YesNoCancel, MessageBoxIcon.Warning);
                    if (dr == DialogResult.Yes)
                    {
                        SqlHelper.ExecuteNonQuery("update Infor set AdminID = @adminID where INID = @inid",
                                                                                         new SqlParameter("@adminID", admin_id),
                                                                                        new SqlParameter("@inid", inid)
                                                                                        );
                        string status = "借出";
                        SqlHelper.ExecuteNonQuery("update Book set B_Status=@B_Status where BookID = @bookId",
                                                                                           new SqlParameter("@B_Status", status),
                                                                                          new SqlParameter("@bookId", bid)
                                                                                          );
                        this.dataGridView1.DataSource = bs;
                        Bind();
                    }
                    else
                    {

                    }
                    break;
                case 3:
                    bid = dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                    inid = dataGridView1.Rows[e.RowIndex].Cells[6].Value.ToString();
                    dr = MessageBox.Show("是否损坏丢失？", "还书管理", MessageBoxButtons.YesNoCancel, MessageBoxIcon.Warning);
                    if (dr == DialogResult.No)
                    {
                        string date = DateTime.Now.ToLocalTime().ToString();
                        string ps = "否";
                        string ds = "否";
                        string jg = "无";
                        SqlHelper.ExecuteNonQuery("update Infor set H_Date = @date, IS_PS=@ps,IS_DS=@ds,JG=@jg where INID = @inid",
                                                                                         new SqlParameter("@date", date),
                                                                                         new SqlParameter("@ps", ps),
                                                                                         new SqlParameter("@ds", ds),
                                                                                         new SqlParameter("@jg", jg),
                                                                                        new SqlParameter("@inid", inid)
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
                        this.dataGridView1.DataSource = bs;
                        Bind();
                    }
                    else if (dr == DialogResult.Yes)
                    {
                        this.Hide();
                        infor = new addInfor(admin_id, Convert.ToInt32(inid),Convert.ToInt32(bid));
                        infor.Show();
                    }
                    break;
                case 5:
                    string clName = dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();
                    if(clName == "图书类别")
                    {
                        dr = MessageBox.Show("是否删除参数？", "参数管理", MessageBoxButtons.YesNoCancel, MessageBoxIcon.Warning);
                        if (dr == DialogResult.Yes)
                        {
                            int clId = Convert.ToInt32(dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString());
                            SqlHelper.ExecuteNonQuery("delete from CL  where CLID=@clId",
                                                                                             new SqlParameter("@clId", clId)
                                                                                             );
                            this.dataGridView1.DataSource = bs;
                            Bind();
                        }
                        else if (dr == DialogResult.No)
                        {
                            this.Hide();
                            int clId = Convert.ToInt32(dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString());
                            upcl = new updateCl(admin_id, clId);
                            upcl.Show();
                        }
                    }
                    else
                    {
                        this.Hide();
                        int clId = Convert.ToInt32(dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString());
                        upcl = new updateCl(admin_id, clId);
                        upcl.Show();
                    }

                    break;
                default:
                    break;
            }

            
        }

     
    }

}
