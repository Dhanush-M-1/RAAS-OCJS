#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using db = double;
using ld = long double;
template <typename T>
using V = vector<T>;
template <typename T>
using VV = vector<vector<T>>;
constexpr ll mod = 1000000007;
constexpr ll INF = 1000000099;
constexpr ll LINF = (ll)(1e18 + 99);
const vector<ll> dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
template <typename T, typename U>
inline bool chmin(T& t, const U& u) {
  if (t > u) {
    t = u;
    return 1;
  }
  return 0;
}
template <typename T, typename U>
inline bool chmax(T& t, const U& u) {
  if (t < u) {
    t = u;
    return 1;
  }
  return 0;
}
template <typename T>
inline T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
template <typename T, typename Y>
inline T mpow(T a, Y n) {
  T res = 1;
  for (; n; n >>= 1) {
    if (n & 1) res = res * a;
    a = a * a;
  }
  return res;
}
template <typename T, typename Y>
ostream& operator<<(ostream& os, const pair<T, Y>& p) {
  return os << "{" << p.first << "," << p.second << "}";
}
template <typename T>
ostream& operator<<(ostream& os, const V<T>& v) {
  os << "{";
  for (auto e : v) os << e << ",";
  return os << "}";
}
template <typename... Args>
void debug(Args&... args) {
  for (auto const& x : {args...}) {
    cerr << x << ' ';
  }
  cerr << '\n';
}
VV<int> e;
V<int> ans1(0), ans2(0), deg;
bool dfs(int now, int pre) {
  bool res = false;
  for (auto&& to : e[now]) {
    if (to == pre) continue;
    res |= dfs(to, now);
  }
  if (deg[now] % 2) {
    ans2.push_back(now);
    return true;
  } else {
    ans1.push_back(now);
    for (auto&& to : e[now]) {
      deg[to]--;
    }
    return false;
  }
}
signed main() {
  cin.tie(0);
  cerr.tie(0);
  ios::sync_with_stdio(false);
  cout << fixed << setprecision(20);
  int n;
  cin >> n;
  e.assign(n, V<int>(0));
  deg.assign(n, 0);
  for (ll i = 0; i < (ll)(n); ++i) {
    int x;
    cin >> x;
    --x;
    if (x < 0) continue;
    e[i].push_back(x);
    e[x].push_back(i);
    deg[x]++;
    deg[i]++;
  }
  if (!dfs(0, -1)) {
    cout << "YES" << '\n';
    reverse((ans2).begin(), (ans2).end());
    for (ll i = 0; i < (ll)((ll)(ans1).size()); ++i) {
      cout << ans1[i] + 1 << '\n';
    }
    for (ll i = 0; i < (ll)((ll)(ans2).size()); ++i) {
      cout << ans2[i] + 1 << '\n';
    }
  } else {
    cout << "NO" << '\n';
  }
}
