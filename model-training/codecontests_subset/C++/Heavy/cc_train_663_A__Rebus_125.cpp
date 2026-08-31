#include <bits/stdc++.h>
using namespace std;
int main() {
  int sum, ans, i, num[110], now;
  char ch, mk[110];
  while (cin >> ch) {
    sum = 0;
    mk[0] = '+';
    while (cin >> mk[++sum]) {
      if (mk[sum] == '=') {
        cin >> ans;
        break;
      } else
        cin >> ch;
    }
    for (i = 0; i < sum; i++) num[i] = 1;
    now = 0;
    for (i = 0; i < sum; i++) {
      if (mk[i] == '+')
        now++;
      else
        now--;
    }
    now -= ans;
    for (i = 0; i < sum; i++) {
      if (mk[i] == '+') {
        if (!now) continue;
        if (now < 0) {
          if (ans - num[i] >= -now) {
            num[i] += -now;
            now = 0;
          } else {
            now += ans - num[i];
            num[i] = ans;
          }
        }
      } else {
        if (!now) continue;
        if (now > 0) {
          if (ans - num[i] >= now) {
            num[i] += now;
            now = 0;
          } else {
            now -= ans - num[i];
            num[i] = ans;
          }
        }
      }
    }
    if (now == 0) {
      cout << "Possible" << endl;
      cout << num[0] << ' ';
      for (i = 1; i < sum; i++) {
        cout << mk[i] << " " << num[i] << " ";
      }
      cout << "= " << ans << endl;
    } else
      cout << "Impossible" << endl;
  }
}
