package main

import (
    "fmt"
    "os"
)

func main() {
    // 售货机货架上的商品
    items := []string{"可乐", "雪碧", "芬达", "红牛"}

    // 商品价格表
    prices := map[string]float64{
        "可乐":  3.0,
        "雪碧":  3.0,
        "芬达":  3.5,
        "红牛":  5.0,
    }

    // 用户余额
    balance := 10.0

    // 打印货架上的商品
    fmt.Println("欢迎使用自动售货机！")
    fmt.Println("以下是本售货机提供的商品：")
    for _, item := range items {
        fmt.Printf("%s\t%.1f 元\n", item, prices[item])
    }

    // 接受用户输入
    var selection string
    fmt.Print("请输入您要购买的商品：")
    fmt.Scanln(&selection)

    // 验证用户选择是否合法
    _, ok := prices[selection]
    if !ok {
        fmt.Println("无效的选择！")
        os.Exit(1)
    }

    // 计算商品价格
    price := prices[selection]

    // 验证用户余额是否充足
    if balance < price {
        fmt.Println("余额不足，请先充值！")
        os.Exit(1)
    }

    // 扣除用户余额
    balance -= price

    // 出货
    fmt.Printf("购买成功！您已购买了%s，余额为%.1f元。\n", selection, balance)
}
