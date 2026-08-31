#include <bits/stdc++.h>
using namespace std;
const int N = 100100;
int n, m, x[N], y[N];
vector<int> e[N], id[N], ans;
bool vn[N], ve[N];
int dfs(int nd) {
  if (vn[nd]) return 0;
  vn[nd] = 1;
  int up = 0;
  for (int i = 0; i < e[nd].size(); i++) {
    if (!ve[id[nd][i]]) {
      ve[id[nd][i]] = 1;
      int k = dfs(e[nd][i]);
      if (!k) {
        if (up == 0) {
          up = id[nd][i];
        } else {
          ans.push_back(id[nd][i]);
          ans.push_back(up);
          up = 0;
        }
      } else {
        ans.push_back(id[nd][i]);
        ans.push_back(k);
      }
    }
  }
  return up;
}
int main() {
  if (fopen("E.in", "r")) freopen("E.in", "r", stdin);
  cin >> n >> m;
  if (m % 2) {
    cout << "No solution";
    return 0;
  }
  for (int i = 1; i <= m; i++) {
    scanf("%d %d", x + i, y + i);
    e[x[i]].push_back(y[i]);
    id[x[i]].push_back(i);
    e[y[i]].push_back(x[i]);
    id[y[i]].push_back(i);
  }
  dfs(1);
  for (int i = 0; i < ans.size() - 1; i += 2) {
    if (x[ans[i]] == x[ans[i + 1]]) {
      printf("%d %d %d\n", y[ans[i]], x[ans[i]], y[ans[i + 1]]);
    } else if (x[ans[i]] == y[ans[i + 1]]) {
      printf("%d %d %d\n", y[ans[i]], x[ans[i]], x[ans[i + 1]]);
    } else if (y[ans[i]] == x[ans[i + 1]]) {
      printf("%d %d %d\n", x[ans[i]], y[ans[i]], y[ans[i + 1]]);
    } else if (y[ans[i]] == y[ans[i + 1]]) {
      printf("%d %d %d\n", x[ans[i]], y[ans[i]], x[ans[i + 1]]);
    }
  }
  return 0;
}
