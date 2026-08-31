#include <bits/stdc++.h>
using namespace std;
const int N = 200010;
struct A {
  int x, id;
} a[N];
bool cmp(A x, A y) { return x.x < y.x; }
int a0[N], s[N], f[N], pre[N], nxt[N];
int f_f(int x) { return x == f[x] ? x : f[x] = f_f(f[x]); }
bool vv[N];
vector<int> t[N];
int main() {
  int n, S;
  scanf("%d%d", &n, &S);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a0[i]);
    a[i] = (A){a0[i], i};
  }
  sort(a + 1, a + 1 + n, cmp);
  int cc = 0;
  for (int i = 1; i <= n; i++) {
    if (i == 1 || a[i].x != a[i - 1].x) s[cc] = i - 1, cc++;
    a0[a[i].id] = cc;
  }
  s[cc] = n;
  for (int i = 1; i <= n; i++) {
    a[i].x = a0[a[i].id], f[i] = i;
    if (a[i].id > s[a[i].x - 1] && a[i].id <= s[a[i].x]) vv[a[i].id] = true;
  }
  for (int i = 1; i <= n; i++)
    if (!vv[i]) {
      while (vv[s[a0[i] - 1] + 1]) s[a0[i] - 1]++;
      nxt[i] = s[a0[i] - 1] + 1, pre[nxt[i]] = i, s[a0[i] - 1]++;
      int fa = f_f(i), fb = f_f(nxt[i]);
      if (fa != fb) f[fa] = fb;
    }
  int la = 0;
  for (int i = 1; i <= n; i++)
    if (!vv[a[i].id]) {
      if (!la || a[i].x != a[la].x)
        la = i;
      else {
        int c0 = a[i].id, c1 = a[la].id, fa = f_f(c0), fb = f_f(c1);
        if (fa != fb) {
          swap(nxt[c0], nxt[c1]);
          f[fa] = fb;
        }
      }
    }
  int g0 = 0, g1 = 0;
  for (int i = 1; i <= n; i++)
    if (!vv[i]) {
      g1++;
      int tmp = nxt[i];
      while (true) {
        g0++, t[g1].push_back(tmp);
        vv[tmp] = true;
        if (tmp == i) break;
        tmp = nxt[tmp];
      }
    }
  if (g0 > S) {
    printf("-1\n");
    return 0;
  }
  int tmp = max(g0 + g1 - S, 0);
  if (tmp + 2 > g1) {
    printf("%d\n", g1);
    for (int i = 1; i <= g1; i++) {
      printf("%d\n", t[i].size());
      for (int j = 0; j <= t[i].size() - 1; j++) printf("%d ", t[i][j]);
      printf("\n");
    }
  } else {
    printf("%d\n", tmp + 2);
    for (int i = 1; i <= tmp; i++) {
      printf("%d\n", t[i].size());
      for (int j = 0; j <= t[i].size() - 1; j++) printf("%d ", t[i][j]);
      printf("\n");
    }
    int sum = 0;
    for (int i = tmp + 1; i <= g1; i++) sum += t[i].size();
    printf("%d\n", sum);
    for (int i = tmp + 1; i <= g1; i++)
      for (int j = 0; j <= t[i].size() - 1; j++) printf("%d ", t[i][j]);
    printf("\n");
    printf("%d\n", g1 - tmp);
    for (int i = g1; i > tmp; i--) printf("%d ", t[i][0]);
    printf("\n");
  }
  return 0;
}
