#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int num1, num2, num3, num4, flag = 0;
  for (int i = 1; i < r1; i++) {
    num1 = i;
    num2 = r1 - i;
    if (c1 - num1 > 0 && num1 <= 9) {
      flag++;
      num3 = c1 - num1;
    } else {
      flag = 0;
      continue;
    }
    if (c2 - num2 > 0 && num2 <= 9) {
      flag++;
      num4 = c2 - num2;
    } else {
      flag = 0;
      continue;
    }
    if (num3 + num4 == r2 && num3 <= 9)
      flag++;
    else {
      flag = 0;
      continue;
    }
    if (num1 + num4 == d1 && num4 <= 9)
      flag++;
    else {
      flag = 0;
      continue;
    }
    if (num2 + num3 == d2)
      flag++;
    else {
      flag = 0;
      continue;
    }
    if (flag == 5 && num1 != num2 && num1 != num3 && num1 != num4 &&
        num2 != num3 && num2 != num4 && num3 != num4) {
      cout << num1 << " " << num2 << "\n" << num3 << " " << num4;
      return 0;
    }
  }
  flag = 0;
  if (flag == 0) cout << "-1";
  return 0;
}
