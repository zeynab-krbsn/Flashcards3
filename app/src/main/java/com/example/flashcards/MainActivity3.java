package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    String[] child={"1","2","3","4","5"};
    private ArrayList<Flashcards> flashcardsArrayList=new ArrayList<>();
    private RecyclerView recyclerView;
    private recyclerAdapter adapter;
    private recyclerAdapter.RecyclerViewClickListener listener;
    String[] group_info;
    Map<String, List<String>> collection;
    List<String> childList;
    List<String> groupList;






    String lesson=null, podman=null;
    TextView textViewHeaderLesson,textViewHeaderPodman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textViewHeaderLesson=findViewById(R.id.textViewHeaderLesson);
        textViewHeaderPodman=findViewById(R.id.textViewHeaderPodman);

        Bundle bundle=getIntent().getExtras();
        if(bundle != null) {
            lesson = bundle.get("lesson").toString();
            podman = bundle.get("podman").toString();
            textViewHeaderLesson.setText(lesson);
            textViewHeaderPodman.setText(podman);



            if (lesson.equals("دانش فنی پایه") && podman.equals("پودمان 1")) {
//                flashcardsArrayList.add(new Flashcards( "شبکه"   , "شبکه درسی درست است "));
//                flashcardsArrayList.add(new Flashcards("گره", "گره درباره گره است"));
            } else if (lesson.equals("دانش فنی پایه") && podman.equals("پودمان 2")) {
                //group_info = new String[]{"2", "", ""};
            } else if (lesson.equals("دانش فنی پایه") && podman.equals("پودمان 3")) {
                //group_info = new String[]{"3", "", ""};
            } else if (lesson.equals("دانش فنی پایه") && podman.equals("پودمان 4")) {
                //group_info = new String[]{"4", "", ""};
            } else if (lesson.equals("دانش فنی پایه") && podman.equals("پودمان 5")) {
                //group_info = new String[]{"5", "", ""};
            }
            else if (lesson.equals("تجارت الکترونیک و امنیت شبکه") && podman.equals("پودمان 1")) {
                flashcardsArrayList.add(new Flashcards("ایده پردازی","فکر کردن به مشکلات با در نظر گرفتن محدودیت و شرایط برای رسیدن به راه حل جدید و با کیفیت"));
                flashcardsArrayList.add(new Flashcards("روش عمل عیده پردازی", "تکنیک گرافیکیست است برای ترسیم ارتباط میان قسمتهای مختلف اطلاعات"));
                flashcardsArrayList.add(new Flashcards("روش اسکمپر", "تکنیکی ساده کاربردی و قدرتمند شامل مجموعهای از واژه های سوال برانگیز که راه حل های بیشتر و باکیفیت تری برای حل مسئله ارائه می دهند"));
                flashcardsArrayList.add(new Flashcards("مراحل اسکمپر", "1. جایگزینی 2.  ترکیب 3. سازگار کردن یا اقتباس 4. تقویت و اصلاح 5. به کار بستن دیگر کاربرد ها 6. حذف 7. معکوس کردن یا بازآرایی"));
                flashcardsArrayList.add(new Flashcards("اجزای مدل کسب و کار", "1. مشتری شناسی 2. طراحی ارزش ارزش پیشنهادی 3. تعیین کانال توزیع 4. ارتباط مشتریان 5. جریان درآمد 6. منابع کلیدی ۷ فعالیت های کلیدی ۸ شرکایی کلید این جریان هزینه"));
                flashcardsArrayList.add(new Flashcards("منابع کلیدی در مدل کسب و کار", "فیزیکی: دارایی های فیزیکی. مالی: منابع نقدی و ضمانت. اجتماعی: ارتباط و اعتماد. معنوی: حق اختراع - نشان برند..انسانی: دانش و تجربه و تخصص"));
                flashcardsArrayList.add(new Flashcards("راهبرد", "فیزیکی: دارایی های فیزیکی. مالی: منابع نقدی و ضمانت. اجتماعی: ارتباط و اعتماد. معنوی: حق اختراع - نشان برند..انسانی: دانش و تجربه و تخصص"));
                flashcardsArrayList.add(new Flashcards("منابع کلیدی در مدل کسب و کار", "استفاده از منابع محدود با بهره گیری از فرصت های موجود در محیط کسب و کار"));
                flashcardsArrayList.add(new Flashcards("تجارت الکترونیکی", "انجام هرگونه امور تجاری و بازرگانی از طریق شبکه های رایانهای"));
                flashcardsArrayList.add(new Flashcards("کار و کسب الکترونیکی", "علاوه بر خرید فروش کالا و خدمات، خدمات رسانی به مشتریان، همکاری با شرکای تجاری، برگزاری دوره های آموزش الکترونیکی، انعقاد قراردادهای همکاری به صورت الکترونیکی انجام میشود"));
                flashcardsArrayList.add(new Flashcards("ابعاد تجارت الکترونیکی", "1. محصول یا خدمات فروخته شده 2. فرایند فروش 3. عامل تحول یا واسطه"));
                flashcardsArrayList.add(new Flashcards("مزایای تجارت الکترونیک از دیدگاه فروشندگان", "1. مدیریت و تعیین راه ها ساده تر می شود 2.اضافه کردن سرویس های جدید آسان است ۳. نرخ سود دهی خوب ۴. پایین بودن هزینه های راه اندازی 5. گستردگی مشتریان از لحاظ جغرافیایی"));
                flashcardsArrayList.add(new Flashcards("مزایای تجارت الکترونیکی از دیدگاه خریدار ", "1. دسترسی راحت به اطلاعات کالاها 2. امکان نظر دهی در مورد کالاها و دیدن نظرات سایرین 3. خرید به صورت ۲۴ ساعته 4. مقایسه کالاها راحت تر انجام می شود"));
                flashcardsArrayList.add(new Flashcards("چند گروه در پرداخت الکترونیکی وجود دارند؟", "(چهار گروه)\n١- مشتری\n۲- بانک \n٣- فروشنده یا دریافت کننده\n۴- قانون گذار\n"));
                flashcardsArrayList.add(new Flashcards("معایب تجارت الکترونیکی", "1- مقایسه پذیری \n۲- امنیت داده ها \n٣- نیاز به اینترنت و هزینه پست \n۴- هزینه اولیه برای ایجاد زیر ساخت و وسایل امنیتی\n"));
                flashcardsArrayList.add(new Flashcards("پرسونای مشتری", "نمایانگر تجربه و خواسته های مشتری از محصولات و خدماتی که کار و کسب است"));
                flashcardsArrayList.add(new Flashcards("مزیت رقابتی", "عوامل یا توانمندی هایی است که شما را قادر می سازد از رقبایتان عملکرد بهتری داشته باشید"));
                flashcardsArrayList.add(new Flashcards("روش های دستیابی به اطلاعات پرسونا چیست؟", "1- نظر سنجی \n2- مصاحبه حضوری و تلفنی \n3- مصاحبه با افراد و کارمندان شرکت کار و کسب \n4- مشاهده\n"));
                flashcardsArrayList.add(new Flashcards("نقشه سفر مشتری", "فرایند تجربه مشتری از ارتباط اولیه مشارکت و درگیری او تا ارتباط بلند مدت با کار و کسب شما را تعریف میکند"));


            }
            else if (lesson.equals("تجارت الکترونیک و امنیت شبکه") && podman.equals("پودمان 2")) {
                //group_info = new String[]{"5", "", ""};
            }else if (lesson.equals("تجارت الکترونیک و امنیت شبکه") && podman.equals("پودمان 3")) {
                //group_info = new String[]{"5", "", ""};
            }else if (lesson.equals("تجارت الکترونیک و امنیت شبکه") && podman.equals("پودمان 4")) {
                //group_info = new String[]{"5", "", ""};
            }else if (lesson.equals("تجارت الکترونیک و امنیت شبکه") && podman.equals("پودمان 5")) {
                //group_info = new String[]{"5", "", ""};
            }



        }

        recyclerView=findViewById(R.id.recyclerview);
    //        flashcardsArrayList=new ArrayList<>();

        //setFlashcardsInfo();
        setAdapter();
