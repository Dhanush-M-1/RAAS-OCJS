#include <bits/stdc++.h>
using namespace std;
const int M = 1e5;
const int Q = 1e9 + 7;
const int T = 302;
vector<pair<int, int> > sp;
vector<int> d1;
vector<int> g[M + 10];
map<pair<int, int>, bool> ma;
inline bool is(int i, int j) {
  if (i < 0 || i > M) return false;
  if ((int)g[i].size() == 0) return false;
  int tmp = lower_bound(g[i].begin(), g[i].end(), j) - g[i].begin();
  if (tmp < (int)g[i].size() && g[i][tmp] == j) return true;
  return false;
}
int main() {
  srand(time(NULL));
  int n, ans = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    g[x].push_back(y);
  }
  for (int i = 0; i <= M; i++) sort(g[i].begin(), g[i].end());
  for (int i = 0; i <= M; i++) {
    if (g[i].size() == 0) continue;
    if ((int)g[i].size() < T) {
      for (int j = 0; j < (int)g[i].size(); j++)
        for (int k = j + 1; k < (int)g[i].size(); k++) {
          int d = g[i][k] - g[i][j];
          if (is(i + d, g[i][j]) && is(i + d, g[i][k])) ans++;
          if (is(i - d, g[i][j]) && is(i - d, g[i][k])) ans++;
        }
      g[i].resize(0);
    } else {
      for (int j = 0; j < (int)g[i].size(); j++) {
        sp.push_back(make_pair(i, g[i][j]));
      }
      d1.push_back(i);
    }
  }
  assert((int)d1.size() <= 100000 / 300);
  for (int i = 0; i < (int)sp.size(); i++) {
    for (int j = 0; j < (int)d1.size(); j++) {
      if (sp[i].first >= d1[j]) continue;
      int d = abs(d1[j] - sp[i].first);
      if (is(sp[i].first + d, sp[i].second) &&
          is(sp[i].first, sp[i].second + d) &&
          is(sp[i].first + d, sp[i].second + d))
        ans++;
    }
  }
  cout << ans;
  return 0;
}
