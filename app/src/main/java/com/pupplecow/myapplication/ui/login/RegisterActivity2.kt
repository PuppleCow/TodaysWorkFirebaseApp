package com.pupplecow.myapplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pupplecow.myapplication.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register1.*
import kotlinx.android.synthetic.main.activity_register2.*

class RegisterActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        //스크롤뷰 안보이게
        register2_scrollview.visibility= View.INVISIBLE

        //인텐트 가져오기
        val intent = intent

        val userCellPhoneNumber=intent.extras!!.getString("userCellPhoneNumber")
        val userName=intent.extras!!.getString("userName")
        val userId=intent.extras!!.getString("userId")


        //로그인아이디 자동으로 입력
        val loginID=userCellPhoneNumber?.substring(4,11)
        register2_loginID.text=loginID

        //비밀번호 자동으로 입력
        val loginPW=userId?.substring(0,6)
        register2_password_input.setText(loginPW)
        register2_password_check_input.setText(loginPW)



        //비밀번호 입력받기

        //비밀번호 확인 실시간 확인하기
        //비밀번호 서로 다르면 비밀번호가 맞지않습니다. 메시지 띄우기



        //비밀번호 가리기버튼1
        //한번누르면 비밀번호 보이게하기
        register2_toggleButton.setOnClickListener{
            //비밀번호 숨기기 해제
            if(register2_toggleButton.isChecked==true) {
                register2_password_input.inputType=InputType.TYPE_CLASS_TEXT
            }
            else{
                register2_password_input.inputType= InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

            }
        }

        //비밀번호 가리기버튼2
        //한번누르면 비밀번호 보이게하기
        register2_toggleButton2.setOnClickListener{
            //비밀번호 숨기기 해제
            if(register2_toggleButton.isChecked==true) {
                register2_password_check_input.inputType=InputType.TYPE_CLASS_TEXT
            }
            else{
                register2_password_check_input.inputType= InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

            }
        }

        //약관 클릭
        register2_text_1.setOnClickListener {

            //스크롤뷰 보이게
            register2_scrollview.visibility= View.VISIBLE
            //텍스트 바꾸기
            register2_text_area.text="약관1 \n" +
                    "sdfsdfsdf\nsdfsdfsd\nsdfsdf\nsdfdf\nsdfsdf\nsdfsdf\nsdfsdfs\nsdfsdfsd\n\n\n\n\nsdfsdf\n"
        }
        register2_text_2.setOnClickListener {

            //스크롤뷰 보이게
            register2_scrollview.visibility= View.VISIBLE
            //텍스트 바꾸기
            register2_text_area.text="약관2 \n" +
                    "sdfsdfsdf\nsdfsdfsd\nsdfsdf\nsdfdf\nsdfsdf\nsdfsdf\nsdfsdfs\nsdfsdfsd\n\n\n\n\nsdfsdf\n"
        }
        register2_text_3.setOnClickListener {

            //스크롤뷰 보이게
            register2_scrollview.visibility= View.VISIBLE
            //텍스트 바꾸기
            register2_text_area.text="약관3 \n" +
                    "sdfsdfsdf\nsdfsdfsd\nsdfsdf\nsdfdf\nsdfsdf\nsdfsdf\nsdfsdfs\nsdfsdfsd\n\n\n\n\nsdfsdf\n"
        }
        register2_text_4.setOnClickListener {

            //스크롤뷰 보이게
            register2_scrollview.visibility= View.VISIBLE
            //텍스트 바꾸기
            register2_text_area.text="약관4 \n" +
                    "sdfsdfsdf\nsdfsdfsd\nsdfsdf\nsdfdf\nsdfsdf\nsdfsdf\nsdfsdfs\nsdfsdfsd\n\n\n\n\nsdfsdf\n"
        }


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

            if(userPassword==userPasswordCheck){
                //비밀번호 같을때

                //전체동의했는지 체크하기
                if(register2_checkBox_1.isChecked
                    && register2_checkBox_2.isChecked
                    && register2_checkBox_3.isChecked
                    && register2_checkBox_4.isChecked){
                    // 비밀번호 저장하기

                    //"정상적으로 회원가입되었습니다." 토스트 알림 띄우기
                    var t1 = Toast.makeText(this, "정상적으로 회원가입되었습니다.", Toast.LENGTH_SHORT)
                    t1.show()
                    //로그인페이지로 이동
                    //LoginActivity로 넘어가기
                    val intent = Intent(this@RegisterActivity2, LoginActivity::class.java)
                    startActivity(intent)



                }else{
                    //전체동의 안하면 안내 메시지
                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("")
                    builder.setMessage("동의해주세요")
                    builder.setPositiveButton("네",null)
                    builder.show()
                }

            }
            else{// 비밀번호 다를때
                register2_message.text="비밀번호가 맞지 않습니다."
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

    }
}