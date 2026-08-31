#include <bits/stdc++.h>
using namespace std;
const int N = 4011;
namespace RikukiIX {
int n;
int xi, yi;
struct sumireko {
  int to, ne;
} e[N << 1];
int he[N], ecnt;
void addline(int f, int t) {
  e[++ecnt].to = t;
  e[ecnt].ne = he[f];
  he[f] = ecnt;
}
int sta[N], stp;
int vis[N];
int sp;
int onr[N], rnd[N], ra;
int dis[N];
double ans;
int rt;
int bl[N];
void fr(int x, int f) {
  sta[++stp] = x, vis[x] = 1;
  for (int i = he[x], t = e[i].to; i; i = e[i].ne, t = e[i].to) {
    if (t == f) continue;
    if (vis[t]) {
      if (!sp) {
        sp = t;
        int g = 0;
        while (g != sp) {
          g = sta[stp--];
          rnd[++ra] = g, onr[g] = ra;
        }
      }
    } else
      fr(t, x);
  }
  if (sta[stp] == x) sta[stp--] = 0;
}
void dfs(int x, int f, int r) {
  bl[x] = r;
  for (int i = he[x], t = e[i].to; i; i = e[i].ne, t = e[i].to) {
    if (t == f || onr[t]) continue;
    dis[t] = dis[x] + 1;
    dfs(t, x, r);
  }
}
void work(int x, int dep) {
  vis[x] = 1;
  if (x != rt) {
    if (bl[x] == bl[rt])
      ans += (long double)1.0 / (double)dep;
    else {
      double a = dis[rt] + dis[x], b = abs(onr[bl[x]] - onr[bl[rt]]) - 1,
             c = ra - 2 - b;
      ans += (long double)1.0 / (a + b) + 1.0 / (a + c) - 1.0 / (a + b + c);
    }
  }
  for (int i = he[x], t = e[i].to; i; i = e[i].ne, t = e[i].to) {
    if (!vis[t]) work(t, dep + 1);
  }
}
int mian() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++)
    scanf("%d%d", &xi, &yi), xi++, yi++, addline(xi, yi), addline(yi, xi);
  fr(1, 0);
  for (int i = 1; i <= ra; i++) {
    int x = rnd[i];
    dis[x] = 1;
    dfs(x, 0, x);
  }
  for (int i = 1; i <= n; i++) {
    memset(vis, 0, sizeof(vis));
    rt = i, work(i, 1);
  }
  ans += n;
  printf("%.10lf\n", ans);
  return 0;
}
}  // namespace RikukiIX
int main() { return RikukiIX::mian(); }
