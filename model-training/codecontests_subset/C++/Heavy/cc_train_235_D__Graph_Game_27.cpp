#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void rd(T &x) {
  char ch;
  x = 0;
  bool fl = false;
  while (!isdigit(ch = getchar())) (ch == '-') && (fl = true);
  for (x = (ch ^ '0'); isdigit(ch = getchar()); x = x * 10 + (ch ^ '0'))
    ;
  (fl == true) && (x = -x);
}
template <class T>
inline void output(T x) {
  if (x / 10) output(x / 10);
  putchar(x % 10 + '0');
}
template <class T>
inline void ot(T x) {
  if (x < 0) putchar('-'), x = -x;
  output(x);
  putchar(' ');
}
template <class T>
inline void prt(T a[], int st, int nd) {
  for (register int i = st; i <= nd; ++i) ot(a[i]);
  putchar('\n');
}
namespace Miracle {
const int N = 3003;
int n;
struct node {
  int nxt, to;
} e[2 * N];
int hd[N], cnt;
void add(int x, int y) {
  e[++cnt].nxt = hd[x];
  e[cnt].to = y;
  hd[x] = cnt;
}
int sta[N], top;
bool vis[N];
bool fl;
int on[N], mem[N], num;
void fin(int x, int fa) {
  sta[++top] = x;
  vis[x] = 1;
  for (register int i = hd[x]; i; i = e[i].nxt) {
    int y = e[i].to;
    if (y == fa) continue;
    if (vis[y]) {
      if (!fl) {
        fl = true;
        int z;
        do {
          z = sta[top--];
          mem[++num] = z;
          on[z] = num;
        } while (z != y);
      }
    } else
      fin(y, x);
  }
  if (sta[top] == x) sta[top--] = 0;
}
int be[N];
int dis[N];
void dfs(int x, int fa, int rt) {
  be[x] = rt;
  for (register int i = hd[x]; i; i = e[i].nxt) {
    int y = e[i].to;
    if (y == fa) continue;
    if (on[y]) continue;
    dis[y] = dis[x] + 1;
    dfs(y, x, rt);
  }
}
double ans;
int rt;
void sol(int x, int d) {
  vis[x] = 1;
  if (x != rt) {
    if (be[x] == be[rt]) {
      ans += (double)1.0 / ((double)d);
    } else {
      int a = dis[rt] + dis[x], b = abs(on[be[x]] - on[be[rt]]) - 1,
          c = num - 2 - b;
      ans += (double)1.0 / ((double)a + b) + (double)1.0 / ((double)a + c) -
             (double)1.0 / ((double)a + b + c);
    }
  }
  for (register int i = hd[x]; i; i = e[i].nxt) {
    int y = e[i].to;
    if (vis[y]) continue;
    sol(y, d + 1);
  }
}
int main() {
  rd(n);
  int x, y;
  for (register int i = 1; i <= n; ++i) {
    rd(x);
    rd(y);
    ++x;
    ++y;
    add(x, y);
    add(y, x);
  }
  fin(1, 0);
  for (register int i = 1; i <= num; ++i) {
    dis[mem[i]] = 1;
    dfs(mem[i], 0, mem[i]);
  }
  for (register int i = 1; i <= n; ++i) {
    memset(vis, 0, sizeof vis);
    rt = i;
    sol(i, 1);
  }
  ans += n;
  printf("%.10lf", ans);
  return 0;
}
}  // namespace Miracle
signed main() {
  Miracle::main();
  return 0;
}
