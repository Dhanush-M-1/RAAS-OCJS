#include <bits/stdc++.h>
using namespace std;
int par[1010];
int cnt[1010];
bool ba[1010];
vector<int> v;
int n, m, k;
void init() {
  for (int i = 0; i <= n; i++) par[i] = i;
}
int getPar(int a) {
  if (par[a] == a)
    return a;
  else
    return par[a] = getPar(par[a]);
}
void merge(int a, int b) {
  int pa = getPar(a), pb = getPar(b);
  par[pa] = pb;
}
void countPar() {
  for (int i = 1; i <= n; i++) {
    cnt[getPar(i)]++;
    if (!ba[par[i]]) {
      ba[par[i]] = true;
      v.push_back(par[i]);
    }
  }
}
int gDepth(int a) {
  if (par[a] == a) return 1;
  return gDepth(par[a]) + 1;
}
int main() {
  cin >> n >> m;
  init();
  for (int i = 1; i <= n; i++) {
    int a;
    cin >> a;
    if (a == 0) continue;
    par[i] = a;
  }
  k = gDepth(m);
  countPar();
  memset(ba, 0, sizeof(ba));
  ba[k] = true;
  int l = v.size();
  for (int i = 0; i < l; i++) {
    for (int j = n; j > 0; j--) {
      if (v[i] != par[m] && j - cnt[v[i]] > 0 && ba[j - cnt[v[i]]])
        ba[j] = true;
    }
  }
  for (int i = 1; i <= n; i++)
    if (ba[i]) cout << i << '\n';
}
