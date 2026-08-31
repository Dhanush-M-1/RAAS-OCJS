#include <bits/stdc++.h>
using namespace std;
const int inf = ((1 << 30) - 1);
const long long linf = ((1ll << 62) - 1);
const int cmax = 1001;
int n, x;
int a[cmax];
bool u[cmax];
vector<vector<int> > groups;
vector<int> ts;
void topSort(int v) {
  if (u[v]) return;
  u[v] = true;
  if (a[v] != -1) topSort(a[v]);
  ts.push_back(v);
}
void go(int v, vector<int> &c) {
  u[v] = true;
  c.push_back(v);
  if (a[v] != -1) go(a[v], c);
}
int dp[cmax][cmax];
int main() {
  int index;
  assert(scanf("%d%d", &n, &x)), --x;
  for (int i = 0; i < n; i++) assert(scanf("%d", &a[i])), --a[i];
  for (int i = 0; i < n; i++) topSort(i);
  memset(u, 0, sizeof(bool) * n);
  reverse((ts).begin(), (ts).end());
  for (int i = 0; i < n; i++)
    if (!u[ts[i]])
      groups.push_back(vector<int>()),
          go(ts[i], groups[((int)(groups).size()) - 1]);
  for (int i = 0; i < ((int)(groups).size()); i++) {
    int pos =
        find((groups[i]).begin(), (groups[i]).end(), x) - groups[i].begin();
    if (pos != ((int)(groups[i]).size())) {
      groups.erase(groups.begin() + i);
      index = pos;
      break;
    }
  }
  dp[0][0] = 1;
  for (int i = 0; i < ((int)(groups).size()); i++)
    for (int j = 0; j < n; j++)
      if (dp[i][j])
        dp[i + 1][j] = true, dp[i + 1][j + ((int)(groups[i]).size())] = true;
  for (int i = n - 1; i >= 0; i--)
    if (dp[((int)(groups).size())][i]) cout << n - i - index << '\n';
  return 0;
}
