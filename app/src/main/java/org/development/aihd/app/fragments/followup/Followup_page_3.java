package org.development.aihd.app.fragments.followup;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import org.development.aihd.app.common.Common;
import org.development.aihd.app.R;
import org.development.aihd.app.common.DateCalendar;
import org.development.aihd.app.common.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import customfonts.TextView_Roboto_Bold;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_3 extends Fragment {

    private View view;
    private EditText editTextSystolic, editTextDiastolic, editTextRespiratoryRate;
    private EditText editTextWaist, editTextHip, editTextHeight, editTextWeight, editTextNutrition;
    private TextView_Roboto_Bold textViewBMI, textViewWaistHipRatio;
    private String foot_exam, eye_exam, dental_exam, eye_checkup;
    private String cardiovascular_disease, high_blood_pressure, high_cholestrol, peripheral_vascular_disease,
            peripheral_neuropathy, autonomic_neuropathy, retinopathy, kidney_disease, asthma_COPD,
            arthritis, foot, assesment_other, foot_amputation;
    private EditText editTextCardiovascularDisease, editTextHBP, editTextHighCholestrol, editTextVascularDisease, editTextPNeuropathy, editTextANeuropathy,
            editTextRetinopathy, editTextKidneyDisease, editTextAsthma, editTextArthritis, editTextFoot, editTextOther;
    private EditText editTextLMP,editTextCVS, editTextRS, editTextPA, editTextCNS, editTextDental, editTextSleepDisorder, editTextSubstanceAbuse;
    private String lmp,cvs_pulse, cvs_jvp, cvs_pallor, cvs_heart, rs_rr, rs_air, rs_sounds, pa_organomegally, pa_ascities, cns_motor, cns_sensory,
            cns_autonomic,gum_disease,oral_fessions,sleep_disorder,substance_abuse,depression;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dm_followup_fragment_3, container, false);

        editTextSystolic = view.findViewById(R.id.followup_systolic);
        editTextDiastolic = view.findViewById(R.id.followup_diastolic);

        editTextWaist = view.findViewById(R.id.followup_waist_circ);
        editTextHip = view.findViewById(R.id.followup_hip_circ);
        editTextHeight = view.findViewById(R.id.followup_height);
        editTextWeight = view.findViewById(R.id.followup_weight);
        editTextNutrition = view.findViewById(R.id.followup_nutrition);

        editTextCardiovascularDisease = view.findViewById(R.id.details_cardiovascular_disease);
        editTextHBP = view.findViewById(R.id.details_high_bp);
        editTextHighCholestrol = view.findViewById(R.id.details_high_cholestrol);
        editTextVascularDisease = view.findViewById(R.id.details_peripheral_vascular_disease);
        editTextPNeuropathy = view.findViewById(R.id.details_peripheral_neuropathy);
        editTextANeuropathy = view.findViewById(R.id.details_autonomic_neuropathy);
        editTextRetinopathy = view.findViewById(R.id.details_retinopathy);
        editTextKidneyDisease = view.findViewById(R.id.details_kidney_disease);
        editTextAsthma = view.findViewById(R.id.details_asthma_COPD);
        editTextArthritis = view.findViewById(R.id.details_arthritis);
        editTextFoot = view.findViewById(R.id.details_foot);
        editTextOther = view.findViewById(R.id.details_assesment_other);
        editTextRespiratoryRate = view.findViewById(R.id.respiratory_rate);

        editTextCVS = view.findViewById(R.id.describe_cvs);
        editTextRS = view.findViewById(R.id.describe_rs);
        editTextPA = view.findViewById(R.id.describe_pa);
        editTextCNS = view.findViewById(R.id.describe_cns);
        editTextDental = view.findViewById(R.id.describe_dental);
        editTextSleepDisorder = view.findViewById(R.id.describe_sleep_disorder);
        editTextSubstanceAbuse = view.findViewById(R.id.describe_substance_abuse);
        editTextLMP= view.findViewById(R.id.date_lmp);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        editTextLMP.setText(dateFormat.format(new Date()));

        DateCalendar.date(getActivity(), editTextLMP);

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");

        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        textWatcher(editTextRespiratoryRate, "respiratoryRate");

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");

        textWatcher(editTextHeight, "bmi");
        textWatcher(editTextWeight, "bmi");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");
        textWatcher(editTextLMP,"");

        textWatcher(editTextCVS, "");
        textWatcher(editTextRS, "");
        textWatcher(editTextPA, "");
        textWatcher(editTextCNS, "");
        textWatcher(editTextDental, "");
        textWatcher(editTextSleepDisorder, "");
        textWatcher(editTextSubstanceAbuse, "");

        textWatcher(editTextCardiovascularDisease, "");
        textWatcher(editTextHBP, "");
        textWatcher(editTextHighCholestrol, "");
        textWatcher(editTextVascularDisease, "");
        textWatcher(editTextPNeuropathy, "");
        textWatcher(editTextANeuropathy, "");
        textWatcher(editTextRetinopathy, "");
        textWatcher(editTextKidneyDisease, "");
        textWatcher(editTextAsthma, "");
        textWatcher(editTextArthritis, "");
        textWatcher(editTextFoot, "");
        textWatcher(editTextOther, "");

        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        CheckBox checkBoxCardiovascularDisease = view.findViewById(R.id.checkbox_cardiovascular_disease);
        CheckBox checkBoxHBP = view.findViewById(R.id.checkbox_high_BP);
        CheckBox checkBoxHighCholestrol = view.findViewById(R.id.checkbox_high_cholestrol);
        CheckBox checkBoxVascularDisease = view.findViewById(R.id.checkbox_peripheral_vascular_disease);
        CheckBox checkBoxPNeuropathy = view.findViewById(R.id.checkbox_peripheral_neuropathy_assesment);
        CheckBox checkBoxANeuropathy = view.findViewById(R.id.checkbox_autonomic_neuropathy);
        CheckBox checkBoxRetinopathy = view.findViewById(R.id.checkbox_retinopathy);
        CheckBox checkBoxKidneyDisease = view.findViewById(R.id.checkbox_kidney_disease);
        CheckBox checkBoxAsthma = view.findViewById(R.id.checkbox_asthma_COPD);
        CheckBox checkBoxArthritis = view.findViewById(R.id.checkbox_arthritis);
        CheckBox checkBoxFoot = view.findViewById(R.id.checkbox_foot);
        CheckBox checkBoxOther = view.findViewById(R.id.checkbox_assesment_other);

        CheckBox checkBoxGumDisease = view.findViewById(R.id.exam_gum_disease);
        CheckBox checkBoxOralFessions = view.findViewById(R.id.exam_oral_fessions);
        CheckBox checkBoxSleepDisorder = view.findViewById(R.id.exam_sleep_disorder);
        CheckBox checkBoxSubstanceAbuse = view.findViewById(R.id.exam_substance_abuse);
        CheckBox checkBoxDepression = view.findViewById(R.id.exam_depression);

        checkBox(checkBoxCardiovascularDisease);
        checkBox(checkBoxHBP);
        checkBox(checkBoxHighCholestrol);
        checkBox(checkBoxVascularDisease);
        checkBox(checkBoxPNeuropathy);
        checkBox(checkBoxANeuropathy);
        checkBox(checkBoxRetinopathy);
        checkBox(checkBoxKidneyDisease);
        checkBox(checkBoxAsthma);
        checkBox(checkBoxArthritis);
        checkBox(checkBoxFoot);
        checkBox(checkBoxOther);

        checkBox(checkBoxGumDisease);
        checkBox(checkBoxOralFessions);
        checkBox(checkBoxSleepDisorder);
        checkBox(checkBoxSubstanceAbuse);
        checkBox(checkBoxDepression);

        RadioButton radioButtonFootAmputationYes = view.findViewById(R.id.radio_foot_amputations_yes);
        RadioButton radioButtonFootAmputationNo = view.findViewById(R.id.radio_foot_amputations_no);

        RadioButton radioButtonPregnancyYes = view.findViewById(R.id.radio_pregnancy_yes);
        RadioButton radioButtonFPregnancyNo = view.findViewById(R.id.radio_pregnancy_no);
        RadioButton radioButtonPregnancyNA = view.findViewById(R.id.radio_pregnancy_na);

        RadioButton radioButtonCVSPulseNormal = view.findViewById(R.id.radio_cvs_normal_pulse);
        RadioButton radioButtonCVSPulseAbnormal = view.findViewById(R.id.radio_cvs_abnormal_pulse);
        RadioButton radioButtonCVSJVPNormal = view.findViewById(R.id.radio_cvs_normal_jvp);
        RadioButton radioButtonCVSJVPAbnormal = view.findViewById(R.id.radio_cvs_abnormal_jvp);
        RadioButton radioButtonCVSPallorNormal = view.findViewById(R.id.radio_cvs_normal_pallor);
        RadioButton radioButtonCVSPallorAbnormal = view.findViewById(R.id.radio_cvs_abnormal_pallor);
        RadioButton radioButtonCVSHeartNormal = view.findViewById(R.id.radio_cvs_normal_heart);
        RadioButton radioButtonCVSHeartAbnormal = view.findViewById(R.id.radio_cvs_abnormal_heart);

        RadioButton radioButtonRSRRNormal = view.findViewById(R.id.radio_rs_normal_rr);
        RadioButton radioButtonRSRRAbnormal = view.findViewById(R.id.radio_rs_abnormal_rr);
        RadioButton radioButtonRSAirNormal = view.findViewById(R.id.radio_rs_normal_air_entry);
        RadioButton radioButtonRSAirAbnormal = view.findViewById(R.id.radio_rs_abnormal_air_entry);
        RadioButton radioButtonRSSoundNormal = view.findViewById(R.id.radio_rs_normal_sounds);
        RadioButton radioButtonRSSoundAbnormal = view.findViewById(R.id.radio_rs_abnormal_sounds);

        RadioButton radioButtonPAOrganomegallyNormal = view.findViewById(R.id.radio_pa_normal_organomegally);
        RadioButton radioButtonPAOrganomegallyAbnormal = view.findViewById(R.id.radio_pa_abnormal_organomegally);
        RadioButton radioButtonPAAscitiesNormal = view.findViewById(R.id.radio_pa_normal_ascities);
        RadioButton radioButtonPAAscitiesAbnormal = view.findViewById(R.id.radio_pa_abnormal_ascities);

        RadioButton radioButtonCNSMotorNormal = view.findViewById(R.id.radio_cns_normal_motor);
        RadioButton radioButtonCNSMotorAbnormal = view.findViewById(R.id.radio_cns_abnormal_motor);
        RadioButton radioButtonCNSSensoryNormal = view.findViewById(R.id.radio_cns_normal_sensory);
        RadioButton radioButtonCNSSensoryAbnormal = view.findViewById(R.id.radio_cns_abnormal_sensory);
        RadioButton radioButtonCNSAutonomicNormal = view.findViewById(R.id.radio_cns_normal_autonomic);
        RadioButton radioButtonCNSAutonomicAbnormal = view.findViewById(R.id.radio_cns_abnormal_autonomic);

        radioButton(radioButtonFootAmputationYes);
        radioButton(radioButtonFootAmputationNo);

        radioButton(radioButtonPregnancyYes);
        radioButton(radioButtonFPregnancyNo);
        radioButton(radioButtonPregnancyNA);

        radioButton(radioButtonCVSPulseNormal);
        radioButton(radioButtonCVSPulseAbnormal);
        radioButton(radioButtonCVSJVPNormal);
        radioButton(radioButtonCVSJVPAbnormal);
        radioButton(radioButtonCVSPallorNormal);
        radioButton(radioButtonCVSPallorAbnormal);
        radioButton(radioButtonCVSHeartNormal);
        radioButton(radioButtonCVSHeartAbnormal);

        radioButton(radioButtonRSRRNormal);
        radioButton(radioButtonRSRRAbnormal);
        radioButton(radioButtonRSAirNormal);
        radioButton(radioButtonRSAirAbnormal);
        radioButton(radioButtonRSSoundNormal);
        radioButton(radioButtonRSSoundAbnormal);

        radioButton(radioButtonPAOrganomegallyNormal);
        radioButton(radioButtonPAOrganomegallyAbnormal);
        radioButton(radioButtonPAAscitiesNormal);
        radioButton(radioButtonPAAscitiesAbnormal);

        radioButton(radioButtonCNSMotorNormal);
        radioButton(radioButtonCNSMotorAbnormal);
        radioButton(radioButtonCNSSensoryNormal);
        radioButton(radioButtonCNSSensoryAbnormal);
        radioButton(radioButtonCNSAutonomicNormal);
        radioButton(radioButtonCNSAutonomicAbnormal);


        return view;
    }

    public void textWatcher(EditText editText, final String check) {

        editText.addTextChangedListener(new TextWatcher() {

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void afterTextChanged(final Editable editable) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        switch (check) {
                            case "blood_pressure":
                                if (editTextSystolic != null && editTextDiastolic != null) {
                                    Common.checkBP(view, editTextSystolic, editTextDiastolic);
                                }
                                break;
                            case "respiratoryRate":
                                Common.checkRespiratory(view, editable.toString());
                                break;
                            case "bmi":
                                Common.bmi(getContext(), editTextHeight, editTextWeight, textViewBMI);
                                break;
                            case "whr":
                                Common.whr(editTextWaist, editTextHip, textViewWaistHipRatio);
                                break;
                            default:
                                break;
                        }

                    }
                }, 3000);

                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                /* Do nothing*/
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                /* Do nothing*/
            }
        });
    }


    public void radioButton(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                switch (radioButton.getId()) {
                    case R.id.radio_pregnancy_yes:
                        if (checked) {
                            lmp = "1065";
                        }
                        break;
                    case R.id.radio_pregnancy_no:
                        if (checked) {
                            lmp = "1066";
                        }
                        break;
                    case R.id.radio_pregnancy_na:
                        if (checked)
                            lmp = "1175";
                        break;
                    case R.id.radio_foot_amputations_yes:
                        if (checked) {
                            foot_amputation = "1065";
                        }
                        break;
                    case R.id.radio_foot_amputations_no:
                        if (checked) {
                            foot_amputation = "1066";
                        }
                        break;
                    case R.id.radio_cvs_normal_pulse:
                        if (checked)
                            cvs_pulse = "1115";
                        break;
                    case R.id.radio_cvs_abnormal_pulse:
                        if (checked)
                            cvs_pulse = "1116";
                        break;
                    case R.id.radio_cvs_normal_jvp:
                        if (checked)
                            cvs_jvp = "1115";
                        break;
                    case R.id.radio_cvs_abnormal_jvp:
                        if (checked)
                            cvs_jvp = "1116";
                        break;
                    case R.id.radio_cvs_normal_pallor:
                        if (checked)
                            cvs_pallor = "1115";
                        break;
                    case R.id.radio_cvs_abnormal_pallor:
                        if (checked)
                            cvs_pallor = "1116";
                        break;
                    case R.id.radio_cvs_normal_heart:
                        if (checked)
                            cvs_heart = "1115";
                        break;
                    case R.id.radio_cvs_abnormal_heart:
                        if (checked)
                            cvs_heart = "1116";
                        break;
                    case R.id.radio_rs_normal_rr:
                        if (checked)
                            rs_rr = "1115";
                        break;
                    case R.id.radio_rs_abnormal_rr:
                        if (checked)
                            rs_rr = "1116";
                        break;
                    case R.id.radio_rs_normal_air_entry:
                        if (checked)
                            rs_air = "1115";
                        break;
                    case R.id.radio_rs_abnormal_air_entry:
                        if (checked)
                            rs_air = "1116";
                        break;
                    case R.id.radio_rs_normal_sounds:
                        if (checked)
                            rs_sounds = "1115";
                        break;
                    case R.id.radio_rs_abnormal_sounds:
                        if (checked)
                            rs_sounds = "1116";
                        break;

                    case R.id.radio_pa_normal_organomegally:
                        if (checked)
                            pa_organomegally = "1115";
                        break;
                    case R.id.radio_pa_abnormal_organomegally:
                        if (checked)
                            pa_organomegally = "1116";
                        break;
                    case R.id.radio_pa_normal_ascities:
                        if (checked)
                            pa_ascities = "1115";
                        break;
                    case R.id.radio_pa_abnormal_ascities:
                        if (checked)
                            pa_ascities = "1116";
                        break;
                    case R.id.radio_cns_normal_motor:
                        if (checked)
                            cns_motor = "1115";
                        break;
                    case R.id.radio_cns_abnormal_motor:
                        if (checked)
                            cns_motor = "1116";
                        break;
                    case R.id.radio_cns_normal_sensory:
                        if (checked)
                            cns_sensory = "1115";
                        break;
                    case R.id.radio_cns_abnormal_sensory:
                        if (checked)
                            cns_sensory = "1116";
                        break;
                    case R.id.radio_cns_normal_autonomic:
                        if (checked)
                            cns_autonomic = "1115";
                        break;
                    case R.id.radio_cns_abnormal_autonomic:
                        if (checked)
                            cns_autonomic = "1116";
                        break;
                    default:
                        break;
                }
                updateValues();
            }
        });
    }


    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.checkbox_foot_exam:
                        if (checked) {
                            foot_exam = "165099";
                        } else {
                            foot_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_exam:
                        if (checked) {
                            eye_exam = "165100";
                        } else {
                            eye_exam = "";
                        }
                        break;
                    case R.id.checkbox_dental_exam:
                        if (checked) {
                            dental_exam = "165101";
                        } else {
                            dental_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_check_up:
                        if (checked) {
                            eye_checkup = "165102";
                        } else {
                            eye_checkup = "";
                        }
                        break;
                    case R.id.checkbox_cardiovascular_disease:
                        if (checked) {
                            cardiovascular_disease = "119270";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_high_BP:
                        if (checked) {
                            high_blood_pressure = "117399";
                        } else {
                            high_blood_pressure = "";
                        }
                        break;
                    case R.id.checkbox_high_cholestrol:
                        if (checked) {
                            high_cholestrol = "117460";
                        } else {
                            high_cholestrol = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_vascular_disease:
                        if (checked) {
                            peripheral_vascular_disease = "114212";
                        } else {
                            peripheral_vascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_neuropathy_assesment:
                        if (checked) {
                            peripheral_neuropathy = "118983";
                        } else {
                            peripheral_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_autonomic_neuropathy:
                        if (checked) {
                            autonomic_neuropathy = "155215";
                        } else {
                            autonomic_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_retinopathy:
                        if (checked) {
                            retinopathy = "113257";
                        } else {
                            retinopathy = "";
                        }
                        break;
                    case R.id.checkbox_kidney_disease:
                        if (checked) {
                            kidney_disease = "6033";
                        } else {
                            kidney_disease = "";
                        }
                        break;
                    case R.id.checkbox_asthma_COPD:
                        if (checked) {
                            asthma_COPD = "121375";
                        } else {
                            asthma_COPD = "";
                        }
                        break;
                    case R.id.checkbox_arthritis:
                        if (checked) {
                            arthritis = "148432";
                        } else {
                            arthritis = "";
                        }
                        break;
                    case R.id.checkbox_foot:
                        if (checked) {
                            foot = "165104";
                        } else {
                            foot = "";
                        }
                        break;
                    case R.id.checkbox_assesment_other:
                        if (checked) {
                            assesment_other = "5622";
                        } else {
                            assesment_other = "";
                        }
                        break;
                    case R.id.exam_gum_disease:
                        if (checked) {
                            gum_disease = "165358";
                        } else {
                            gum_disease = "";
                        }
                        break;
                    case R.id.exam_oral_fessions:
                        if (checked) {
                            oral_fessions = "165359";
                        } else {
                            oral_fessions = "";
                        }
                        break;
                    case R.id.exam_sleep_disorder:
                        if (checked) {
                            sleep_disorder = "112930";
                        } else {
                            sleep_disorder = "";
                        }
                        break;
                    case R.id.exam_substance_abuse:
                        if (checked) {
                            substance_abuse = "112603";
                        } else {
                            substance_abuse = "";
                        }
                        break;
                    case R.id.exam_depression:
                        if (checked) {
                            depression = "119537";
                        } else {
                            depression = "";
                        }
                        break;

                    default:
                        break;
                }
                updateValues();
            }
        });
    }


    public void updateValues() {

        JSONArray jsonArry = new JSONArray();
        JSONArray jsonGroup = new JSONArray();

        JSONArray jsonArry1 = new JSONArray();
        JSONArray jsonArry2 = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("5090", "", "valueNumeric", editTextHeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5089", "", "valueNumeric", editTextWeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5085", "", "valueNumeric", editTextSystolic.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5086", "", "valueNumeric", editTextDiastolic.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163081", "", "valueNumeric", editTextHip.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163080", "", "valueNumeric", editTextWaist.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5242", "", "valueNumeric", editTextRespiratoryRate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165190", "", "valueText", editTextNutrition.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", foot_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", eye_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", dental_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", eye_checkup, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5272", "", "valueCoded", lmp, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1427", "", "valueText", editTextLMP.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", cardiovascular_disease, DateCalendar.date(), editTextCardiovascularDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", high_blood_pressure, DateCalendar.date(), editTextHBP.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", high_cholestrol, DateCalendar.date(), editTextHighCholestrol.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", peripheral_vascular_disease, DateCalendar.date(), editTextVascularDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", peripheral_neuropathy, DateCalendar.date(), editTextPNeuropathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", autonomic_neuropathy, DateCalendar.date(), editTextANeuropathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", retinopathy, DateCalendar.date(), editTextRetinopathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", kidney_disease, DateCalendar.date(), editTextKidneyDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", asthma_COPD, DateCalendar.date(), editTextAsthma.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", arthritis, DateCalendar.date(), editTextArthritis.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", foot, DateCalendar.date(), editTextFoot.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", assesment_other, DateCalendar.date(), editTextOther.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("165104", "", "valueCoded", foot_amputation, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165345", "", "valueCoded", cvs_pulse, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165346", "", "valueCoded", cvs_jvp, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5245", "", "valueCoded", cvs_pallor, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165349", "", "valueCoded", cvs_heart, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163046", "", "valueText", editTextCVS.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165350", "", "valueCoded", rs_rr, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165351", "", "valueCoded", rs_air, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("113316", "", "valueCoded", rs_sounds, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1123", "", "valueText", editTextRS.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165352", "", "valueCoded", pa_organomegally, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165353", "", "valueCoded", pa_ascities, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165354", "", "valueText", editTextPA.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("163579", "", "valueCoded", cns_motor, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165355", "", "valueCoded", cns_sensory, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165356", "", "valueCoded", cns_autonomic, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165357", "", "valueText", editTextCNS.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165358", "", "valueCoded", gum_disease, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165359", "", "valueCoded", oral_fessions, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165360", "", "valueText", editTextDental.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("119537", "", "valueCoded", depression, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("112930", "", "valueCoded", sleep_disorder, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163044", "", "valueText", editTextSleepDisorder.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("112603", "", "valueCoded", substance_abuse, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165362", "", "valueText", editTextSubstanceAbuse.getText().toString().trim(), DateCalendar.date(), ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);

            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry1), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry2), jsonGroup);

            if (jsonGroup.length() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("groups", jsonGroup);

                jsonArry.put(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("JSON FollowUp Page 3", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpThree(jsonArry);
    }

}
