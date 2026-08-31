#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)1e6 + 100;
const int mod = (int)1e9 + 7;
void solve() {
  long long n, l, r;
  scanf("%lld%lld%lld", &n, &l, &r);
  long long pos = -1, pre = 0;
  for (auto i = (1); i <= (n); ++i) {
    long long now = (n - i) * 2;
    if (now == 0) now = 1;
    if (pre < l && pre + now >= l) {
      pos = i;
      break;
    }
    pre += now;
  }
  long long num = r - l + 1, st = l - pre, fr = pos == n ? 1 : pos,
            se = (st + 1) / 2 + pos;
  for (auto i = (1); i <= (num); ++i) {
    if (st % 2)
      printf("%lld ", fr > n ? 1 : fr);
    else
      printf("%lld ", se > n ? 1 : se), se++;
    st++;
    if (se > n) {
      pos++;
      st = 1;
      fr = pos;
      se = pos + 1;
      if (fr == n) fr = 1;
      if (se > n) se = 1;
    }
  }
  puts("");
}
int main() {
  int T;
  cin >> T;
  while (T--) solve();
}
