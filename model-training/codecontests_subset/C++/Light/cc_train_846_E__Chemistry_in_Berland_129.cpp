#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T& x) {
  x = 0;
  T fl = 1;
  char ch = 0;
  for (; ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') fl = -1;
  for (; ch >= '0' && ch <= '9'; ch = getchar())
    x = (x << 1) + (x << 3) + (ch ^ 48);
  x *= fl;
}
template <typename T, typename... Args>
inline void read(T& x, Args&... args) {
  read(x);
  read(args...);
}
const int N = 1e6 + 5;
struct edge {
  int to, nt;
} E[N];
int H[N], e_cnt, n;
double h[N];
long long k[N], b[N], a[N];
void add_edge(int u, int v) {
  E[++e_cnt] = (edge){v, H[u]};
  H[u] = e_cnt;
}
void dfs(int u) {
  for (int e = H[u]; e; e = E[e].nt) {
    int v = E[e].to;
    dfs(v);
    if (h[v] < 0)
      h[u] += 1.0 * k[v] * h[v];
    else
      h[u] += h[v];
  }
}
int main() {
  read(n);
  for (int i = (1); i <= (n); i++) read(b[i]);
  for (int i = (1); i <= (n); i++) read(a[i]);
  for (int i = (1); i <= (n); i++) h[i] = b[i] - a[i];
  for (int i = (2); i <= (n); i++) {
    int x;
    read(x, k[i]);
    add_edge(x, i);
  }
  dfs(1);
  if (h[1] >= 0)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
