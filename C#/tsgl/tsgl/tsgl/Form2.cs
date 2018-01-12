using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace tsgl
{
    public partial class Form2 : Form
    {
        DataTable dtpage;
        int PageCurrent = 1;
        int PageSize = 10;
        int PageCount = 0;
        int PageTotalNum = 100;
        BindingSource bs = new BindingSource();
        public Form2()
        {
            InitializeComponent();
        }
        private void Form2_Load(object sender, EventArgs e)
        {
            BindView();
        }
        //VIEW数据源绑定，并返回数据总条数  
        private void BindView()
        {
            Bind();
            this.dataGridView1.DataSource = bs;
        }
        //绑定源  
        public void Bind()
        {
            dtpage = getdtByNum(PageCurrent, PageSize);
            GetPageCount();
            bs.DataSource = dtpage;
            if (bs.DataSource != null)
            {
                //绑定数据源  
                this.bindingNavigator1.BindingSource = bs;
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
        //每页源  
        public DataTable getdtByNum(int pageNum, int pageSize)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("ID", typeof(string));
            dt.Columns.Add("NAME", typeof(string));
            for (int i = (pageNum - 1) * pageSize; i < pageSize * pageNum; i++)
            {
                DataRow dr = dt.NewRow();
                dr["ID"] = i;
                dr["NAME"] = "第" + i + "行";
                dt.Rows.Add(dr);
            }
            return dt;
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

        private void bindingNavigatorAddNewItem_Click(object sender, EventArgs e)
        {
            
        }

        private void bindingNavigatorDeleteItem_Click(object sender, EventArgs e)
        {
           
        }

     

        private void bindingNavigatorPositionItem_Click(object sender, EventArgs e)
        {
            PageCurrent = Convert.ToInt32(this.bindingNavigatorPositionItem.Text);
            Bind();
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

        private void bindingNavigatorCountItem_Click(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            MessageBox.Show(dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Value.ToString());

        }
        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            MessageBox.Show(dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Value.ToString());
        }
    }
}
