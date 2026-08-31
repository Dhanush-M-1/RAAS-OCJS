#include <bits/stdc++.h>
using namespace std;
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unroll-loops")
const int N = 100005;
void solve() {
  long long n, s, e;
  cin >> n >> s >> e;
  if (s == n * n - n + 1) {
    cout << 1 << '\n';
    return;
  } else {
    long long a = n * 2 - 2;
    long long sq = sqrt((a + 1) * (a + 1) - 4 * s);
    long long st = (a + 1 - sq) / 2;
    if (sq * sq < (a + 1) * (a + 1) - 4 * s) st++;
    long long prev = (st - 1) * (a - (st - 2));
    if (prev >= s) {
      st--;
      prev = (st - 1) * (a - (st - 2));
    }
    long long l = st, r = (s - prev + 1) / 2 + st;
    if ((s % 2) == 0) {
      cout << r << " ";
      r++;
      s++;
    }
    while (s <= min(e, n * n - n)) {
      if (r > n) {
        l++;
        r = l + 1;
      }
      cout << l << " ";
      s++;
      if (s <= e)
        cout << r << " ";
      else
        break;
      r++;
      s++;
    }
    if (e == n * n - n + 1) {
      cout << 1 << '\n';
    } else
      cout << '\n';
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int t = 1;
  cin >> t;
  for (int i = 1; i <= t; i++) {
    solve();
  }
}
