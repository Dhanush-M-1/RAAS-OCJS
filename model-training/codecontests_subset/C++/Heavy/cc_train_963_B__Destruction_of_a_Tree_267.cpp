#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int FFTMOD = 1007681537;
const int INF = (int)1e9;
const long long LINF = (long long)1e18;
const long double PI = acos((long double)-1);
const long double EPS = 1e-9;
inline long long gcd(long long a, long long b) {
  long long r;
  while (b) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
inline long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
inline long long fpow(long long n, long long k, int p = MOD) {
  long long r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
template <class T>
inline int chkmin(T& a, const T& val) {
  return val < a ? a = val, 1 : 0;
}
template <class T>
inline int chkmax(T& a, const T& val) {
  return a < val ? a = val, 1 : 0;
}
inline long long isqrt(long long k) {
  long long r = sqrt(k) + 1;
  while (r * r > k) r--;
  return r;
}
inline long long icbrt(long long k) {
  long long r = cbrt(k) + 1;
  while (r * r * r > k) r--;
  return r;
}
inline void addmod(int& a, int val, int p = MOD) {
  if ((a = (a + val)) >= p) a -= p;
}
inline void submod(int& a, int val, int p = MOD) {
  if ((a = (a - val)) < 0) a += p;
}
inline int mult(int a, int b, int p = MOD) { return (long long)a * b % p; }
inline int inv(int a, int p = MOD) { return fpow(a, p - 2, p); }
inline int sign(long double x) { return x < -EPS ? -1 : x > +EPS; }
inline int sign(long double x, long double y) { return sign(x - y); }
const int maxn = 2e5 + 5;
int n;
vector<int> adj[maxn];
int par[maxn];
int size[maxn];
int f[maxn];
void dfs(int u, int p) {
  size[u] = 1;
  par[u] = p;
  for (int v : adj[u]) {
    if (v != p) {
      dfs(v, u);
      size[u] += size[v];
    }
  }
}
void chemthan() {
  cin >> n;
  for (int i = (0); i < (n); ++i) {
    int u;
    cin >> u;
    u--;
    if (u != -1) {
      adj[u].push_back(i);
      adj[i].push_back(u);
    }
  }
  if (!(n & 1)) {
    cout << "NO\n";
    return;
  }
  dfs(0, -1);
  for (int u = (0); u < (n); ++u) {
    int tot = 0;
    for (int v : adj[u]) {
      if (v != par[u]) {
        if (!(size[v] & 1)) {
          f[u]++;
        }
        tot += size[v];
      }
    }
    tot = n - tot - 1;
    if (!(tot & 1) && tot) {
      f[u]++;
    }
  }
  static int deg[maxn];
  static int rem[maxn];
  for (int u = (0); u < (n); ++u) deg[u] = int((adj[u]).size());
  set<int> st;
  for (int u = (0); u < (n); ++u) {
    if (!f[u] && !(deg[u] & 1)) {
      st.insert(u);
    }
  }
  vector<int> res;
  while (int((st).size())) {
    int u = *st.begin();
    st.erase(u);
    if (deg[u] & 1) {
      continue;
    }
    res.push_back(u);
    rem[u] = 1;
    for (int v : adj[u]) {
      deg[v]--;
      f[v]--;
      if (!f[v] && !rem[v] && !(deg[v] & 1)) {
        st.insert(v);
      }
    }
  }
  if (int((res).size()) != n) {
    cout << "NO\n";
    return;
  }
  cout << "YES\n";
  for (int u : res) {
    cout << u + 1 << "\n";
  }
}
int main(int argc, char* argv[]) {
  ios_base::sync_with_stdio(0), cin.tie(0);
  if (argc > 1) {
    assert(freopen(argv[1], "r", stdin));
  }
  if (argc > 2) {
    assert(freopen(argv[2], "wb", stdout));
  }
  chemthan();
  cerr << "\nTime elapsed: " << 1000 * clock() / CLOCKS_PER_SEC << "ms\n";
  return 0;
}
