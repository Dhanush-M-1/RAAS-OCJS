#include <bits/stdc++.h>
using namespace std;
int entry[3005], low[3005], n, tme = 1, scc[3005], sp[3005], sp2[3005], cycle,
                               cnt, cc;
vector<int> myvec[3005], ans;
bool bridges[3005][3005];
double prob, ret;
queue<int> q;
int dfs(int x, int p) {
  int i, j, k;
  low[x] = entry[x] = tme++;
  for (i = 0; i < myvec[x].size(); i++) {
    j = myvec[x][i];
    if (j == p) continue;
    if (entry[j] == 0) {
      k = dfs(j, x);
      if (k > entry[x]) {
        bridges[min(j, x)][max(j, x)] = 1;
      }
      low[x] = min(low[x], k);
    } else
      low[x] = min(low[x], entry[j]);
  }
  return low[x];
}
void make_scc(int x, int c) {
  scc[x] = c;
  cnt++;
  int i, j, k;
  for (i = 0; i < myvec[x].size(); i++) {
    j = myvec[x][i];
    if (scc[j] != -1) continue;
    if (bridges[min(j, x)][max(j, x)]) continue;
    make_scc(j, c);
  }
}
int main() {
  int i, j, k, p;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scc[i] = -1;
    scanf("%d %d", &j, &k);
    myvec[j].push_back(k);
    myvec[k].push_back(j);
  }
  dfs(0, -1);
  for (i = 0; i < n; i++) {
    if (scc[i] != -1) continue;
    cnt = 0;
    make_scc(i, i);
    if (cnt > 1) {
      cc = i;
      cycle = cnt;
    }
  }
  for (ret = 0, i = 0; i < n; i++) {
    for (j = 0; j < n; j++) sp[j] = -1;
    q.push(i);
    sp[i] = sp2[i] = 0;
    while (!q.empty()) {
      k = q.front();
      q.pop();
      for (j = 0; j < myvec[k].size(); j++) {
        p = myvec[k][j];
        if (sp[p] != -1) continue;
        sp[p] = sp[k] + (bridges[min(k, p)][max(k, p)]);
        sp2[p] = sp2[k] + (!bridges[min(k, p)][max(k, p)]);
        q.push(p);
      }
    }
    for (j = 0; j < n; j++) {
      if (sp2[j] == 0) {
        ret += (1 / (double)(sp[j] + 1));
      } else if (sp[j] == 0) {
        double d = sp2[j] + 1.0;
        double d2 = cycle - d + 2;
        ret += (1 / d) + (1 / d2) - (1 / (d + d2 - 2));
      } else {
        double d = sp[j] + 2.0;
        double d2 = sp2[j] - 1.0;
        double d3 = cycle - d2 - 2;
        ret += (1 / (d + d2)) + (1 / (d + d3)) - (1 / (d + d2 + d3));
      }
    }
  }
  printf("%.8lf\n", ret);
  return 0;
}
