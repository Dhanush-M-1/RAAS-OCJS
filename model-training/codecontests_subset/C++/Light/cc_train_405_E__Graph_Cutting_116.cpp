#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 3;
int who[MAXN];
int kol[MAXN];
bool odw[MAXN];
set<int> v[MAXN];
vector<int> ans;
vector<int> tree[MAXN];
int ile = 0, kra = 0;
void DFS(int x) {
  int k, me = ile;
  who[me] = x;
  odw[x] = true;
  while (!v[x].empty()) {
    k = *v[x].begin();
    v[x].erase(v[x].begin());
    v[k].erase(x);
    ile++;
    kra++;
    tree[me].push_back(ile);
    DFS(k);
  }
}
bool DFS2(int x) {
  vector<int> kat;
  for (auto it : tree[x]) {
    if (DFS2(it)) {
      ans.push_back(who[x]);
      ans.push_back(who[it]);
      ans.push_back(kol[it]);
    } else
      kat.push_back(who[it]);
  }
  while (kat.size() > 1) {
    ans.push_back(kat.back());
    kat.pop_back();
    ans.push_back(who[x]);
    ans.push_back(kat.back());
    kat.pop_back();
  }
  if (!kat.empty()) {
    kol[x] = kat.back();
    return true;
  }
  return false;
}
int main() {
  int n, m;
  int x, y;
  scanf("%d %d", &n, &m);
  while (m--) {
    scanf("%d %d", &x, &y);
    v[x].insert(y);
    v[y].insert(x);
  }
  for (int i = 1; i <= n; i++) {
    if (!odw[i]) {
      ile++;
      y = ile;
      DFS(i);
      if (kra % 2 != 0) {
        printf("No solution");
        return 0;
      }
      DFS2(y);
    }
  }
  for (int i = 0; i < (int)(ans.size()); i += 3)
    printf("%d %d %d\n", ans[i], ans[i + 1], ans[i + 2]);
  return 0;
}
