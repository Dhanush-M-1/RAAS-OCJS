#include <bits/stdc++.h>
using namespace std;
int n, ta, tb;
vector<pair<int, int> > v;
vector<int> vv[200005], vvv;
stack<int> s;
bool dfs(int a, int b) {
  bool deg = 0;
  for (int i = 0; i < vv[a].size(); i++)
    if (vv[a][i] == b)
      deg ^= 1;
    else
      deg ^= dfs(vv[a][i], a);
  if (deg) {
    s.push(a);
    return 1;
  }
  vvv.push_back(a);
  return 0;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    ta = i;
    scanf("%d", &tb);
    if (tb) {
      if (ta > tb) swap(ta, tb);
      v.push_back(make_pair(ta, tb));
    }
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size(); i++)
    if (!i || v[i] != v[i - 1]) {
      vv[v[i].first].push_back(v[i].second);
      vv[v[i].second].push_back(v[i].first);
    }
  if (dfs(1, 0))
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 0; i < vvv.size(); i++) printf("%d\n", vvv[i]);
    while (!s.empty()) {
      printf("%d\n", s.top());
      s.pop();
    }
  }
  return 0;
}
