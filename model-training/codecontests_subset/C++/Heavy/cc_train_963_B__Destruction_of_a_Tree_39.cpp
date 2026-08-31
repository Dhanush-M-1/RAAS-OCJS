#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
template <typename T>
void _R(T& x) {
  cin >> x;
}
template <typename T>
void _R(vector<T>& x) {
  for (auto it = x.begin(); it != x.end(); it++) {
    _R(*it);
  }
}
void R() {}
template <typename T, typename... K>
void R(T& head, K&... tail) {
  _R(head);
  R(tail...);
}
template <typename T>
void _W(const T& x, const char c) {
  cout << x;
}
template <typename T>
void _W(const vector<T>& x, const char c) {
  for (auto it = x.cbegin(); it != x.cend(); it++) {
    if (it != x.cbegin()) putchar(c);
    _W(*it, c);
  }
}
void W() {}
template <typename T, typename... K>
void W(const T& head, const K&... tail) {
  _W(head, ' ');
  cout << (sizeof...(tail) ? ' ' : '\n') << flush;
  W(tail...);
}
const double PI =
    3.14159265358979323846264338327950288419716939937510582097494459230;
template <typename T>
inline T gcd(T a, T b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
template <typename T>
inline void amin(T& x, T y) {
  if (x > y) x = y;
}
template <typename T>
inline void amax(T& x, T y) {
  if (x < y) x = y;
}
template <typename A, typename B>
class comp {
 public:
  bool operator()(const pair<A, B>& a, const pair<A, B>& b) {
    if (a.first != b.first)
      return a.first < b.first;
    else
      return a.first > b.first;
  }
};
long long fast_exp(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1LL) {
      res *= a;
      res %= 1000000007;
    }
    b >>= 1LL;
    a *= a;
    a %= 1000000007;
  }
  return res;
}
const int N = 200005;
int n;
vector<int> g[N];
vector<int> a;
bool b[N];
map<int, bool> m[N];
void preprocess(void) { return; }
bool dfs(int u, int p) {
  int cnt = 0;
  for (auto v : (g[u])) {
    if (v == p) continue;
    bool f = dfs(v, u);
    m[u][v] = f;
    if (f) cnt++;
  }
  if (p == -1) {
    if ((cnt)&1)
      return false;
    else
      return true;
  }
  cnt++;
  if (cnt & 1)
    return true;
  else
    return false;
}
void answ(int u, int p) {
  for (auto v : (g[u])) {
    if (v == p) continue;
    if (!m[u][v]) {
      answ(v, u);
    }
  }
  a.push_back(u);
  for (auto v : (g[u])) {
    if (v == p) continue;
    if (m[u][v]) {
      answ(v, u);
    }
  }
}
signed main(int argc, char* argv[], char* envp[]) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.precision(20);
  preprocess();
  int teeee;
  teeee = 1;
  for (int zeeee = (1); zeeee <= (teeee); zeeee++) {
    cin >> n;
    for (int i = (0); i <= ((int)(n)-1); i++) {
      int p;
      cin >> p;
      if (p == 0) continue;
      p--;
      g[i].push_back(p);
      g[p].push_back(i);
    }
    fill(b, b + n, false);
    bool ans = dfs(0, -1);
    if (ans) {
      cout << "YES\n";
      answ(0, -1);
      for (auto v : a) {
        cout << v + 1 << "\n";
      }
    } else {
      cout << "NO\n";
    }
  }
  cerr << (((double)clock()) / ((double)CLOCKS_PER_SEC)) << endl;
  return 0;
}
