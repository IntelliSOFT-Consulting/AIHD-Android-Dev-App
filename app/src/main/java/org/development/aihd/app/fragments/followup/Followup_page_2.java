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

import org.development.aihd.app.R;
import org.development.aihd.app.common.Common;
import org.development.aihd.app.common.DateCalendar;
import org.development.aihd.app.common.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_2 extends Fragment {

    private String admitted, urination, thirst, hunger, weight_loss, fatigue, vision, impotence, numbness, cough, fever, noticable_weight_loss, night_sweats, indicator_history;
    private EditText editTextAdmissionDate, editTextDischargeDate, editTextAdmissionDetails;
    private String sputum, gene, chest_xray, antiTB, invitation_contacts, eval_IPT;
    private EditText editTextUrination, editTextThirst, editTextHunger, editTextWeightLoss, editTextFatigue, editTextVision, editTextImpotence, editTextNumbness, editTextOtherAssessment;
    private EditText editTextCough, editTextFever, editTextNoticableWeightLoss, editTextNightSweats;
    private EditText editTextSputum, editTextGene, editTextXray, editTextAntiTB, editTextInviteContact, editTextIPT;
    private EditText editTextFootRiskComments, editTextFootExamComments;
    private String peripheral_neuropathy_foot, ulcers_foot, amputation, acute_joint, low_current_risk, at_risk, high_risk, ulcerated_foot, foot_emergency;
    private String pedal_pulse, peripheral_neuropathy_exam, deformity, foot_ulcer, amputation_exam, acute_joint_exam, sensation_loss;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_2, container, false);

        editTextAdmissionDate = view.findViewById(R.id.admission_date);
        editTextDischargeDate = view.findViewById(R.id.discharge_date);
        editTextAdmissionDetails = view.findViewById(R.id.admission_details);

        editTextFootRiskComments = view.findViewById(R.id.foot_risk_comments);
        editTextFootExamComments = view.findViewById(R.id.foot_exam_comments);

        DateCalendar.date(getActivity(), editTextAdmissionDate);
        DateCalendar.date(getActivity(), editTextDischargeDate);

        textWatcher(editTextAdmissionDate, "");
        textWatcher(editTextDischargeDate, "");
        textWatcher(editTextAdmissionDetails, "");
        textWatcher(editTextFootRiskComments, "");
        textWatcher(editTextFootExamComments, "");

        admitted = urination = thirst = hunger = weight_loss = fatigue = vision = impotence = numbness =
                cough = fever = noticable_weight_loss = night_sweats = indicator_history =
                        sputum = gene = chest_xray = antiTB = invitation_contacts = eval_IPT = "";
        CheckBox checkBoxUrination = view.findViewById(R.id.checkbox_frequent_urinations);
        CheckBox checkBoxThirst = view.findViewById(R.id.checkbox_excessive_thirst);
        CheckBox checkBoxHunger = view.findViewById(R.id.checkbox_extreme_hunger);
        CheckBox checkBoxWeightLoss = view.findViewById(R.id.checkbox_unexplained_weight_loss);
        CheckBox checkBoxFatigue = view.findViewById(R.id.checkbox_increased_fatigue);
        CheckBox checkBoxVision = view.findViewById(R.id.checkbox_blurred_vision);
        CheckBox checkBoxImpotence = view.findViewById(R.id.checkbox_impotence);
        CheckBox checkBoxNumbness = view.findViewById(R.id.checkbox_numbness);

        CheckBox checkBoxCough = view.findViewById(R.id.checkbox_cough_duration);
        CheckBox checkBoxFever = view.findViewById(R.id.checkbox_fever);
        CheckBox checkBoxNoticableWeightLoss = view.findViewById(R.id.checkbox_noticable_weight_loss);
        CheckBox checkBoxNightSweats = view.findViewById(R.id.checkbox_night_sweats);

        checkBox(checkBoxUrination);
        checkBox(checkBoxThirst);
        checkBox(checkBoxHunger);
        checkBox(checkBoxWeightLoss);
        checkBox(checkBoxFatigue);
        checkBox(checkBoxVision);
        checkBox(checkBoxImpotence);
        checkBox(checkBoxNumbness);

        checkBox(checkBoxCough);
        checkBox(checkBoxFever);
        checkBox(checkBoxNoticableWeightLoss);
        checkBox(checkBoxNightSweats);

        editTextUrination = view.findViewById(R.id.frequent_urinations);
        editTextThirst = view.findViewById(R.id.excessive_thirst);
        editTextHunger = view.findViewById(R.id.extreme_hunger);
        editTextWeightLoss = view.findViewById(R.id.unexplained_weight_loss);
        editTextFatigue = view.findViewById(R.id.increased_fatigue);
        editTextVision = view.findViewById(R.id.blurred_vision);
        editTextImpotence = view.findViewById(R.id.impotence);
        editTextNumbness = view.findViewById(R.id.numbness);
        editTextOtherAssessment = view.findViewById(R.id.assessment_other);

        editTextCough = view.findViewById(R.id.cough);
        editTextFever = view.findViewById(R.id.fever);
        editTextNoticableWeightLoss = view.findViewById(R.id.noticable_weight_loss);
        editTextNightSweats = view.findViewById(R.id.night_sweats);

        editTextSputum = view.findViewById(R.id.date_sputum);
        editTextGene = view.findViewById(R.id.date_gene);
        editTextXray = view.findViewById(R.id.date_chest_xray);
        editTextAntiTB = view.findViewById(R.id.date_antiTB);
        editTextInviteContact = view.findViewById(R.id.date_invite_contacts);
        editTextIPT = view.findViewById(R.id.date_eval_IPT);

        DateCalendar.date(getActivity(), editTextSputum);
        DateCalendar.date(getActivity(), editTextGene);
        DateCalendar.date(getActivity(), editTextXray);
        DateCalendar.date(getActivity(), editTextAntiTB);
        DateCalendar.date(getActivity(), editTextInviteContact);
        DateCalendar.date(getActivity(), editTextIPT);

        textWatcher(editTextUrination, "");
        textWatcher(editTextThirst, "");
        textWatcher(editTextHunger, "");
        textWatcher(editTextWeightLoss, "");
        textWatcher(editTextFatigue, "");
        textWatcher(editTextVision, "");
        textWatcher(editTextImpotence, "");
        textWatcher(editTextNumbness, "");
        textWatcher(editTextOtherAssessment, "");

        textWatcher(editTextCough, "");
        textWatcher(editTextFever, "");
        textWatcher(editTextNoticableWeightLoss, "");
        textWatcher(editTextNightSweats, "");

        textWatcher(editTextSputum, "");
        textWatcher(editTextGene, "");
        textWatcher(editTextXray, "");
        textWatcher(editTextAntiTB, "");
        textWatcher(editTextInviteContact, "");
        textWatcher(editTextIPT, "");

        RadioButton radioButtonAdmitYes = view.findViewById(R.id.radio_admit_yes);
        RadioButton radioButtonAdmitNo = view.findViewById(R.id.radio_admit_no);
        RadioButton radioButtonIndicatorHistoryYes = view.findViewById(R.id.radio_history_contact_yes);
        RadioButton radioButtonIndicatorHistoryNo = view.findViewById(R.id.radio_history_contact_no);
        RadioButton radioButtonSputumYes = view.findViewById(R.id.radio_sputum_positive);
        RadioButton radioButtonSputumNo = view.findViewById(R.id.radio_sputum_negative);
        RadioButton radioButtonGeneYes = view.findViewById(R.id.radio_gene_positive);
        RadioButton radioButtonGeneNo = view.findViewById(R.id.radio_gene_negative);
        RadioButton radioButtonXrayYes = view.findViewById(R.id.radio_chest_normal);
        RadioButton radioButtonXrayNo = view.findViewById(R.id.radio_chest_suggestive);
        RadioButton radioButtonAntiTBYes = view.findViewById(R.id.radio_antiTB_yes);
        RadioButton radioButtonAntiTBNo = view.findViewById(R.id.radio_antiTB_no);
        RadioButton radioButtonInviteContactsYes = view.findViewById(R.id.radio_invite_contacts_yes);
        RadioButton radioButtonInviteContactsNo = view.findViewById(R.id.radio_invite_contacts_no);
        RadioButton radioButtonIPTYes = view.findViewById(R.id.radio_eval_IPT_yes);
        RadioButton radioButtonIPTNo = view.findViewById(R.id.radio_eval_IPT_no);

        radioButton(radioButtonAdmitYes);
        radioButton(radioButtonAdmitNo);
        radioButton(radioButtonIndicatorHistoryYes);
        radioButton(radioButtonIndicatorHistoryNo);
        radioButton(radioButtonSputumYes);
        radioButton(radioButtonSputumNo);
        radioButton(radioButtonGeneYes);
        radioButton(radioButtonGeneNo);
        radioButton(radioButtonXrayYes);
        radioButton(radioButtonXrayNo);
        radioButton(radioButtonAntiTBYes);
        radioButton(radioButtonAntiTBNo);
        radioButton(radioButtonInviteContactsYes);
        radioButton(radioButtonInviteContactsNo);
        radioButton(radioButtonIPTYes);
        radioButton(radioButtonIPTNo);

        CheckBox checkboxPeripheralNeuropathy = view.findViewById(R.id.checkbox_peripheral_neuropathy);
        CheckBox checkboxUlcers = view.findViewById(R.id.checkbox_ulcers);
        CheckBox checkboxAmputation = view.findViewById(R.id.checkbox_amputation);
        CheckBox checkboxAcuteJoint = view.findViewById(R.id.checkbox_acute_joint);
        CheckBox checkboxLowRisk = view.findViewById(R.id.checkbox_low_risk);
        CheckBox checkboxAtRisk = view.findViewById(R.id.checkbox_at_risk);
        CheckBox checkboxHighRisk = view.findViewById(R.id.checkbox_high_risk);
        CheckBox checkboxUlceratedFoot = view.findViewById(R.id.checkbox_ulcerated_foot);
        CheckBox checkboxFootEmergency = view.findViewById(R.id.checkbox_foot_emergency);

        checkBox(checkboxPeripheralNeuropathy);
        checkBox(checkboxUlcers);
        checkBox(checkboxAmputation);
        checkBox(checkboxAcuteJoint);
        checkBox(checkboxLowRisk);
        checkBox(checkboxAtRisk);
        checkBox(checkboxHighRisk);
        checkBox(checkboxUlceratedFoot);
        checkBox(checkboxFootEmergency);

        RadioButton radioButtonTreatmentPedalPulse = view.findViewById(R.id.radio_foot_exam_treatment_pedal_pulse);
        RadioButton radioButtonResolvedPedalPulse = view.findViewById(R.id.radio_foot_exam_resolved_pedal_pulse);
        RadioButton radioButtonReferralPedalPulse = view.findViewById(R.id.radio_foot_exam_referral_pedal_pulse);
        RadioButton radioButtonFootSavedPedalPulse = view.findViewById(R.id.radio_foot_exam_saved_pedal_pulse);

        RadioButton radioButtonTreatmentPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_treatment_peripheral_neuropathy);
        RadioButton radioButtonResolvedPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_resolved_peripheral_neuropathy);
        RadioButton radioButtonReferralPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_referral_peripheral_neuropathy);
        RadioButton radioButtonFootSavedPPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_saved_peripheral_neuropathy);

        RadioButton radioButtonTreatmentDeformity = view.findViewById(R.id.radio_foot_exam_treatment_deformity);
        RadioButton radioButtonResolvedDeformity = view.findViewById(R.id.radio_foot_exam_resolved_deformity);
        RadioButton radioButtonReferralDeformity = view.findViewById(R.id.radio_foot_exam_referral_deformity);
        RadioButton radioButtonFootSavedDeformity = view.findViewById(R.id.radio_foot_exam_saved_deformity);

        RadioButton radioButtonTreatmentFootUcler = view.findViewById(R.id.radio_foot_exam_treatment_foot_ulcer);
        RadioButton radioButtonResolvedFootUcler = view.findViewById(R.id.radio_foot_exam_resolved_foot_ulcer);
        RadioButton radioButtonReferralFootUcler = view.findViewById(R.id.radio_foot_exam_referral_foot_ulcer);
        RadioButton radioButtonFootSavedFootUcler = view.findViewById(R.id.radio_foot_exam_saved_foot_ulcer);

        RadioButton radioButtonTreatmentAmputation = view.findViewById(R.id.radio_foot_exam_treatment_amputation);
        RadioButton radioButtonResolvedAmputation = view.findViewById(R.id.radio_foot_exam_resolved_amputation);
        RadioButton radioButtonReferralAmputation = view.findViewById(R.id.radio_foot_exam_referral_amputation);
        RadioButton radioButtonFootSavedAmputation = view.findViewById(R.id.radio_foot_exam_saved_amputation);

        RadioButton radioButtonTreatmentAcuteJoint = view.findViewById(R.id.radio_foot_exam_treatment_acute_joint);
        RadioButton radioButtonResolvedAcuteJoint = view.findViewById(R.id.radio_foot_exam_resolved_acute_joint);
        RadioButton radioButtonReferralAcuteJoint = view.findViewById(R.id.radio_foot_exam_referral_acute_joint);
        RadioButton radioButtonFootSavedAcuteJoint = view.findViewById(R.id.radio_foot_exam_saved_acute_joint);

        RadioButton radioButtonTreatmentSensationLoss = view.findViewById(R.id.radio_foot_exam_treatment_sensation_loss);
        RadioButton radioButtonResolvedSensationLoss = view.findViewById(R.id.radio_foot_exam_resolved_sensation_loss);
        RadioButton radioButtonReferralSensationLoss = view.findViewById(R.id.radio_foot_exam_referral_sensation_loss);
        RadioButton radioButtonFootSavedSensationLoss = view.findViewById(R.id.radio_foot_exam_saved_sensation_loss);

        radioButton(radioButtonTreatmentPedalPulse);
        radioButton(radioButtonResolvedPedalPulse);
        radioButton(radioButtonReferralPedalPulse);
        radioButton(radioButtonFootSavedPedalPulse);

        radioButton(radioButtonTreatmentPeripheralNeuropathy);
        radioButton(radioButtonResolvedPeripheralNeuropathy);
        radioButton(radioButtonReferralPeripheralNeuropathy);
        radioButton(radioButtonFootSavedPPeripheralNeuropathy);

        radioButton(radioButtonTreatmentDeformity);
        radioButton(radioButtonResolvedDeformity);
        radioButton(radioButtonReferralDeformity);
        radioButton(radioButtonFootSavedDeformity);

        radioButton(radioButtonTreatmentFootUcler);
        radioButton(radioButtonResolvedFootUcler);
        radioButton(radioButtonReferralFootUcler);
        radioButton(radioButtonFootSavedFootUcler);

        radioButton(radioButtonTreatmentAmputation);
        radioButton(radioButtonResolvedAmputation);
        radioButton(radioButtonReferralAmputation);
        radioButton(radioButtonFootSavedAmputation);

        radioButton(radioButtonTreatmentAcuteJoint);
        radioButton(radioButtonResolvedAcuteJoint);
        radioButton(radioButtonReferralAcuteJoint);
        radioButton(radioButtonFootSavedAcuteJoint);

        radioButton(radioButtonTreatmentSensationLoss);
        radioButton(radioButtonResolvedSensationLoss);
        radioButton(radioButtonReferralSensationLoss);
        radioButton(radioButtonFootSavedSensationLoss);


        return view;
    }

    public void textWatcher(EditText editText, final String check) {

        editText.addTextChangedListener(new TextWatcher() {

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }


    public void radioButton(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = radioButton.getId();

                switch (value) {
                    case R.id.radio_admit_yes:
                        if (checked) {
                            admitted = "1065";
                        }
                        break;
                    case R.id.radio_admit_no:
                        if (checked) {
                            admitted = "1066";
                        }
                        break;
                    case R.id.radio_history_contact_yes:
                        if (checked) {
                            indicator_history = "1065";
                        }
                        break;
                    case R.id.radio_history_contact_no:
                        if (checked) {
                            indicator_history = "1066";
                        }
                        break;
                    case R.id.radio_sputum_positive:
                        if (checked) {
                            sputum = "703";
                        }
                        break;
                    case R.id.radio_sputum_negative:
                        if (checked) {
                            sputum = "644";
                        }
                        break;
                    case R.id.radio_gene_positive:
                        if (checked) {
                            gene = "703";
                        }
                        break;
                    case R.id.radio_gene_negative:
                        if (checked) {
                            gene = "1066";
                        }
                        break;
                    case R.id.radio_chest_normal:
                        if (checked) {
                            chest_xray = "1115";
                        }
                        break;
                    case R.id.radio_chest_suggestive:
                        if (checked) {
                            chest_xray = "165152";
                        }
                        break;
                    case R.id.radio_antiTB_yes:
                        if (checked) {
                            antiTB = "1065";
                        }
                        break;
                    case R.id.radio_antiTB_no:
                        if (checked) {
                            antiTB = "1066";
                        }
                        break;
                    case R.id.radio_invite_contacts_yes:
                        if (checked) {
                            invitation_contacts = "1065";
                        }
                        break;
                    case R.id.radio_invite_contacts_no:
                        if (checked) {
                            invitation_contacts = "1066";
                        }
                        break;
                    case R.id.radio_eval_IPT_yes:
                        if (checked) {
                            eval_IPT = "1065";
                        }
                        break;
                    case R.id.radio_eval_IPT_no:
                        if (checked) {
                            eval_IPT = "1066";
                        }
                        break;
                    case R.id.radio_foot_exam_treatment_pedal_pulse:
                        if (checked)
                            pedal_pulse = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_pedal_pulse:
                        if (checked)
                            pedal_pulse = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_pedal_pulse:
                        if (checked)
                            pedal_pulse = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_pedal_pulse:
                        if (checked)
                            pedal_pulse = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_peripheral_neuropathy:
                        peripheral_neuropathy_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_deformity:
                        if (checked)
                            deformity = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_deformity:
                        if (checked)
                            deformity = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_deformity:
                        if (checked)
                            deformity = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_deformity:
                        if (checked)
                            deformity = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_foot_ulcer:
                        if (checked)
                            foot_ulcer = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_foot_ulcer:
                        if (checked)
                            foot_ulcer = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_foot_ulcer:
                        if (checked)
                            foot_ulcer = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_foot_ulcer:
                        if (checked)
                            foot_ulcer = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_amputation:
                        if (checked)
                            amputation_exam = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_amputation:
                        if (checked)
                            amputation_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_amputation:
                        if (checked)
                            amputation_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_amputation:
                        if (checked)
                            amputation_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_acute_joint:
                        if (checked)
                            acute_joint_exam = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_acute_joint:
                        if (checked)
                            acute_joint_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_acute_joint:
                        if (checked)
                            acute_joint_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_acute_joint:
                        if (checked)
                            acute_joint_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_sensation_loss:
                        if (checked)
                            sensation_loss = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_sensation_loss:
                        if (checked)
                            sensation_loss = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_sensation_loss:
                        if (checked)
                            sensation_loss = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_sensation_loss:
                        if (checked)
                            sensation_loss = "165329";
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
                    case R.id.checkbox_frequent_urinations:
                        if (checked) {
                            urination = "137593";
                        } else {
                            urination = "";
                        }
                        break;
                    case R.id.checkbox_excessive_thirst:
                        if (checked) {
                            thirst = "140939";
                        } else {
                            thirst = "";
                        }
                        break;
                    case R.id.checkbox_extreme_hunger:
                        if (checked) {
                            hunger = "165095";
                        } else {
                            hunger = "";
                        }
                        break;
                    case R.id.checkbox_unexplained_weight_loss:
                        if (checked) {
                            weight_loss = "159214";
                        } else {
                            weight_loss = "";
                        }
                        break;
                    case R.id.checkbox_increased_fatigue:
                        if (checked) {
                            fatigue = "165096";
                        } else {
                            fatigue = "";
                        }
                        updateValues();
                        break;
                    case R.id.checkbox_blurred_vision:
                        if (checked) {
                            vision = "147104";
                        } else {
                            vision = "";
                        }
                        updateValues();
                        break;
                    case R.id.checkbox_impotence:
                        if (checked) {
                            impotence = "137679";
                        } else {
                            impotence = "";
                        }
                        break;
                    case R.id.checkbox_numbness:
                        if (checked) {
                            numbness = "165097";
                        } else {
                            numbness = "";
                        }
                        break;
                    case R.id.checkbox_cough_duration:
                        if (checked) {
                            cough = "159799";
                        } else {
                            cough = "";
                        }
                        break;
                    case R.id.checkbox_fever:
                        if (checked) {
                            fever = "140238";
                        } else {
                            fever = "";
                        }
                        break;
                    case R.id.checkbox_noticable_weight_loss:
                        if (checked) {
                            noticable_weight_loss = "150796";
                        } else {
                            noticable_weight_loss = "";
                        }
                        break;
                    case R.id.checkbox_night_sweats:
                        if (checked) {
                            night_sweats = "133027";
                        } else {
                            night_sweats = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_neuropathy:
                        if (checked) {
                            peripheral_neuropathy_foot = "118983";
                        } else {
                            peripheral_neuropathy_foot = "";
                        }
                        break;
                    case R.id.checkbox_ulcers:
                        if (checked) {
                            ulcers_foot = "123919";
                        } else {
                            ulcers_foot = "";
                        }
                        break;
                    case R.id.checkbox_amputation:
                        if (checked) {
                            amputation = "164009";
                        } else {
                            amputation = "";
                        }
                        break;
                    case R.id.checkbox_acute_joint:
                        if (checked) {
                            acute_joint = "165317";
                        } else {
                            acute_joint = "";
                        }
                        break;
                    case R.id.checkbox_low_risk:
                        if (checked) {
                            low_current_risk = "165338";
                        } else {
                            low_current_risk = "";
                        }
                        break;
                    case R.id.checkbox_at_risk:
                        if (checked) {
                            at_risk = "165321";
                        } else {
                            at_risk = "";
                        }
                        break;
                    case R.id.checkbox_high_risk:
                        if (checked) {
                            high_risk = "165320";
                        } else {
                            high_risk = "";
                        }
                        break;
                    case R.id.checkbox_ulcerated_foot:
                        if (checked) {
                            ulcerated_foot = "163411";
                        } else {
                            ulcerated_foot = "";
                        }
                        break;
                    case R.id.checkbox_foot_emergency:
                        if (checked) {
                            foot_emergency = "165319";
                        } else {
                            foot_emergency = "";
                        }
                        break;
                }

                updateValues();

            }
        });
    }


    public void updateValues() {

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("165334", "", "valueCoded", admitted, DateCalendar.date(), editTextUrination.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("1640", "", "valueDate", editTextAdmissionDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1641", "", "valueDate", editTextDischargeDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("162879", "", "valueText", editTextAdmissionDetails.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", urination, DateCalendar.date(), editTextUrination.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", thirst, DateCalendar.date(), editTextThirst.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", hunger, DateCalendar.date(), editTextHunger.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", weight_loss, DateCalendar.date(), editTextWeightLoss.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", fatigue, DateCalendar.date(), editTextFatigue.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", vision, DateCalendar.date(), editTextVision.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", impotence, DateCalendar.date(), editTextImpotence.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", numbness, DateCalendar.date(), editTextNumbness.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165379", "", "valueText", editTextOtherAssessment.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("159800", "", "valueCoded", cough, DateCalendar.date(), editTextCough.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("159800", "", "valueCoded", fever, DateCalendar.date(), editTextFever.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("159800", "", "valueCoded", noticable_weight_loss, DateCalendar.date(), editTextNoticableWeightLoss.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("159800", "", "valueCoded", night_sweats, DateCalendar.date(), editTextNightSweats.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165193", "", "valueCoded", indicator_history, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("307", "", "valueCoded", sputum, DateCalendar.date(), editTextSputum.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("162202", "", "valueCoded", gene, DateCalendar.date(), editTextGene.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("12", "", "valueCoded", chest_xray, DateCalendar.date(), editTextXray.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165332", "", "valueCoded", antiTB, DateCalendar.date(), editTextAntiTB.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("164072", "", "valueCoded", invitation_contacts, DateCalendar.date(), editTextInviteContact.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("162275", "", "valueCoded", eval_IPT, DateCalendar.date(), editTextIPT.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", peripheral_neuropathy_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", ulcers_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", amputation, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", acute_joint, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165337", "", "valueText", editTextFootRiskComments.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", low_current_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", at_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", high_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", ulcerated_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", foot_emergency, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165339", "", "valueCoded", pedal_pulse, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165324", "", "valueCoded", peripheral_neuropathy_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165325", "", "valueCoded", deformity, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165326", "", "valueCoded", foot_ulcer, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165340", "", "valueCoded", amputation_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165327", "", "valueCoded", acute_joint_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165328", "", "valueCoded", sensation_loss, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165337", "", "valueText", editTextFootExamComments.getText().toString().trim(), DateCalendar.date(), ""));


        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON FollowUp Page 2", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpTwo(jsonArry);
    }
}
