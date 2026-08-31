#include <bits/stdc++.h>
using namespace std;
const int N = 300100;
int n, x, l[N], deg[N];
bool mark[N];
set<pair<int, int> > v[N];
vector<int> g[N];
vector<int> q;
vector<int> res;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &x);
    x--;
    if (x != -1) {
      g[x].push_back(i);
      g[i].push_back(x);
    }
  }
  for (int i = 0; i < n; i++) {
    l[i] = -1;
  }
  l[0] = 0;
  q.push_back(0);
  for (int i = 0; i < q.size(); i++) {
    int now = q[i];
    for (int j = 0; j < g[now].size(); j++) {
      int tmp = g[now][j];
      if (l[tmp] == -1) {
        q.push_back(tmp);
        l[tmp] = l[now] + 1;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    mark[i] = false;
    deg[i] = g[i].size();
    v[g[i].size() % 2].insert(make_pair(-l[i], i));
  }
  for (int i = 0; i < n; i++) {
    if (v[0].size() == 0) {
      puts("NO");
      exit(0);
    }
    int now = (*v[0].begin()).second;
    mark[now] = true;
    v[0].erase(v[0].begin());
    res.push_back(now + 1);
    for (int j = 0; j < g[now].size(); j++) {
      int tmp = g[now][j];
      if (mark[tmp]) {
        continue;
      }
      v[deg[tmp] & 1].erase(make_pair(-l[tmp], tmp));
      deg[tmp]--;
      v[deg[tmp] & 1].insert(make_pair(-l[tmp], tmp));
    }
  }
  puts("YES");
  for (int i = 0; i < res.size(); i++) {
    printf("%d\n", res[i]);
  }
  return 0;
}
