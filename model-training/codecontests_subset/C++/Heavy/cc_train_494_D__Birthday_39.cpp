#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
int n, m;
vector<pair<int, int> > edge[200000];
struct INFO {
  long long depth;
  long long dis;
  long long child;
  long long down1, down2, up1, up2;
} d[200000];
int par[200000][20];
long long mod(long long x) {
  return (x % 1000000007 + 1000000007) % 1000000007;
}
void back(int now, int parent) {
  long long ccnt = 0, cnt1 = 0, cnt2 = 0;
  par[now][0] = parent == -1 ? now : parent;
  for (int i = 1; i < 20; i++) {
    par[now][i] = par[par[now][i - 1]][i - 1];
  }
  for (auto e : edge[now]) {
    if (e.first == parent) continue;
    d[e.first].depth = d[now].depth + 1;
    d[e.first].dis = d[now].dis + e.second;
    d[e.first].dis %= 1000000007;
    back(e.first, now);
    ccnt += d[e.first].child;
    ccnt %= 1000000007;
    cnt1 += d[e.first].down1 + d[e.first].child * e.second;
    cnt1 %= 1000000007;
    cnt2 += d[e.first].down2 + 2 * d[e.first].down1 * e.second;
    cnt2 %= 1000000007;
    cnt2 += d[e.first].child * e.second % 1000000007 * e.second;
    cnt2 %= 1000000007;
  }
  d[now].child = ccnt + 1;
  d[now].down1 = cnt1;
  d[now].down2 = cnt2;
}
void upback(int now, int parent, int dis) {
  if (parent != -1) {
    long long u = d[parent].up1 + d[parent].down1 -
                  (d[now].down1 + d[now].child * dis % 1000000007);
    d[now].up1 = u + dis * (n - d[now].child);
    d[now].up1 %= 1000000007;
    u = d[parent].up2 + d[parent].down2 -
        (d[now].down2 + 2 * d[now].down1 * dis % 1000000007 +
         d[now].child * dis % 1000000007 * dis % 1000000007);
    d[now].up2 = u +
                 2 * (d[now].up1 - dis * (n - d[now].child) % 1000000007) *
                     dis % 1000000007 +
                 (n - d[now].child) * dis % 1000000007 * dis % 1000000007;
    d[now].up2 %= 1000000007;
  }
  for (auto e : edge[now]) {
    if (e.first == parent) continue;
    upback(e.first, now, e.second);
  }
}
int getlca(int x, int y) {
  if (d[x].depth < d[y].depth) swap(x, y);
  int dis = d[x].depth - d[y].depth;
  int i, j;
  for (i = 0; i < 20; i++) {
    if (dis & (1 << i)) x = par[x][i];
  }
  if (x == y) return x;
  for (i = 19; i >= 0; i--) {
    if (par[x][i] != par[y][i]) x = par[x][i], y = par[y][i];
  }
  return par[x][0];
}
int main() {
  int i, j, k;
  scanf("%d", &n);
  for (i = 0; i < n - 1; i++) {
    int x, y, z;
    scanf("%d%d%d", &x, &y, &z), x--, y--;
    edge[x].push_back(pair<int, int>(y, z));
    edge[y].push_back(pair<int, int>(x, z));
  }
  back(0, -1);
  upback(0, -1, 0);
  scanf("%d", &m);
  for (i = 0; i < m; i++) {
    int x, y;
    scanf("%d%d", &x, &y), x--, y--;
    int lca = getlca(x, y);
    if (lca == y) {
      long long dis = d[x].dis - d[y].dis;
      long long u = d[y].up2 + 2 * dis * d[y].up1 % 1000000007 +
                    (n - d[y].child) * dis % 1000000007 * dis % 1000000007;
      long long dab = d[x].up2 + d[x].down2 - 2 * u;
      printf("%I64d\n", mod(dab));
    } else {
      long long dis = d[x].dis + d[y].dis - 2 * d[lca].dis;
      long long u = d[y].down2 + 2 * dis * d[y].down1 % 1000000007 +
                    d[y].child * dis % 1000000007 * dis % 1000000007;
      long long dab = 2 * u - d[x].down2 - d[x].up2;
      printf("%I64d\n", mod(dab));
    }
  }
  return 0;
}