//        createGroupList();
//        createCollection();
    }

    private void setAdapter() {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        setOnClickListener();
        adapter=new recyclerAdapter(flashcardsArrayList,listener);
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent=new Intent(getApplicationContext(),MainActivity4.class);
                intent.putExtra("Header",flashcardsArrayList.get(position).getHeader());
                intent.putExtra("Description" , flashcardsArrayList.get(position).getDescription());
                startActivity(intent);
            }
        };
    }

    private void loadChild(String[] Collection) {
        childList=new ArrayList<>();
        for (String filed: Collection) {
            childList.add(filed);
        }
    }
//    private void createCollection() {
//        collection = new HashMap<String, List<String>>();
//        loadChild(child);
//        for (int i = 0; i < group_info.length; i++) {
//            collection.put(group_info[i], childList);
//            flashcardsArrayList=new ArrayList<>();
//            flashcardsArrayList.add(new Flashcards("شبکه"));
//
//        }
//    }
//    private void createGroupList() {
//        groupList = new ArrayList<>();
//        for (String g: group_info)
//            groupList.add(g);
//    }
//    private void setFlashcardsInfo() {
//        flashcardsArrayList=new ArrayList<>();
//        flashcardsArrayList.add(new Flashcards("شبکه"));
//        flashcardsArrayList.add(new Flashcards("پایگاه"));
//        flashcardsArrayList.add(new Flashcards("نود"));
//    }
}