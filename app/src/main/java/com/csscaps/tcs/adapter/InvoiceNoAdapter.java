package com.csscaps.tcs.adapter;

import android.content.Context;

import com.csscaps.common.baseadapter.BaseAdapterHelper;
import com.csscaps.common.baseadapter.QuickAdapter;
import com.csscaps.common.utils.AppSP;
import com.csscaps.tcs.R;
import com.csscaps.tcs.database.table.InvoiceNo;
import com.csscaps.tcs.database.table.InvoiceNo_Table;
import com.csscaps.tcs.database.table.InvoiceType;

import java.util.List;

import static com.raizlabs.android.dbflow.sql.language.SQLite.select;

public class InvoiceNoAdapter extends QuickAdapter<InvoiceType> {
    public InvoiceNoAdapter(Context context, int layoutResId, List<InvoiceType> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, InvoiceType item, int position) {
        String code = item.getInvoice_type_code();
        helper.setText(R.id.invoice_code, code);
        helper.setText(R.id.invoice_type, item.getInvoice_type_name());
        helper.setText(R.id.tax_Amount, AppSP.getInt(code) + "");
        long count = select().from(InvoiceNo.class).where(InvoiceNo_Table.invoice_type_code.eq(code)).query().getCount();
        helper.setText(R.id.remaining_qty, count + "");
        if (item.getInvoiceObject() == 1) {
            helper.setText(R.id.object, "Business");
        } else if (item.getInvoiceObject() == 0) {
            helper.setText(R.id.object, "Special Consumer");
        } else if (item.getInvoiceObject() == 2) {
            helper.setText(R.id.object, "General Consumer");
        }
    }
}
