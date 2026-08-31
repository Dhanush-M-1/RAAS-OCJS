#include <bits/stdc++.h>
using namespace std;
int n, k, deg[1000005], ar[1000005], jump[1000005], ans[1000005], br[1000005],
    lr[22][1000005];
vector<int> vr[1000005];
void lca(), dfs1(int), dfs(int, int);
int fin(int);
queue<int> qr;
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 2; i < n + 1; i++) {
    int y;
    scanf("%d", &y);
    vr[y].push_back(i);
  }
  dfs(1, 0);
  lca();
  for (int i = 1; i < n + 1; i++) ans[i] = i;
  dfs1(1);
  for (int i = 1; i < n + 1; i++) {
    br[i] = i;
    if (deg[i] == 0) {
      ar[ans[i]]++;
      qr.push(i);
    }
  }
  while (!qr.empty()) {
    int p = qr.front();
    qr.pop();
    deg[lr[0][p]]--;
    if (deg[lr[0][p]] == 0) {
      qr.push(lr[0][p]);
    }
    int m = 0;
    for (int i = 0; i < vr[p].size(); i++) {
      m = max(m, ar[vr[p][i]]);
    }
    ar[p] += m;
  }
  cout << ar[1] << " ";
}
void lca() {
  for (int j = 1; j < 22; j++)
    for (int i = 1; i < n + 1; i++) {
      lr[j][i] = lr[j - 1][lr[j - 1][i]];
    }
}
int fin(int idx, int k) {
  for (int i = 0; i < 22; i++) {
    if (k & (1 << i)) {
      idx = lr[i][idx];
    }
  }
  if (idx == 0) idx = 1;
  return idx;
}
int dr[1000005];
void dfs(int idx, int p) {
  lr[0][idx] = p;
  int v = 1e9;
  for (int i = 0; i < vr[idx].size(); i++) {
    if (vr[idx][i] == p) continue;
    deg[idx]++;
    dfs(vr[idx][i], idx);
    v = min(v, dr[vr[idx][i]]);
  }
  dr[idx] += 1 + (v == 1e9 ? 0 : v);
}
void dfs1(int idx) {
  ans[idx] = ans[fin(idx, max(0, k - (dr[idx] - 1)))];
  for (int i = 0; i < vr[idx].size(); i++) dfs1(vr[idx][i]);
}
