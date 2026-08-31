#include <bits/stdc++.h>
using namespace std;
long long a[100005], dp[100005], mi;
int main() {
  int n;
  long long d;
  cin >> n >> d;
  for (int i = 1; i <= n; i++) scanf("%I64d", &a[i]);
  long long s = 0;
  mi = 0;
  for (int i = n; i >= 1; i--) {
    s += a[i];
    dp[i] = s - mi;
    mi = min(mi, s);
  }
  s = 0;
  bool f = 1;
  int cnt = 0;
  for (int i = 1; i <= n; i++) {
    s += a[i];
    if (s > d) {
      f = 0;
      break;
    }
    if (a[i] == 0 && s < 0) {
      long long add = min(d - s, d - dp[i + 1] - s);
      s += add;
      if (s < 0) {
        f = 0;
        break;
      }
      cnt++;
    }
  }
  if (f) {
    cout << cnt << endl;
  } else
    puts("-1");
  return 0;
}
