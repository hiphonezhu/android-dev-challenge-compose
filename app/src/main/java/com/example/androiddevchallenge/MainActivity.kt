/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.DogDetail
import com.example.androiddevchallenge.ui.DogList
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        if (currentDog != null) {
            DogDetail(currentDog!!) {
                currentDog = null
            }
        } else {
            DogList(dogList) {
                currentDog = it
            }
        }
    }
}

var currentDog: Dog? by mutableStateOf(null)
    private set

val dogList = listOf(
    Dog(
        name = "拉布拉多犬", avatar = R.drawable.dog1,
        desc = "拉布拉多犬服务于盲人，它是导盲犬，帮助了很多人类。" +
                "能够能为人类的眼睛，足以可见它的灵性是其他的犬类无人能及的，换句话说，它就是人类最好的朋友。" +
                "拉布拉多的智商也是很高的，在全球犬类中排名第六，性格也是非常温顺、忠诚、憨厚、活泼。可以说，和它相处你会很快乐，排第一，也是不足为怪了。"
    ),
    Dog(
        name = "苏格兰牧羊犬", avatar = R.drawable.dog2,
        desc = "苏格兰牧羊犬很是上镜呢！它们的性格都很温柔，最关键的是有灵性啊，聪明的狗狗谁都喜欢，当然，像二哈这种品种也是深受大家喜爱的。" +
                "苏格兰牧羊犬价格大概也在三千七百左右，在不少人心中，它很感性，偶尔也会十分固执。就是贵了些，如果你喜欢可以养一下。"
    ),
    Dog(
        name = "腊肠犬", avatar = R.drawable.dog3,
        desc = "腊肠犬原产地德国，外形酷似我们吃的腊肠，因此得名。" +
                "腊肠犬性格机灵，也非常勇敢，感官非常发达，它也是唯一会抓老鼠的狗狗，就是和猫抢饭碗呢。" +
                "当然它的价格也是通过血统来分的，一般的一千五左右，但是血统高贵的都在三千五以上。看起来不是那么可爱，但是也是有自己的个性，反正我不喜欢。"
    ),
    Dog(
        name = "爱尔兰雪达犬", avatar = R.drawable.dog4,
        desc = "爱尔兰雪达犬的外形具有迷人的魔力。" +
                "特别是它的毛发，简直就是最光滑最飘逸的了。都可以和洗发水广告里的模特的头发相比。" +
                "它是一个猎手，跑起来就如箭上的弦，热爱运动，最值得大家喜爱的一点是，它非常好驯养。喜欢运动的小伙伴可以养，这样可以让你有更好的身材。"
    ),
    Dog(
        name = "迷你雪纳瑞", avatar = R.drawable.dog5,
        desc = "迷你雪纳瑞原产地是德国。他的外形也十分有特色，它拥有长胡须、眉毛、眼睛非常明亮个，圆溜溜的看着你，就像看着整个世界。" +
                "是非常可爱的犬型之一，最可爱的就是它竖起耳朵的时候了。它的体型确实也和它的名字相称，很小，大概在三十到三十五厘米之间。" +
                "这个狗，看起来很古怪，就是耳朵有些独特，性格乖张的人可以养，反正小编不喜欢。"
    ),
    Dog(
        name = "古代牧羊犬", avatar = R.drawable.dog6,
        desc = "英国古代牧羊犬是英国最古老的牧羊犬之一，深受大家的喜爱。" +
                "他的毛发就是他的特征之一，长的都已经盖住了他的双眼。非常的有辨识度。" +
                "一些国家，在它还是幼年的时候会做一次断尾手术，这样它就能长出熊猫尾。" +
                "这个品种的牧羊犬最喜欢的就是到处闲逛，是不是叫两嗓子，不过依然很受人们的喜爱。" +
                "这个狗狗看起来，是特别的让我感觉好笑，眼睛都看不到了，狗毛特别上，就像是被狗毛遮住了双眼，喜欢的小伙伴们可以养。"
    ),
    Dog(
        name = "爱斯基摩犬", avatar = R.drawable.dog7,
        desc = "看起来小编更觉得它像狼的样子，有些可怕，我觉得只能适合胆量大的人去养。" +
                "另外提到爱斯基摩四个字，想必大家都知道爱斯基摩人吧，他们生活在条件艰苦，天气严寒的北极地区，他们还有一个名字，叫因纽特人。" +
                "在动物品种缺少的北极，爱斯基摩犬是他们最重要的的交通运输工具。爱斯基摩犬的外形酷似狼，它们的皮毛刚硬厚实，能够抵御严寒，是人们去北极必不可少的爱宠。"
    ),
    Dog(
        name = "比熊犬", avatar = R.drawable.dog8,
        desc = "看起来非常的可爱，很适合姑娘们去养，原产地是地中海，体型娇小，身体美观，毛发一般是白色，因为长得可爱，受到很多人的欢迎，特别是女孩子。" +
                "比熊犬在各种狗狗的性格中，性格是最温顺的，但同时特也是一种特别害怕孤独的狗狗，它需要人类的陪伴和关心，这点需要大家别注意一下。" +
                "它的造型被很多玩偶制造商所青睐，相信大家都看见过不少比熊犬的玩偶吧，这也可以看出它还是很有市场的。看起来非常的可爱，萌化了小编。"
    ),
    Dog(
        name = "斗牛犬", avatar = R.drawable.dog9,
        desc = "斗牛犬是国外的一种狗，来自英国，它最大的特点就是它的脸上有褶皱，又名老虎狗。" +
                "牛头犬。不得不说，我们给他们取得名字都是这么的形象贴切。斗牛犬顾名思义，就是用来挑逗公牛的，虽然说成年的斗牛犬高三十到三十六厘米，" +
                "体重22公斤，但是和一头公牛相比，它们就像是鸡蛋碰石头。因此，斗牛犬的勇敢是收到大家一致认同的，它还被很多组织和学校作为吉祥物，不信自己去网上了解一下。"
    ),
    Dog(
        name = "爱尔兰猎狼犬", avatar = R.drawable.dog10,
        desc = "听它的名字，我们就知道狗狗的来源，它来自于风景优美的爱尔兰。" +
                "它这个名字是国人根据它的特点和产地取得名字，他的英文名称是:IrishWolfhound。" +
                "爱尔兰猎狼犬是世界上体型最大的巨犬之一，它身形高大，肌肉发达，速度灵敏，但是它的性格和它的外形却刚好相反，爱尔兰猎狼犬很温柔，被人家称为“温柔的大个子”。" +
                "这种狗狗就是典型的大叔身萝莉心，适合姑娘们养。"
    )
)