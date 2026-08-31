#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const double PI = acos(-1.0);
template <typename T>
inline T sq(T a) {
  return a * a;
}
template <typename T1, typename T2>
inline pair<T1, T2> mp(T1 a, T2 b) {
  return make_pair(a, b);
}
template <typename T1, typename T2>
inline T1 safeMod(T1 a, T2 m) {
  return (a % m + m) % m;
}
template <typename T1, typename T2>
inline bool isEq(T1 a, T2 b) {
  return abs(a - b) < EPS;
}
template <typename T1, typename T2, typename T3>
inline bool isEq(T1 a, T2 b, T3 eps) {
  return abs(a - b) < eps;
}
template <typename T>
inline bool isKthBitOn(T n, int k) {
  assert(n <= numeric_limits<T>::max());
  assert(k <= numeric_limits<T>::digits);
  T ONE = 1;
  return bool((n & (ONE << k)));
}
template <typename T>
inline void setKthBit(T& n, int k) {
  assert(n <= numeric_limits<T>::max());
  assert(k <= numeric_limits<T>::digits);
  T ONE = 1;
  n = (n | (ONE << k));
}
const int oo = 0x3f3f3f3f;
const int MAX = 200010;
const int MOD = 1000000007;
const int precision = 10;
void solve(int kas) {
  int n;
  cin >> n;
  vector<string> grid(n);
  for (int i = 0; i < n; i++) {
    cin >> grid[i];
  }
  vector<pair<int, int> > ans;
  if (grid[0][1] == grid[1][0]) {
    char other = (grid[0][1] == '1') ? '0' : '1';
    if (other != grid[n - 1][n - 2]) ans.push_back({n - 1, n - 2});
    if (other != grid[n - 2][n - 1]) ans.push_back({n - 2, n - 1});
  } else {
    if (grid[n - 1][n - 2] == grid[n - 2][n - 1]) {
      char other = (grid[n - 1][n - 2] == '1') ? '0' : '1';
      if (other != grid[0][1]) ans.push_back({0, 1});
      if (other != grid[1][0]) ans.push_back({1, 0});
    } else {
      grid[0][1] = grid[1][0];
      ans.push_back({0, 1});
      char other = (grid[0][1] == '1') ? '0' : '1';
      if (other != grid[n - 1][n - 2]) ans.push_back({n - 1, n - 2});
      if (other != grid[n - 2][n - 1]) ans.push_back({n - 2, n - 1});
    }
  }
  cout << ans.size() << '\n';
  for (int i = 0; i < ans.size(); i++)
    cout << ans[i].first + 1 << " " << ans[i].second + 1 << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int tc = 1;
  cin >> tc;
  for (int _ = 1; _ <= tc; _++) {
    solve(_);
  }
  return 0;
}
