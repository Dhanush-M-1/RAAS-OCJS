#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
const int MAXN = 0;
const int MAXK = 0;
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  long long sum = 0;
  for (int i = (1); i < (n); ++i) {
    sum += 2 * (n - i);
    if (sum >= l) {
      sum -= 2 * (n - i);
      long long var = i, cnt = 0;
      while (cnt < 2 * (n - i) && sum < r) {
        ++sum, ++cnt, var += !(cnt & 1);
        if (sum >= l)
          if (cnt & 1)
            cout << i << " ";
          else
            cout << var << " ";
      }
      if (sum != r)
        l = sum + 1;
      else
        break;
    }
  }
  if (r == n * (n - 1LL) + 1LL)
    cout << 1 << '\n';
  else
    cout << '\n';
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
