#include <iostream>
#include <algorithm>

using namespace std;

const int MAXN = 120;

struct Runner {
    string name;
    int number;
    int hours;
    int minutes;
    int seconds;

    int totalTime() {
        return hours * 3600 + minutes * 60 + seconds;
    }
};

bool cmp(Runner a, Runner b) {
    return a.totalTime() < b.totalTime();
}

int main() {
    Runner runners[MAXN];

    // 输入每个运动员的信息
    for (int i = 0; i < MAXN; i++) {
        cout << "Runner " << i + 1 << ":" << endl;
        cout << "Name: ";
        cin >> runners[i].name;
        cout << "Number: ";
        cin >> runners[i].number;
        cout << "Time (hours minutes seconds): ";
        cin >> runners[i].hours >> runners[i].minutes >> runners[i].seconds;
    }

    // 排序并输出排名结果
    sort(runners, runners + MAXN, cmp);
    for (int i = 0; i < MAXN; i++) {
        cout << "Rank " << i + 1 << ":" << endl;
        cout << "Name: " << runners[i].name << endl;
        cout << "Number: " << runners[i].number << endl;
        cout << "Time: " << runners[i].hours << "h " << runners[i].minutes << "m " << runners[i].seconds << "s" << endl;
    }

    return 0;
}
#include <iostream>
#include <string>

using namespace std;

class Courier {
public:
    string name;
    string id;
    string phone;

    void print() {
        cout << "Name: " << name << endl;
        cout << "ID: " << id << endl;
        cout << "Phone: " << phone << endl;
        cout << endl;
    }
};

int main() {
    Courier c1, c2, c3;

    // 输入快递员信息
    cout << "Courier 1:" << endl;
    cout << "Name: ";
    cin >> c1.name;
    cout << "ID: ";
    cin >> c1.id;
    cout << "Phone: ";
    cin >> c1.phone;

    cout << "Courier 2:" << endl;
    cout << "Name: ";
    cin >> c2.name;
    cout << "ID: ";
    cin >> c2.id;
    cout << "Phone: ";
    cin >> c2.phone;

    cout << "Courier 3:" << endl;
    cout << "Name: ";
    cin >> c3.name;
    cout << "ID: ";
    cin >> c3.id;
    cout << "Phone: ";
    cin >> c3.phone;

    // 输出快递员信息
    cout << "Courier Information:" << endl;
    c1.print();
    c2.print();
    c3.print();

    return 0;
}
#include <iostream>

using namespace std;

class Elevator {
public:
    int floor;          // 当前楼层
    int target_floor;   // 目标楼层
    bool up;            // 是否向上运行
    bool open;          // 是否开门

    // 构造函数
    Elevator(int f, bool u) {
        floor = f;
        up = u;
        target_floor = -1;
        open = false;
    }

    // 检查是否到达目标楼层
    bool check_target() {
        if (floor == target_floor) {
            open = true;
            return true;
        }
        return false;
    }

    // 模拟电梯向上运行
    void go_up() {
        if (floor < 30) {
            floor++;
        }
        else {
            up = false;
        }
    }

    // 模拟电梯向下运行
    void go_down() {
        if (floor > 1) {
            floor--;
        }
        else {
            up = true;
        }
    }

    // 开门
    void open_door() {
        open = true;
    }

    // 关门
    void close_door() {
        open = false;
        target_floor = -1;
    }

    // 选择目标楼层
    void select_floor(int f) {
        target_floor = f;
        if (target_floor > floor) {
            up = true;
        }
        else {
            up = false;
        }
    }

    // 输出电梯状态
    void print() {
        cout << "Floor: " << floor << endl;
        cout << "Target: " << target_floor << endl;
        cout << "Direction: ";
        if (up) {
            cout << "Up" << endl;
        }
        else {
            cout << "Down" << endl;
        }
        cout << "Door: ";
        if (open) {
            cout << "Open" << endl;
        }
        else {
            cout << "Close" << endl;
        }
        cout << endl;
    }
};

int main() {
    // 创建3个电梯对象
    Elevator e1(3, true);
    Elevator e2(16, false);
    Elevator e3(9, true);

    while (true) {
        // 电梯1的运行状态
        if (e1.check_target()) {
            e1.open_door();
        }
        else if (e1.up) {
            e1.go_up();
        }
        else {
            e1.go_down();
        }

        // 电梯2的运行状态
        if (e2.check_target()) {
            e2.open
