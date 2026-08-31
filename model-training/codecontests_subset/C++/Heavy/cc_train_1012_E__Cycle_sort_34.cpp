#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int n, s;
int niz[maxn], sol[maxn], saz[maxn];
vector<pair<int, int> > graph[maxn];
bool bio[maxn], bio2[maxn];
vector<int> sa;
vector<vector<int> > al;
vector<int> ac[maxn];
void dfs(int node) {
  bio2[node] = true;
  while (!graph[node].empty()) {
    const int nig = graph[node].back().first;
    const int id = graph[node].back().second;
    graph[node].pop_back();
    dfs(nig);
    sa.push_back(id + 1);
  }
}
int main() {
  memset(bio, false, sizeof bio);
  memset(bio2, false, sizeof bio2);
  scanf("%d%d", &n, &s);
  for (int i = 0; i < n; i++) scanf("%d", niz + i);
  for (int i = 0; i < n; i++) sol[i] = niz[i];
  sort(sol, sol + n);
  for (int i = 0; i < n; i++) saz[i] = sol[i];
  for (int i = 0; i < n; i++)
    niz[i] = lower_bound(saz, saz + n, niz[i]) - saz,
    sol[i] = lower_bound(saz, saz + n, sol[i]) - saz;
  for (int i = 0; i < n; i++) {
    if (niz[i] == sol[i]) continue;
    graph[sol[i]].push_back(make_pair(niz[i], i));
    s--;
  }
  if (s < 0) {
    printf("-1");
    return 0;
  }
  for (int i = 0; i < n; i++)
    if (niz[i] != sol[i]) ac[niz[i]].push_back(i + 1);
  for (int i = 0; i < n; i++) {
    if (bio2[i]) continue;
    dfs(i);
    reverse(sa.begin(), sa.end());
    if (sa.size() == 0) continue;
    al.push_back(sa);
    sa.clear();
  }
  if (s > 2 && al.size() > 1) {
    int ptr = 0;
    vector<int> pok, ne;
    int siz = (int)al.size();
    for (int i = 0; i < min(s, siz); i++) {
      for (int j = 0; j < al.back().size(); j++) {
        if (j == 0) pok.push_back(al.back()[j]);
        ne.push_back(al.back()[j]);
      }
      al.pop_back();
    }
    al.push_back(ne);
    reverse(pok.begin(), pok.end());
    al.push_back(pok);
  }
  printf("%d\n", al.size());
  for (int i = 0; i < al.size(); i++) {
    printf("%d\n", al[i].size());
    for (int j = 0; j < al[i].size(); j++) printf("%d ", al[i][j]);
    printf("\n");
  }
  return 0;
}
