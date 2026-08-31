#include <bits/stdc++.h>
using namespace std;
const int mx = 200 * 1000 + 5;
vector<set<int> > vec(mx);
int arr1[mx], arr2[mx];
int main() {
  int i, j, k, n, m, x, y, p, q, l;
  scanf("%d %d %d", &n, &m, &k);
  int ans = 0;
  for (i = 0; i < m; i++) {
    scanf("%d %d", &x, &y);
    arr1[i] = x;
    arr2[i] = y;
    vec[x].insert(y);
    vec[y].insert(x);
  }
  ans = n;
  queue<int> ajairra;
  bool vis[n + 5];
  memset(vis, 0, sizeof(vis));
  for (i = 1; i <= n; i++) {
    p = vec[i].size();
    if (p < k) {
      vis[i] = 1;
      ans--;
      ajairra.push(i);
    }
  }
  vector<int> vv;
  set<int>::iterator itr;
  for (i = m - 1; i >= 0; i--) {
    while (!ajairra.empty()) {
      p = ajairra.front();
      ajairra.pop();
      for (itr = vec[p].begin(); itr != vec[p].end(); itr++) {
        q = *itr;
        vec[q].erase(p);
        l = vec[q].size();
        if (l < k && !vis[q]) {
          vis[q] = 1;
          ans--;
          ajairra.push(q);
        }
      }
      vec[p].clear();
    }
    vv.push_back(ans);
    p = arr1[i];
    q = arr2[i];
    vec[p].erase(q);
    vec[q].erase(p);
    l = vec[p].size();
    if (l < k && !vis[p]) {
      vis[p] = 1;
      ans--;
      ajairra.push(p);
    }
    l = vec[q].size();
    if (l < k && !vis[q]) {
      vis[q] = 1;
      ans--;
      ajairra.push(q);
    }
  }
  for (i = m - 1; i >= 0; i--) {
    printf("%d\n", vv[i]);
  }
  return 0;
}
