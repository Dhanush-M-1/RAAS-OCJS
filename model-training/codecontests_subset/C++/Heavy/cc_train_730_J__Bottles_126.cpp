#include <bits/stdc++.h>
using namespace std;
struct node {
  int ase, cap;
  node() {}
  node(int _koyta, int _pr) {
    ase = _koyta;
    cap = _pr;
  }
  bool operator<(const node& P) const {
    if (cap == P.cap) return ase < P.ase;
    return cap < P.cap;
  }
};
struct edge {
  int koyta, pr;
  edge() {}
  edge(int _koyta, int _pr) {
    koyta = _koyta;
    pr = _pr;
  }
  bool operator<(const edge& P) const {
    if (koyta == P.koyta) return pr < P.pr;
    return koyta < P.koyta;
  }
};
vector<node> vc;
int n;
edge dp[120][32000];
int vis[120][32000];
edge dp_func(int pos, int container) {
  if (pos == n) {
    if (container <= 20000) return {0, 0};
    return {200, 42000};
  }
  int l;
  if (vis[pos][container]) return dp[pos][container];
  vis[pos][container] = 1;
  edge ret = {200, 42000}, temp;
  temp = dp_func(pos + 1, container - vc[pos].cap);
  temp.koyta += 1;
  ret = min(ret, temp);
  temp = dp_func(pos + 1, container + vc[pos].ase);
  temp.pr += vc[pos].ase;
  ret = min(ret, temp);
  if (container > 20000) {
    l = container - 20000;
    l = min(l, vc[pos].cap);
    temp = dp_func(pos + 1, container - l);
    temp.koyta += 1;
    ret = min(ret, temp);
  }
  if (container < 20000) {
    l = 20000 - container;
    if (l < vc[pos].ase) {
      temp = dp_func(pos + 1, 20000 + vc[pos].ase - l);
      temp.pr += vc[pos].ase;
      ret = min(ret, temp);
    } else {
      temp = dp_func(pos + 1, container + vc[pos].ase);
      temp.pr += vc[pos].ase;
      ret = min(ret, temp);
    }
  }
  return dp[pos][container] = ret;
}
int main() {
  int i, j, k, l, m;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &l);
    node gr;
    gr.ase = l;
    vc.push_back(gr);
  }
  for (i = 1; i <= n; i++) {
    scanf("%d", &l);
    vc[i - 1].cap = l - vc[i - 1].ase;
  }
  edge gr = dp_func(0, 20000);
  printf("%d %d\n", gr.koyta, gr.pr);
}
