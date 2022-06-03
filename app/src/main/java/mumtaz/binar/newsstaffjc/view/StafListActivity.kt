package mumtaz.binar.newsstaffjc.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import mumtaz.binar.newsstaffjc.model.GetAllStaffResponseItem
import mumtaz.binar.newsstaffjc.view.ui.theme.NewsStaffJCTheme
import mumtaz.binar.newsstaffjc.viewmodel.StafViewModel

@AndroidEntryPoint
class StafListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStaffJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModelStaf = viewModel(modelClass = StafViewModel::class.java)
                    val dataStaff by viewModelStaf.dataState.collectAsState()
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "STAFF",
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        LazyColumn {
                            if (dataStaff.isEmpty()) {
                                item {

                                }
                            }
                            items(dataStaff) {
                                DisplayAllStaff(staff = it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayAllStaff(staff: GetAllStaffResponseItem) {
    //val mContext = LocalContext.current
    Column(modifier = Modifier.padding(10.dp)) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray)
            ) {
                Image(
                    painter = rememberImagePainter(data = staff.image),
                    contentDescription = "",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Nama: \n${staff.name}",
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        text = "Email: \n${staff.email}",
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    NewsStaffJCTheme {
        DisplayAllStaff(
            staff = GetAllStaffResponseItem(
                "created at",
                "desc",
                "director",
                "email",
                "1",
                "http://placeimg.com/640/480",
                "Ana"
            )
        )
    }
}