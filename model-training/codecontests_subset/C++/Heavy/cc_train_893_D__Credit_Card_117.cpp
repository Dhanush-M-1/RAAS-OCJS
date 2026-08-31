#include <bits/stdc++.h>
using namespace std;
using tint = long long;
using ld = long double;
using vi = vector<int>;
using vl = vector<tint>;
using vb = vector<bool>;
using pi = pair<int, int>;
using pl = pair<tint, tint>;
const int MOD = 1e9 + 7;
const int mod = 998244353;
const int MX = 3e5 + 5;
const tint INF = 1e18;
const int inf = 2e9;
const ld PI = acos(ld(-1));
const ld eps = 1e-8;
const int dx[4] = {1, -1, 0, 0};
const int dy[4] = {0, 0, 1, -1};
template <class T>
void remDup(vector<T>& v) {
  sort(begin(v), end(v));
  v.erase(unique(begin(v), end(v)), end(v));
}
template <class T>
bool valid(T x, T y, T n, T m) {
  return (0 <= x && x < n && 0 <= y && y < m);
}
void NACHO(string name = "cbarn") {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
}
int main() {
  NACHO();
  int n, d;
  cin >> n >> d;
  vi a(n);
  for (int i = 0; i < int(n); i++) cin >> a[i];
  vi suff(n);
  suff[n - 1] = a[n - 1];
  for (int i = n - 2; i >= 0; --i) {
    suff[i] = max(suff[i + 1] + a[i], a[i]);
  }
  int cur = 0;
  int ret = 0;
  bool ok = 1;
  for (int i = 0; i < int(n); i++) {
    if (a[i] == 0) {
      if (cur < 0) {
        ++ret;
        int sumo = d - suff[i] - cur;
        if (sumo < 0 || cur + sumo < 0) ok = 0;
        cur += sumo;
      }
    } else {
      cur += a[i];
      if (cur > d) ok = 0;
    }
  }
  if (!ok) ret = -1;
  cout << ret << "\n";
}
