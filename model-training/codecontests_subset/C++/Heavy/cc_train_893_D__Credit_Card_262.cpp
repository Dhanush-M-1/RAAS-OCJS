#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false), cin.tie(0);
  int n, d, t, now = 0, cnt = 0, flag = 1, balance = 0;
  cin >> n >> d;
  for (int i = 1; i <= n; i++) {
    cin >> t;
    if (t > 0) {
      now += t;
      if (now > d) {
        flag = 0;
      }
    } else if (t == 0) {
      if (now < 0) {
        if (now + balance < 0) {
          cnt++;
          balance = d;
        } else {
          balance = balance + now;
        }
        now = 0;
      }
    } else {
      now += t;
    }
    if (now + balance > d) balance = d - now;
  }
  if (!flag)
    cout << -1 << endl;
  else
    cout << cnt << endl;
  return 0;
}
