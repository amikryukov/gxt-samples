package com.mur.client;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.*;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.extjs.gxt.ui.client.widget.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Mur implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {


        GroupingStore<BaseModel> store = new GroupingStore<BaseModel>();
        for (int i = 0 ; i < 10; i++) {
            BaseModel mm = new BaseModel();
            mm.set("name", i + "name");
            mm.set("open", i + "open");
            mm.set("change", i + "change");
            mm.set("industry" , i % 3 + "industry");
            mm.set("date", i + "date");
            store.add(mm);
        }

        store.groupBy("industry");

        ColumnConfig company = new ColumnConfig("name", "Company", 60);
        ColumnConfig price = new ColumnConfig("open", "Price", 20);
        ColumnConfig change = new ColumnConfig("change", "Change", 20);
        ColumnConfig industry = new ColumnConfig("industry", "Industry", 20);
        ColumnConfig last = new ColumnConfig("date", "Last Updated", 20);

        List<ColumnConfig> config = new ArrayList<ColumnConfig>();
        config.add(company);
        config.add(price);
        config.add(change);
        config.add(industry);
        config.add(last);

        final ColumnModel cm = new ColumnModel(config);

        GroupingView view = new GroupingView();
        view.setShowGroupedColumn(false);
        view.setForceFit(true);
        view.setGroupRenderer(new GridGroupRenderer() {
            public String render(GroupColumnData data) {
                String f = cm.getColumnById(data.field).getHeaderHtml();
                String l = data.models.size() == 1 ? "Item" : "Items";
                return f + ": " + data.group + " (" + data.models.size() + " " + l + ")";
            }
        });

        Grid<BaseModel> grid = new Grid<BaseModel>(store, cm);
        grid.setView(view);
        grid.setStripeRows(true);
        grid.setBorders(true);
        grid.setColumnLines(true);
        grid.setColumnResize(true);
        grid.setColumnReordering(true);

        ContentPanel panel = new ContentPanel();
        panel.setHeadingHtml("Grouping Example");
        panel.setCollapsible(true);
        panel.setFrame(true);
        panel.setSize(700, 450);
        panel.setLayout(new FitLayout());
        panel.add(grid);
        RootPanel.get().add(panel);
    }

}