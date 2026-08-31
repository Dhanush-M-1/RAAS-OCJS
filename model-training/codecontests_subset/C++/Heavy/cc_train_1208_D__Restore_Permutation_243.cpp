#include <bits/stdc++.h>
using namespace std;
void ECHO(string _s) {
  cout << endl;
  (void)_s;
}
template <typename T, typename... Args>
void ECHO(string _s, T x, Args... args) {
  int _i;
  string _s2 = "";
  for (_i = 0; _i < (int)(_s).size(); ++_i) {
    if (_s[_i] == ',') break;
    if (_s[_i] != ' ') _s2 += _s[_i];
  }
  if (_i == (int)(_s).size()) {
    --_i;
  }
  cout << "  (" << _s2 << "):" << x;
  ECHO(_s.substr(_i + 1, (int)(_s).size() - _i - 1), args...);
}
template <typename T0, typename T1>
inline ostream& operator<<(ostream& os, pair<T0, T1>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <typename T>
inline ostream& operator<<(ostream& os, vector<T>& v) {
  for (int i = 0; i < (int)(v).size(); ++i) {
    if (i > 0) cout << "_";
    cout << v[i];
  }
  cout << endl;
  return os;
}
inline long long _gcd(long long a, long long b) {
  while (b) b %= a ^= b ^= a ^= b;
  return a;
}
mt19937 ran(time(0));
const long double PI = acos(-1);
const long double eps = 1e-9;
const long long inf = LLONG_MAX / 10;
vector<long long> v, ans;
long long n;
const long long MAX = 2 * 1e5 + 10;
vector<long long> bit(MAX, 0);
void update(int dx, long long val) {
  for (int i = dx + 1; i <= n; i += ((i) & (-(i)))) bit[i] += val;
}
long long query(int dx) {
  long long ans = 0, i;
  for (i = dx + 1; i > 0; i -= ((i) & (-(i)))) ans += bit[i];
  return ans;
}
int get_number(long long sum) {
  long long l = 0, r = n, mid, ans;
  while (l + 1 < r) {
    mid = (l + r) >> 1;
    ans = query(mid);
    if (ans <= sum)
      l = mid;
    else
      r = mid;
  }
  return l + 1;
}
int main() {
  ios::sync_with_stdio(false);
  int i, x;
  cin >> n;
  v.resize(n + 1);
  n = v.size() - 1;
  ans.resize(n + 1);
  for (i = 1; i <= n; ++i) {
    update(i, i);
    cin >> v[i];
  }
  for (i = n; i > 0; --i) {
    x = get_number(v[i]);
    ans[i] = x;
    update(x, -x);
  }
  for (i = 1; i <= n; ++i) {
    if (i > 1) cout << " ";
    cout << ans[i];
  }
  cout << "\n";
  return 0;
}
