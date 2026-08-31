#include <bits/stdc++.h>
using namespace std;
const int MAXK = 2 * 1e5 + 1;
vector<vector<int> > g, g1;
vector<vector<pair<int, int> > > need;
int sqrtn, ans;
vector<int> was;
void Do(vector<vector<int> > &g) {
  need.clear();
  need.resize(MAXK);
  for (int i = 0; i < MAXK; i++) {
    if (g[i].size() <= sqrtn && g[i].size() > 1) {
      for (int j = 0; j < g[i].size() - 1; j++)
        for (int k = j + 1; k < g[i].size(); k++) {
          need[i + abs(g[i][j] - g[i][k])].push_back(
              make_pair(g[i][j], g[i][k]));
          if ((i - abs(g[i][j] - g[i][k]) >= 0) &&
              (g[i - abs(g[i][j] - g[i][k])].size() > sqrtn))
            need[i - abs(g[i][j] - g[i][k])].push_back(
                make_pair(g[i][j], g[i][k]));
        }
    }
  }
  was.assign(MAXK, 0);
  for (int i = 0; i < MAXK; i++) {
    for (int j = 0; j < g[i].size(); j++) was[g[i][j]] = i + 1;
    for (int j = 0; j < need[i].size(); j++)
      if (was[need[i][j].first] == i + 1 && was[need[i][j].second] == i + 1)
        ans++;
    if (g[i].size() <= sqrtn) g[i].clear();
  }
}
int main() {
  int n;
  scanf("%i", &n);
  sqrtn = sqrt(0.0 + n);
  g.resize(MAXK);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%i%i", &x, &y);
    g[x].push_back(y);
  }
  Do(g);
  g1.resize(MAXK);
  for (int i = 0; i < MAXK; i++)
    for (int j = 0; j < g[i].size(); j++) g1[g[i][j]].push_back(i);
  Do(g1);
  cout << ans;
  return 0;
}
