#include <bits/stdc++.h>
using namespace std;
using ll = long long;
array<vector<ll>, 4> a[200000];
ll bst[200000][4];
ll dp[200000][10];
ll crd[200000][4];
int n;
ll f(int i, int t) {
  if (i == n) return 0;
  ll& sol = dp[i][t];
  if (sol != -1) return sol;
  sol = f(i + 1, t);
  for (int j = 1; j <= 3; ++j) {
    if (bst[i][j]) {
      ll c = 0;
      if (t + j >= 10) c = crd[i][j];
      sol = max(sol, c + bst[i][j] + f(i + 1, (t + j) % 10));
    }
  }
  return sol;
}
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int k;
    cin >> k;
    for (int j = 0; j < k; ++j) {
      int c, d;
      cin >> c >> d;
      a[i][c].push_back(d);
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 1; j <= 3; ++j)
      sort(begin(a[i][j]), end(a[i][j]), greater<ll>());
    if (a[i][1].size() >= 1) {
      bst[i][1] = a[i][1][0];
      crd[i][1] = a[i][1][0];
    }
    if (a[i][1].size() >= 2) {
      bst[i][2] = a[i][1][0] + a[i][1][1];
      crd[i][2] = max(a[i][1][0], a[i][1][1]);
    }
    if (a[i][1].size() >= 3) {
      bst[i][3] = a[i][1][0] + a[i][1][1] + a[i][1][2];
      crd[i][3] = max(a[i][1][0], max(a[i][1][1], a[i][1][2]));
    }
    if (a[i][2].size() >= 1) {
      ll nc = a[i][2][0];
      if (nc > bst[i][1]) {
        bst[i][1] = nc;
        crd[i][1] = a[i][2][0];
      }
    }
    if (a[i][1].size() >= 1 && a[i][2].size() >= 1) {
      ll nc = a[i][1][0] + a[i][2][0];
      if (nc > bst[i][2]) {
        bst[i][2] = nc;
        crd[i][2] = max(a[i][1][0], a[i][2][0]);
        ;
      }
    }
    if (a[i][3].size() >= 1) {
      ll nc = a[i][3][0];
      if (nc > bst[i][1]) {
        bst[i][1] = nc;
        crd[i][1] = a[i][3][0];
      }
    }
  }
  memset(dp, -1, sizeof dp);
  cout << f(0, 0);
}
