#include <bits/stdc++.h>
using namespace std;
template <class T>
bool mini(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool maxi(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
const int N = 2e5 + 5;
int n, ans[N];
long long bit[N], p[N];
void up(int i) {
  assert(i > 0);
  for (long long val = i; i <= n; i += i & -i) bit[i] += val;
}
long long get(int i) {
  long long res = 0;
  for (; i > 0; i -= i & -i) res += bit[i];
  return res;
}
inline void sol() {
  cin >> n;
  for (int i = 0, _ = (n); i < _; i++) cin >> p[i];
  for (int i = (int)(n)-1; i >= 0; --i) {
    long long l = 0, r = n - 1, mid;
    while (l < r) {
      mid = (l + r + 1) >> 1;
      if (mid * (mid + 1) / 2 > get(mid) + p[i])
        r = mid - 1;
      else
        l = mid;
    }
    up(ans[i] = l + 1);
  }
  for (int i = 0, _ = (n); i < _; i++) cout << ans[i] << ' ';
  cout << "\n";
}
signed main() {
  { ios_base::sync_with_stdio(false), cin.tie(NULL); };
  cout.precision(10);
  cout << fixed;
  sol();
}
