#include <bits/stdc++.h>
using namespace std;
const int mx = 1e5 + 5;
int n, x[mx], y[mx], sol;
vector<int> X[mx], Y[mx];
set<int> point[mx];
int exist(int x, int y) { return point[x].count(y); }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x[i] >> y[i];
    point[x[i]].insert(y[i]);
    X[x[i]].push_back(y[i]);
    Y[y[i]].push_back(x[i]);
  }
  for (int i = 0; i < mx; i++) {
    sort(X[i].begin(), X[i].end());
    sort(Y[i].begin(), Y[i].end());
  }
  for (int i = 1; i <= n; i++) {
    if (X[x[i]].size() < Y[y[i]].size()) {
      int it = find(X[x[i]].begin(), X[x[i]].end(), y[i]) - X[x[i]].begin() + 1;
      for (int j = it; j < X[x[i]].size(); j++) {
        int d = X[x[i]][j] - y[i];
        sol += exist(x[i] + d, y[i]) && exist(x[i] + d, y[i] + d);
      }
    } else {
      int it = find(Y[y[i]].begin(), Y[y[i]].end(), x[i]) - Y[y[i]].begin() + 1;
      for (int j = it; j < Y[y[i]].size(); j++) {
        int d = Y[y[i]][j] - x[i];
        sol += exist(x[i], y[i] + d) && exist(x[i] + d, y[i] + d);
      }
    }
  }
  cout << sol << "\n";
  return 0;
}
