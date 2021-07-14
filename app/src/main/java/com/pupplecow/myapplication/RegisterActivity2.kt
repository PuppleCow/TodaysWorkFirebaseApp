package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_register1.*
import kotlinx.android.synthetic.main.activity_register2.*

class RegisterActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        //인텐트 가져오기
        //val userCellPhoneNumber=intent.getIntExtra("userCellPhoneNumber")

        //로그인아이디 자동으로 입력
        register2_loginID.text="12345678"+"전화번호 뒤 8자리"
        //비밀번호 입력받기

        //비밀번호 확인 실시간 확인하기
        //비밀번호 서로 다르면 비밀번호가 맞지않습니다. 메시지 띄우기



        //비밀번호 가리기버튼1
        //한번누르면 비밀번호 보이게하기

        //비밀번호 가리기버튼2
        //한번누르면 비밀번호 보이게하기

        //체크상태파악
        //전체동의했을때 모두 체크
        register2_checkBox_all.setOnClickListener {onCheckChanged(register2_checkBox_all)}
        register2_checkBox_1.setOnClickListener {onCheckChanged(register2_checkBox_1)}
        register2_checkBox_2.setOnClickListener {onCheckChanged(register2_checkBox_2)}
        register2_checkBox_3.setOnClickListener {onCheckChanged(register2_checkBox_3)}
        register2_checkBox_4.setOnClickListener {onCheckChanged(register2_checkBox_4)}



        //회원가입 완료버튼 눌렀을때
        register2_complete_button.setOnClickListener {
            //비밀번호 서로 같은지 확인하기
            val userPassword=register2_password_input.text.toString()
            val userPasswordCheck=register2_password_check_input.text.toString()
            if(userPassword===userPasswordCheck){
                //비밀번호 같을때

                //전체동의했는지 체크하기
                if(register2_checkBox_1.isChecked
                    && register2_checkBox_2.isChecked
                    && register2_checkBox_3.isChecked
                    && register2_checkBox_4.isChecked){
                    // 비밀번호 저장하기

                    //"정상적으로 회원가입되었습니다." 알림 띄우기기
                }else{
                    //전체동의 안하면 안내 메시지
                }

            }
            else{// 비밀번호 다를때
                register_message.text="비밀번호가 맞지 않습니다."
            }

        }

}

    fun onCheckChanged(compoundButton: CompoundButton) {
        when(compoundButton.id) {
            R.id.register2_checkBox_all -> {
                if (register2_checkBox_all.isChecked) {
                    register2_checkBox_1.isChecked = true
                    register2_checkBox_2.isChecked = true
                    register2_checkBox_3.isChecked = true
                    register2_checkBox_4.isChecked = true
                }else {
                    register2_checkBox_1.isChecked = false
                    register2_checkBox_2.isChecked = false
                    register2_checkBox_3.isChecked = false
                    register2_checkBox_4.isChecked = false
                }
            }
            else -> {
                register2_checkBox_all.isChecked = (
                        register2_checkBox_1.isChecked
                                && register2_checkBox_2.isChecked
                                && register2_checkBox_3.isChecked
                                && register2_checkBox_4.isChecked)
            }
        }

    }}
