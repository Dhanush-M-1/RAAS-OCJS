#include <bits/stdc++.h>
using namespace std;
int main(void) {
  bool flag1 = true, flag2 = true, flag3 = true;
  string input;
  string count_1 = "", count_2 = "", count_3 = "";
  cin >> input;
  for (int i = 0; i < input.length(); i++) {
    switch (input[i]) {
      case '1':
        if (flag1) {
          flag1 = false;
        } else {
          count_1 += "+";
        }
        count_1 += "1";
        break;
      case '2':
        if (flag2) {
          flag2 = false;
        } else {
          count_2 += "+";
        }
        count_2 += "2";
        break;
      case '3':
        if (flag3) {
          flag3 = false;
        } else {
          count_3 += "+";
        }
        count_3 += "3";
        break;
      default:
        continue;
    }
  }
  if (!flag1 && !flag2) count_1 += "+";
  if ((!flag1 && !flag3) || (!flag2 && !flag3)) count_2 += "+";
  cout << count_1 << count_2 << count_3 << endl;
  return 0;
}
