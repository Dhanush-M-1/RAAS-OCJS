#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, sum = 0, cnt = 0, ans = 0, ansl = 0;
  cin >> t;
  int a[t];
  for (int i = 0; i < t; i++) {
    cin >> a[i];
    sum = sum + a[i];
    cnt = max(cnt, a[i]);
  }
  for (int i = 0; i < t; i++) {
    ans = ans + cnt - a[i];
  }
  if (ans > sum) {
    cout << cnt;
  } else {
    while (true) {
      cnt++;
      ansl = 0;
      for (int i = 0; i < t; i++) {
        ansl = ansl + cnt - a[i];
      }
      if (ansl > sum) {
        cout << cnt;
        return 0;
      }
    }
  }
}
