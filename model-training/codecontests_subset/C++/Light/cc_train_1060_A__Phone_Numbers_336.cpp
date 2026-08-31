#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long n;
  cin >> n;
  char s;
  long long cnt = 0;
  while (cin >> s) {
    cnt += s == '8';
  }
  long long ans = 0;
  for (long long i = 0; i <= cnt; ++i) {
    if (min(i, (n - i) / 10) > ans) ans = min(i, (n - i) / 10);
  }
  cout << ans;
}
