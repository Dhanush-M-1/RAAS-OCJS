#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int dir[8][2] = {-1, 0, 1, 0, 0, -1, 0, 1, -1, -1, -1, 1, 1, -1, 1, 1};
template <typename S, typename T>
ostream &operator<<(ostream &os, const pair<S, T> x) {
  os << "(" << x.first << ", " << x.second << ")";
  return os;
}
template <typename S, typename T>
inline bool Min(S &a, const T &b) {
  return a > b ? a = b, true : false;
}
template <typename S, typename T>
inline bool Max(S &a, const T &b) {
  return a < b ? a = b, true : false;
}
template <typename S, typename T>
inline void Adm(S &a, const T &b) {
  a = (a + b) % MOD;
  if (a < 0) a += MOD;
}
template <typename T>
inline bool IsPri(T x) {
  if (x < 2) return false;
  for (T i = 2; i * i <= x; ++i)
    if (x % i == 0) return false;
  return true;
}
template <typename T>
inline T _Gcd(T a, T b) {
  while (b) {
    T t = b;
    b = a % b;
    a = t;
  }
  return a;
}
template <typename T>
inline int _BitCnt(T x) {
  int cnt = 0;
  while (x) ++cnt, x &= x - 1;
  return cnt;
}
inline long long Pow(long long a, long long n) {
  long long t = 1;
  a %= MOD;
  while (n > 0) {
    if (n & 1) t = t * a % MOD;
    a = a * a % MOD, n >>= 1;
  }
  return t % MOD;
}
inline int read() {
  static char buf[1000000], *p1 = buf, *p2 = buf;
  register int x = false;
  register char ch =
      p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1000000, stdin), p1 == p2)
          ? EOF
          : *p1++;
  ;
  register bool sgn = false;
  while (ch != '-' && (ch < '0' || ch > '9'))
    ch = p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1000000, stdin), p1 == p2)
             ? EOF
             : *p1++;
  ;
  if (ch == '-')
    sgn = true,
    ch = p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1000000, stdin), p1 == p2)
             ? EOF
             : *p1++;
  ;
  while (ch >= '0' && ch <= '9')
    x = (x << 1) + (x << 3) + (ch ^ 48),
    ch = p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1000000, stdin), p1 == p2)
             ? EOF
             : *p1++;
  ;
  return sgn ? -x : x;
}
const int N = 2e5 + 100;
int d[N], del[N];
vector<pair<int, int> > e[N];
int u[N], v[N], ans[N];
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d", &u[i], &v[i]);
    e[u[i]].push_back({v[i], i}), e[v[i]].push_back({u[i], i});
    ++d[u[i]], ++d[v[i]];
  }
  set<pair<int, int> > st;
  for (int i = 1; i <= n; ++i) st.insert({d[i], i});
  for (int i = m; i >= 1; --i) {
    while (!st.empty() && st.begin()->first < k) {
      int u = st.begin()->second;
      st.erase(st.begin()), del[u] = 1;
      for (auto it : e[u]) {
        int v = it.first, id = it.second;
        if (!del[v] && id <= i) st.erase({d[v], v}), st.insert({--d[v], v});
      }
    }
    ans[i] = ((int)(st).size());
    if (!del[u[i]] && !del[v[i]]) {
      st.erase({d[u[i]], u[i]}), st.insert({--d[u[i]], u[i]});
      st.erase({d[v[i]], v[i]}), st.insert({--d[v[i]], v[i]});
    }
  }
  for (int i = 1; i <= m; ++i) printf("%d\n", ans[i]);
  return 0;
}
