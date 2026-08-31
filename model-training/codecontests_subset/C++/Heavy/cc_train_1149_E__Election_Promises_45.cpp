#include <bits/stdc++.h>
using namespace std;
int v[500500];
vector<int> L[500500];
int xl[500500];
int lvl[500500];
void go(int x) {
  if (lvl[x]) return;
  map<int, int> mp;
  for (int i = 0; i < L[x].size(); i++) {
    go(L[x][i]);
    mp[lvl[L[x][i]]] = 1;
  }
  lvl[x] = 1;
  while (mp[lvl[x]]) lvl[x]++;
  xl[lvl[x]] ^= v[x];
}
int has(int a, int b) { return (a | b) == a; }
int bit(int a) {
  while (a != (a & -a)) a -= a & -a;
  return a;
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%d", v + i);
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d%d", &a, &b), a--, b--;
    L[a].push_back(b);
  }
  for (int i = 0; i < n; i++) go(i);
  for (int i = 0; i < n; i++) ("%d ", lvl[i]);
  ("\n");
  int u = n;
  while (u > 0 && xl[u] == 0) u--;
  if (u == 0) {
    printf("LOSE\n");
    return 0;
  }
  printf("WIN\n");
  int vx = 0;
  while (lvl[vx] != u || !has(v[vx], bit(xl[u]))) vx++;
  ("u %d vx %d\n", u, vx);
  v[vx] ^= xl[u];
  for (int i = 0; i < L[vx].size(); i++) {
    int to = L[vx][i];
    v[to] ^= xl[lvl[to]];
    xl[lvl[to]] = 0;
  }
  for (int i = 0; i < n; i++) printf("%d ", v[i]);
}
