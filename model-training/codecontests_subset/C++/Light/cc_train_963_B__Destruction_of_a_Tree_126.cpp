#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, p[N], la[N], ne[N], rt, d[N];
int an[N], ans, f[N][3], ct[N][3], b[N];
void dfs(int x) {
  for (int i = la[x]; i; i = ne[i]) dfs(i);
  int cnt = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
  for (int i = la[x]; i; i = ne[i]) {
    cnt += f[i][2];
    if (f[i][2])
      cnt2 += f[i][1];
    else
      cnt3 += f[i][1];
  }
  ct[x][1] = cnt;
  ct[x][2] = cnt2;
  ct[x][3] = cnt3;
  if ((!((d[x] - cnt) & 1) || cnt2 > 0) && (cnt3 + cnt == d[x])) f[x][1] = 1;
  if ((((d[x] - cnt) & 1) || cnt2 > 0) && (cnt3 + cnt == d[x])) f[x][2] = 1;
}
void fi(int x, int st) {
  int ne1;
  b[x] = st;
  if (st == 1)
    ne1 = !((d[x] - ct[x][1]) & 1) && ct[x][2] > 0;
  else
    ne1 = ((d[x] - ct[x][1]) & 1) && ct[x][2] > 0;
  for (int i = la[x]; i; i = ne[i]) {
    if (f[i][2]) {
      fi(i, 2);
      if (ne1 && f[i][1]) ne1--, fi(i, 1);
    }
  }
  an[++ans] = x;
  for (int i = la[x]; i; i = ne[i])
    if (!b[i]) fi(i, 1);
}
int main() {
  scanf("%d", &n);
  for (int i = 1, E = n; i <= E; i++)
    scanf("%d", &p[i]),
        (p[i] ? ne[i] = la[p[i]], la[p[i]] = i, d[p[i]]++ : rt = i);
  dfs(rt);
  if (f[rt][1]) {
    printf("YES\n");
    fi(rt, 1);
    for (int i = 1, E = n; i <= E; i++) printf("%d ", an[i]);
  } else
    printf("NO\n");
}
