package com.example.conversion;

        import android.os.Bundle;
        import android.text.Editable;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;

        import android.view.View;
        import android.widget.Spinner;

        import androidx.appcompat.app.AppCompatActivity;

        import com.google.android.gms.ads.AdRequest;
        import com.google.android.gms.ads.AdSize;
        import com.google.android.gms.ads.AdView;
        import com.google.android.gms.ads.MobileAds;
        import com.google.android.gms.ads.initialization.InitializationStatus;
        import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

        import java.util.zip.Inflater;


public class list extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    // String[] convunit = {"Select-Unit", "Sqr.Yard", "Hectare", "Acre","Sqr.Metre","Sqr.Mile","Sqr.Kilometer","Sqr.Feet","Sqr.Centimeter","Sqr.Gaj",
    //  "Bigha","Biswa","Biswa-kacha","Killa","Lessa","Dhur","Pura","Chatak","Maria","Ground","Decimal","Katha","Cent","Murabba","Sqr.Inch","Guntha","Sqr.Karam","kanal"};
    private AdView mAdView;
    String[] unit = {"Select-Unit", "Sqr.Yard", "Hectare", "Acre","Sqr.Meter","Sqr.Mile","Sqr.Kilometer","Sqr.Feet","Sqr.Centimeter","Sqr.gaj",
            "Bigha","Biswa","Biswa-kacha","Killa","Lessa","Dhur","Pura","Chatak","Marla","Ground","Decimal","Katha","Cent","Murabba","Sqr.Inch","Guntha","Sqr.Karam","kanal"};

    String[] country={"Select-State","Andhra-Pradesh","Assam","Bihar","Chhattisgarh","Gujrat","Haryana","Himachal-Pradesh","Jammu-Kashmir","Jharkhand","Karnataka"
            ,"Kerala","Madhya-Pradesh","Maharastra","Manipur","Meghalaya","Odisha","Puducherry","Punjab","Rajasthan","Sikkim","Tamil-Nadu","Telangana",
            "Tripura","Uttar-Pradesh","Uttarakhand","West-Bengal"};

    public EditText li;
    public EditText l;
    public Editable si;
    public Spinner spin2;
    public Spinner spin1;
    public Spinner spin3;
    public double ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        spin1 = (Spinner) findViewById(R.id.spinner);
        spin2 = (Spinner) findViewById(R.id.spinner1);
        spin3=(Spinner) findViewById(R.id.spinner2);

        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter Country = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        Country.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter standardunit= new ArrayAdapter(this, android.R.layout.simple_spinner_item, unit);
        standardunit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //     ArrayAdapter units= new ArrayAdapter(this, android.R.layout.simple_spinner_item, convunit);
        //   units.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin1.setAdapter(standardunit);
        spin2.setAdapter(standardunit);
        spin3.setAdapter(Country);

        li = findViewById(R.id.list);
        si = li.getText();

        l = findViewById(R.id.lis);



        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.setting,menu);
        return true;
    }

    public float cal(String i) {

        float k = Float.parseFloat(i) * 968;
        return k;

    }
    public void bigh(){
        String m = Double.toString(ans);
        l.setText(m);


    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View view, int i, long l){
        if(arg0.getSelectedItem()=="Andhra-Pradesh"||arg0.getSelectedItem()=="Chhatisgarh"||arg0.getSelectedItem()=="Karnataka"||arg0.getSelectedItem()=="Kerala"
        ||arg0.getSelectedItem()=="Jammu-Kashmir"||arg0.getSelectedItem()=="Manipur"||arg0.getSelectedItem()=="Meghalaya"||arg0.getSelectedItem()=="Maharastra"||
                arg0.getSelectedItem()=="Odhisa"||arg0.getSelectedItem()=="Puducherry"||arg0.getSelectedItem()=="Rajasthan"||arg0.getSelectedItem()=="Sikkim"
                ||arg0.getSelectedItem()=="Tamil-Nadu"||arg0.getSelectedItem()=="Telangana"||arg0.getSelectedItem()=="Tripura")

        {
            spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (adapterView.getSelectedItem() == "Sqr.yard") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.00008361274413;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 9.000000878;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.0002066115903;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Double.parseDouble(si.toString()) * 0.8361274413;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.001652892723;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 8361.274413;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 1.00000842;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 8.361274413e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.0003305785446;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.006611570893;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.003305785446;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.0002066115903;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 0.1322314179;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 0.1322314179;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) *0.00008264463616;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 0.2000000195;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.03305785446;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.003749450409;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.02066305647;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.006611570893;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.02066305647;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.000008264463614;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 1295.997534;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) *0.008264463616;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 0.2975206902;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                    }
                    if (adapterView.getSelectedItem() == "Sqr.Feet") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 0.1111111003;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.000009290303997;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) *0.00002295684113;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 0.09290303997;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) *0.0001836547291;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) *929.0303997;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 0.1111120358;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) *9.29030399e-8;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.000036373094582;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.0007346189164;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.0007346189164;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.00002295684113;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 0.01469237833;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 0.01469237833;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.000009182736455;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 0.02222222222;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.003673094582;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.0004166055604;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.0007346189164;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.00229589494;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 9.182736453e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 143.999712;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) *0.0009182736455;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * .03305785124;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                    }
                    if (adapterView.getSelectedItem() == "Sqr.Meter") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 1.19598993;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.0001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 10.76391042;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.0002471053815;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.001976843052;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 10000;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) *1.196;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.0003953686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.007907372209;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.003953686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.0002471053815;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 0.1581474442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 0.1581474442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.00009884215262;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 0.2391980093;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.03953686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.004484304933;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.02471280747;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.007907372209;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.02471280747;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.000009884215259;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 1550;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 0.009884215262;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 0.3558317494;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                    }
                    if (adapterView.getSelectedItem() == "Acre") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 4839.999529;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.4046856422;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 43560.00001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 4046.856422;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 8.000000002;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 40468564.22;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 4840.040281;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.004046856422;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1.6;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 32.00000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 16;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 640.0000002;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 640.0000002;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.4000000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 968.0000003;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 160;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 18.14733822;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 100.0091836;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 32.00000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 100.0091836;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.04;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 6272627.455;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 40.00000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 1440;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                    }
                    if (adapterView.getSelectedItem() == "Hectare") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 11959.8993;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) *107639.1042;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 2.471053815;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 10000;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 19.76843052;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) *100000000;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 11960;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.01;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 3.953686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 79.07372209;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 39.53686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 2.471053815;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 1581.474442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 1581.474442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.9884215262;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 2391.980093;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 395.3686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 44.84304933;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 247.1280747;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 73.07372209;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 247.1280747;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.09884215259;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 15500000;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 98.84215262;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 3558.31794;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 0.000119598993;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 1e-8;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 0.001076391042;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 2.471053815e-8;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 0.0001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 1.976843052e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 0.0001196;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 1e-10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 3.953686105e-8;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 7.907372209e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 3.953686105e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 2.471053815e-8;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 0.00001581474442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 0.00001581474442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 9.884215262e-9;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 0.00002391980093;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.000003953686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 4.484304933e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.000002471280747;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 7.907372209e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.000002471280747;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 9.884215259e-10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 0.155;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 9.884215262e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 0.00003558317494;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 1195989.93;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 10763910.42;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 247.1053815;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 1000000;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 1976.843052;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 1e+10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 1196000;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 395.3686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 7907.372209;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 3953.686105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 247.1053815;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 158147.4442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 158147.4442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 98.84215262;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 239198.0093;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 39536.86105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 4484.304933;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 24712.80747;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 7907.372209;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 24712.80747;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 9.884215259;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString())*1550000000;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 9884.215262;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 355831.7494;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Sqr.Gaj") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 0.9999915803;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.00008361204013;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 8.9999251;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.0002066098507;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 0.8361204013;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.001652878806;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 8361.204013;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 8.361204013e-7;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.0003305757613;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.006611515225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.003305757613;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.0002066098507;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 0.1322303045;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 0.1322303045;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.00008264394032;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 0.1999983356;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.03305757613;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.00374941884;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.0206628825;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.006611515225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.0206628825;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.000008264394029;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 1295.986622;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 0.008264394032;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 0.2975181851;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Kanal") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 604.999941;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.05058570526;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 5445;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.125;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 505.8570526;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 5058570.526;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 605.005035;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.0005058570526;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.2;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 4;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 2;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.125;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 80;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 80;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.05;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 121;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 2.268417276;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 12.50114795;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 4;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 12.50114795;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.004999999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 784078.4316;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 180;
                                bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Biswa") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 151.2499852;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.01264642632;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 1361.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.03124999999;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 126.4642632;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 1264642.632;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 151.2512587;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.0001264642632;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.05;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.03124999999;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.0125;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 30.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.5671043191;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 3.125286987;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) *  3.125286987;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.00125;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 196019.6079;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 1.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 45;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Biswa-Kacha") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 302.4999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.02529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 2722.5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.06249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 252.9285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) *0.5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 2529285.263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 302.5025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.0002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 2;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.06249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 40.0;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 40.0;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.025;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 60.5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 1.134208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 6.2500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 2;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 6.2500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.002499999999;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 392039.2158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 2.5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 90;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Killa") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 4839.999529;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.4046856422;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 43560.00001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 4046.856422;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 8.000000002;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 40468564.22;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 4840.040281;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.004046856422;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1.6;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 32.00000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 16;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 640.0000002;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 640.0000002;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.4000000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 968.0000003;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 160;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 18.14733822;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 100.0091836;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 32.00000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 100.0091836;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.04;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 6272627.455;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 40.00000001;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 1440;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Sqr.Karam") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3.361110783;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.0002810316959;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 30.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.0006944444442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2.810316959;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.005555555556;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 28103.16959;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3.361139083;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.000002810316959;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.001111111111;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.02222222222;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.01111111111;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.0006944444442;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 0.4444444444;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 0.4444444444;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.0002777777778;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 0.6722222222;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.1111111111;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.0126023182;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.06945082193;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.02222222222;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.06945082193;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.00002777777777;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 4355.991287;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 0.02777777778;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Lessa") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 7.562499262;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.0006323213158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 68.0625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.0015625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 6.323213158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.125;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 63232.13158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 7.562562937;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.000006323213158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.0025;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.05;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.025;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.0015625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.000625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 1.5125;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.02835521596;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.1562643493;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.05;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.1562643493;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.00006249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 9800.980395;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) *0.0625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 2.25;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Dhur") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 7.562499262;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.0006323213158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 68.0625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.0015625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 6.323213158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.125;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 63232.13158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 7.562562937;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.000006323213158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.0025;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.05;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.025;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.0015625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.000625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 1.5125;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.02835521596;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.1562643493;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.05;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.1562643493;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.00006249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 9800.980395;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) *0.0625;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 2.25;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Pura") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 12099.99882;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 1.011714105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 108900;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 2.499999999;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 10117.14105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 101171410.5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 12100.1007;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.01011714105;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 4;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 80;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 40;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 2.499999999;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 1600;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 1600;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 2420;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 45.36834553;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 250.0229589;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 80;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 250.0229589;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.09999999997;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 15681568.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) *100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 3600;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Chatak") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 4.999999512;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.0004180636799;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 45;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.001033057851;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 4.180636799;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.00826446281;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 41806.36799;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 5.000041611;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.000004180636799;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) *0.001652892562;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.03305785124;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.1652892562;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.001033057851;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6611570248;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 0.6611570248;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.0004132231405;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 0.1652892562;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.01874725022;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.1033152723;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.03305785124;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.1033152723;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.00004132231404;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 6479.987038;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 0.04132231405;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 1.487603306;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Marla") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 30.24999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 272.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 062.49999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 25.29285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 0.05;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 252928.5263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 30.25025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.00002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 0.01;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 0.20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 0.10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.006249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 4;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 4;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.0025;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 6.05;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 0.1134208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 0.62500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 0.20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 0.62500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.00249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 39203.92158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 9;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Sqr.Mile") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3097617.016;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 259.000259;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27878555.87;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 640.003578;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2590002.59;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5120.028626;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 2.5900025900e+10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3097643.098;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 2.59000259;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1024.005725;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20480.1145;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10240.05725;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 640.003578;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 409602.29;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 409602.29;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 256.0014313;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 619523.4637;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Marla") {
                                    ans = Float.parseFloat(si.toString()) * 102400.5725;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11614.36139;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 64006.23534;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20480.1145;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 64006.23534;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 25.60014312;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 4.014504015e+9;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25600.14313;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 921605.1526;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Ground") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3024.999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.2529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2529.285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 25292852.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3025.025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 605;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11.34208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 3920392.158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 900;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Decimal") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3024.999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.2529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2529.285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 25292852.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3025.025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 605;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11.34208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 3920392.158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 900;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Katha") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3024.999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.2529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2529.285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 25292852.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3025.025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 605;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11.34208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 3920392.158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 900;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Cent") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3024.999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.2529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2529.285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 25292852.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3025.025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 605;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11.34208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 3920392.158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 900;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Murabba") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3024.999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.2529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2529.285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 25292852.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3025.025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 605;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11.34208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 3920392.158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 900;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Sqr.Inch") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3024.999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.2529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2529.285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 25292852.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3025.025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 605;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11.34208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 3920392.158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 900;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }
                    if (adapterView.getSelectedItem() == "Guntha") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3024.999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.2529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2529.285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 25292852.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3025.025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 605;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11.34208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 3920392.158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 900;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                    }


                    if (adapterView.getSelectedItem() == "Bigha") {
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                if (adapterView.getSelectedItem() == "Sqr.Yard") {
                                    ans = Float.parseFloat(si.toString()) * 3024.999705;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Hectare") {
                                    ans = Double.parseDouble(si.toString()) * 0.2529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Feet") {
                                    ans = Float.parseFloat(si.toString()) * 27225;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Acre") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Meter") {
                                    ans = Float.parseFloat(si.toString()) * 2529.285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "kanal") {
                                    ans = Float.parseFloat(si.toString()) * 5;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Centimeter") {
                                    ans = Float.parseFloat(si.toString()) * 25292852.63;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.gaj") {
                                    ans = Float.parseFloat(si.toString()) * 3025.025175;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Kilometer") {
                                    ans = Float.parseFloat(si.toString()) * 0.002529285263;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Bigha") {
                                    ans = Float.parseFloat(si.toString()) * 1;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Biswa-kacha") {
                                    ans = Float.parseFloat(si.toString()) * 10;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Killa") {
                                    ans = Float.parseFloat(si.toString()) * 0.6249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Lessa") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Dhur") {
                                    ans = Float.parseFloat(si.toString()) * 400;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Pura") {
                                    ans = Float.parseFloat(si.toString()) * 0.25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Chatak") {
                                    ans = Float.parseFloat(si.toString()) * 605;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Maria") {
                                    ans = Float.parseFloat(si.toString()) * 100;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Ground") {
                                    ans = Float.parseFloat(si.toString()) * 11.34208638;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Decimal") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Katha") {
                                    ans = Float.parseFloat(si.toString()) * 20;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Cent") {
                                    ans = Float.parseFloat(si.toString()) * 62.500573974;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Murabba") {
                                    ans = Float.parseFloat(si.toString()) * 0.249999998;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Inch") {
                                    ans = Float.parseFloat(si.toString()) * 3920392.158;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Guntha") {
                                    ans = Float.parseFloat(si.toString()) * 25;
                                    bigh();
                                }
                                if (adapterView.getSelectedItem() == "Sqr.Karam") {
                                    ans = Float.parseFloat(si.toString()) * 900;
                                    bigh();
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
