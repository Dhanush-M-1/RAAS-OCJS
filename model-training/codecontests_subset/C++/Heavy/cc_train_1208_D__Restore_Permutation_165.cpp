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
void up(int i, int val) {
  assert(i > 0);
  for (; i <= n; i += i & -i) bit[i] += val;
}
long long get(int i) {
  long long res = 0;
  for (; i; i -= i & -i) res += bit[i];
  return res;
}
inline void sol() {
  cin >> n;
  for (int i = 0, _ = (n); i < _; i++) cin >> p[i], up(i + 1, i + 1);
  for (int i = (int)(n)-1; i >= 0; --i) {
    int l = 1, r = n, mid;
    while (l < r) {
      mid = (l + r + 1) >> 1;
      if (get(mid - 1) <= p[i])
        l = mid;
      else
        r = mid - 1;
    }
    up(l, -l);
    ans[i] = l;
  }
  for (int i = 0, _ = (n); i < _; i++) cout << ans[i] << ' ';
}
signed main() {
  { ios_base::sync_with_stdio(false), cin.tie(NULL); };
  cout.precision(10);
  cout << fixed;
  sol();
}
