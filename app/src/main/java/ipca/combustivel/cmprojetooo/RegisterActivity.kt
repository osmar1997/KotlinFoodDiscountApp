package ipca.combustivel.cmprojetooo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.widget.Toast
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button1 = findViewById<Button>(R.id.buttonRegister)
        val edittextemail = findViewById<EditText>(R.id.editTextEmail)
        val edittextpassword = findViewById<EditText>(R.id.editTextPasswordregist)

        button1.setOnClickListener{
            when{
                TextUtils.isEmpty(edittextemail.text.toString().trim{
                    it <= ' '
                }) ->{
                    Toast.makeText(this@RegisterActivity, "Please Enter Email", Toast.LENGTH_SHORT).show()
                }

                TextUtils.isEmpty(edittextpassword.text.toString().trim{
                    it <= ' '
                }) ->{
                    Toast.makeText(this@RegisterActivity, "Please Enter Password", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val email: String = edittextemail.text.toString().trim{it <= ' ' }
                    val password: String = edittextpassword.text.toString().trim{it <= ' ' }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(OnCompleteListener<AuthResult>{task->
                            if(task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this@RegisterActivity,
                                    "You are registered successfully",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        })



                }
            }
        }










    }
}