#include <bits/stdc++.h>
using namespace std;
int id[510000];
int st[510000], en[510000], w[510000], f[1100], pos[1100];
bool cmp(int i, int j) { return w[i] < w[j]; }
int Fa(int x) {
  if (f[x] == x) return x;
  return f[x] = Fa(f[x]);
}
int n, m;
vector<int> root[1100];
int calc(int L, int R) {
  for (int i = 1; i <= n; i++)
    f[i] = i, pos[i] = 0, root[i].clear(), root[i].push_back(i);
  ;
  for (int i = m; i; i--) {
    int j = id[i];
    if (j < L || j > R) continue;
    int x = st[j];
    int y = en[j];
    int in = (pos[x] == pos[y]);
    int xx = Fa(x);
    int yy = Fa(y);
    if (xx == yy) {
      if (pos[x] == pos[y]) return w[j];
      continue;
    }
    x = xx;
    y = yy;
    if (root[x].size() < root[y].size()) swap(x, y);
    for (int k = 0; k < root[y].size(); k++) {
      int aa = root[y][k];
      root[x].push_back(aa);
      pos[aa] ^= in;
    }
    root[y].clear();
    f[y] = x;
  }
  return -1;
}
int main() {
  int L, R, Q;
  scanf("%d%d%d", &n, &m, &Q);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &st[i], &en[i], &w[i]);
  }
  for (int i = 1; i <= m; i++) id[i] = i;
  sort(id + 1, id + m + 1, cmp);
  int cnt = 0;
  for (int i = 1; i <= Q; i++) {
    scanf("%d%d", &L, &R);
    printf("%d\n", calc(L, R));
  }
  return 0;
}
