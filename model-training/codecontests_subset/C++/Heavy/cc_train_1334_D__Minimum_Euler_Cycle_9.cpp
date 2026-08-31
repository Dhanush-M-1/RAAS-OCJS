#include <bits/stdc++.h>
const int N = 3 * 1e5 + 5;
const long long MOD = 1000000007;
const long long inf = 1e18;
using namespace std;
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  if (x == 0) return 0;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  long long ctr = 0;
  long long lt = l;
  if (l == n * (n - 1) + 1) {
    cout << 1 << "\n";
    return;
  }
  while (lt > 0) {
    ctr++;
    lt -= 2 * (n - ctr);
  }
  lt += 2 * (n - ctr);
  long long val = (r - l + 1);
  while (val) {
    val--;
    if (ctr == n) {
      cout << "1"
           << " "
           << "\n";
      return;
    }
    if (lt % 2 == 1)
      cout << ctr;
    else
      cout << ctr + lt / 2;
    cout << " ";
    if (lt < 2 * (n - ctr))
      lt++;
    else {
      ctr++;
      lt = 1;
    }
  }
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
}
