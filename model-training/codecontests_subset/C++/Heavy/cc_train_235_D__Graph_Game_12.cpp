#include <bits/stdc++.h>
using namespace std;
inline bool SR(int &x) { return scanf("%d", &x) == 1; }
inline bool SR(long long &x) { return scanf("%lld", &x) == 1; }
inline bool SR(double &x) { return scanf("%lf", &x) == 1; }
inline bool SR(char *s) { return scanf("%s", s) == 1; }
inline bool RI() { return true; }
template <typename I, typename... T>
inline bool RI(I &x, T &...tail) {
  return SR(x) && RI(tail...);
}
inline void SP(const int x) { printf("%d", x); }
inline void SP(const long long x) { printf("%lld", x); }
inline void SP(const double x) { printf("%.16lf", x); }
inline void SP(const char *s) { printf("%s", s); }
inline void PL() { puts(""); }
template <typename I, typename... T>
inline void PL(const I x, const T... tail) {
  SP(x);
  if (sizeof...(tail)) putchar(' ');
  PL(tail...);
}
template <typename I>
void _DOING(const char *s, I &&x) {
  cerr << s << " = " << x << endl;
}
template <typename I, typename... T>
void _DOING(const char *s, I &&x, T &&...tail) {
  int c = 0;
  while (*s != ',' || c != 0) {
    if (*s == '(' || *s == '[' || *s == '{') c++;
    if (*s == ')' || *s == ']' || *s == '}') c--;
    cerr << *s++;
  }
  cerr << " = " << x << " , ";
  _DOING(s + 1, tail...);
}
inline int RAND() {
  static int x = 880301;
  return (x = x * 0xdefaced + 1) & 0x7fffffff;
}
const int MAX_N = 3000 + 10;
double ans;
int cycle_cnt;
int deg[MAX_N];
bool vis[MAX_N];
bool tag[MAX_N];
vector<int> G[MAX_N];
void dfs(int u, int a, int b) {
  vis[u] = true;
  if (b <= 1)
    ans += 1.0 / a;
  else
    ans +=
        1.0 / a - 1.0 / (a - b + cycle_cnt) + 1.0 / (a - b + cycle_cnt - b + 2);
  for (int v : G[u])
    if (!vis[v]) dfs(v, a + 1, b + tag[v]);
}
int main() {
  int n;
  RI(n);
  for (int i = 0; i < int(n); i++) {
    int a, b;
    RI(a, b);
    G[a].push_back(b);
    G[b].push_back(a);
    deg[a]++;
    deg[b]++;
  }
  vector<int> vec;
  for (int i = 0; i < int(n); i++)
    if (deg[i] == 1) vec.push_back(i);
  for (int i = 0; i < int(((int)vec.size())); i++) {
    int u = vec[i];
    for (int v : G[u]) {
      if (--deg[v] == 1) vec.push_back(v);
    }
  }
  cycle_cnt = n - ((int)vec.size());
  for (int i = 0; i < int(n); i++)
    if (deg[i] > 1) tag[i] = 1;
  for (int i = 0; i < int(n); i++) {
    memset(vis, (0), sizeof(vis));
    dfs(i, 1, tag[i]);
  }
  PL(ans);
  return 0;
}
