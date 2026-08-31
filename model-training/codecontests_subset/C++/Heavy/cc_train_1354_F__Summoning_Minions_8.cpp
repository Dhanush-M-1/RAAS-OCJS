#include <bits/stdc++.h>
#pragma GCC target("avx2,avx")
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
using namespace std;
using ll = long long;
using ull = unsigned long long;
using i128 = __int128_t;
using pii = pair<int, int>;
using pll = pair<long long, long long>;
constexpr char ln = '\n';
istream& operator>>(istream& is, __int128_t& x) {
  x = 0;
  string s;
  is >> s;
  int n = int(s.size()), it = 0;
  if (s[0] == '-') it++;
  for (; it < n; it++) x = (x * 10 + s[it] - '0');
  if (s[0] == '-') x = -x;
  return is;
}
ostream& operator<<(ostream& os, __int128_t x) {
  if (x == 0) return os << 0;
  if (x < 0) os << '-', x = -x;
  deque<int> deq;
  while (x) deq.emplace_front(x % 10), x /= 10;
  for (int e : deq) os << e;
  return os;
}
template <class T1, class T2>
ostream& operator<<(ostream& os, const pair<T1, T2>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <class T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  os << "{";
  for (int i = 0; i < int(v.size()); i++) {
    if (i) os << ", ";
    os << v[i];
  }
  return os << "}";
}
template <class Container>
inline int SZ(Container& v) {
  return int(v.size());
}
template <class T>
inline void UNIQUE(vector<T>& v) {
  v.erase(unique(v.begin(), v.end()), v.end());
}
template <class T1, class T2>
inline bool chmax(T1& a, T2 b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <class T1, class T2>
inline bool chmin(T1& a, T2 b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
inline int topbit(ull x) { return x == 0 ? -1 : 63 - __builtin_clzll(x); }
inline int botbit(ull x) { return x == 0 ? 64 : __builtin_ctzll(x); }
inline int popcount(ull x) { return __builtin_popcountll(x); }
inline int kthbit(ull x, int k) { return (x >> k) & 1; }
inline constexpr long long TEN(int x) { return x == 0 ? 1 : TEN(x - 1) * 10; }
inline void print() { cout << "\n"; }
template <class T>
inline void print(const vector<T>& v) {
  for (int i = 0; i < int(v.size()); i++) {
    if (i) cout << " ";
    cout << v[i];
  }
  print();
}
template <class T, class... Args>
inline void print(const T& x, const Args&... args) {
  cout << x << " ";
  print(args...);
}
struct fast_ios {
  fast_ios() {
    cin.tie(nullptr);
    ios::sync_with_stdio(false);
    cout << fixed << setprecision(20);
  };
} fast_ios_;
constexpr ll INF = 1e18;
void solve() {
  int N, K;
  cin >> N >> K;
  vector<ll> A(N), B(N);
  for (int i = 0; i < (N); i++) cin >> A[i] >> B[i];
  vector<int> idx(N);
  iota((idx).begin(), (idx).end(), 0);
  sort((idx).begin(), (idx).end(), [&](int i, int j) { return B[i] < B[j]; });
  vector<vector<ll>> dp(N + 1, vector<ll>(K + 1, -INF));
  vector<vector<int>> pre(N + 1, vector<int>(K + 1));
  dp[0][0] = 0;
  for (int i = 0; i < (N); i++)
    for (int j = 0; j < (K + 1); j++) {
      int u = idx[i];
      if (chmax(dp[i + 1][j], dp[i][j] + B[u] * (K - 1))) {
        pre[i + 1][j] = j;
      }
      if (j < K) {
        if (chmax(dp[i + 1][j + 1], dp[i][j] + A[u] + B[u] * j)) {
          pre[i + 1][j + 1] = j;
        }
      }
    }
  vector<int> C, D;
  {
    int k = K;
    for (int n = N; n > 0; n--) {
      int pk = pre[n][k];
      if (pk == k) {
        D.emplace_back(idx[n - 1]);
      } else {
        C.emplace_back(idx[n - 1]);
      }
      k = pk;
    }
  }
  reverse((C).begin(), (C).end());
  cout << SZ(C) + SZ(D) * 2 << ln;
  for (int i = 0; i < (SZ(C) - 1); i++) cout << C[i] + 1 << " ";
  for (auto e : D) cout << e + 1 << " " << -(e + 1) << " ";
  cout << C.back() + 1 << ln;
}
int main() {
  int Q;
  cin >> Q;
  while (Q--) {
    solve();
  }
}
