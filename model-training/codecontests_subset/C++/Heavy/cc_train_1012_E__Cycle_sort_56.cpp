#include <bits/stdc++.h>
using namespace std;
int n, k;
int a[200010];
int b[200010];
vector<pair<int, int> > graf[200010];
vector<int> tura;
vector<int> sz;
vector<vector<int> > sol;
vector<vector<int> > rj;
vector<int> r;
int bio[200010];
int siz = 0;
void dfs(int x) {
  bio[x] = 1;
  while (!graf[x].empty()) {
    int sus = graf[x][(int)graf[x].size() - 1].first;
    int br = graf[x][(int)graf[x].size() - 1].second;
    graf[x].pop_back();
    dfs(sus);
    tura.push_back(br);
  }
}
void sazimanje() {
  for (int i = 1; i <= n; i++) sz.push_back(a[i]);
  sort(sz.begin(), sz.end());
  sz.erase(unique(sz.begin(), sz.end()), sz.end());
  siz = (int)sz.size() - 1;
  for (int i = 1; i <= n; i++) {
    a[i] = lower_bound(sz.begin(), sz.end(), a[i]) - sz.begin();
    b[i - 1] = a[i];
  }
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  sazimanje();
  sort(b, b + n);
  int cnt = 0;
  for (int i = n - 1; i >= 0; i--) {
    b[i + 1] = b[i];
    b[i] = 0;
    if (a[i + 1] != b[i + 1]) {
      cnt++;
      graf[b[i + 1]].push_back(make_pair(a[i + 1], i + 1));
    }
  }
  if (cnt > k) {
    printf("-1");
    return 0;
  }
  for (int i = 1; i <= siz; i++) {
    if (bio[i] == 0) {
      tura.clear();
      dfs(i);
      reverse(tura.begin(), tura.end());
      if (tura.size() >= 1) sol.push_back(tura);
    }
  }
  int sad = min((int)sol.size(), k - cnt);
  if (sad > 1) {
    for (int i = sad - 1; i >= 0; i--) {
      r.push_back(sol[i].back());
    }
    rj.push_back(r);
    r.clear();
    for (int i = 0; i < sad; i++) {
      for (int j = 0; j < sol[i].size(); j++) {
        r.push_back(sol[i][j]);
      }
    }
    rj.push_back(r);
    for (int i = sad; i < sol.size(); i++) {
      rj.push_back(sol[i]);
    }
    swap(sol, rj);
  }
  printf("%d\n", sol.size());
  for (int i = 0; i < sol.size(); i++) {
    printf("%d\n", sol[i].size());
    for (int j = 0; j < sol[i].size(); j++) printf("%d ", sol[i][j]);
    printf("\n");
  }
  return 0;
}
