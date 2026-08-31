#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
vector<int> g[N];
bool seen[N][2], dp[N][2];
vector<pair<int, int> > bk[N][2];
bool solve(int i, bool p, int par);
void back(int i, bool p);
int main() {
  int n;
  cin >> n;
  int root = -1;
  for (int i = 1; i <= n; ++i) {
    int p;
    cin >> p;
    if (!p) {
      root = i;
    } else {
      g[i].push_back(p);
      g[p].push_back(i);
    }
  }
  if (solve(root, 0, 0)) {
    cout << "YES\n";
    back(root, 0);
  } else {
    cout << "NO\n";
  }
}
bool solve(int i, bool p, int par) {
  if (seen[i][p]) {
    return dp[i][p];
  }
  seen[i][p] = true;
  int tot = 0, codd = 0, ceven = 0, both = 0;
  for (auto &j : g[i]) {
    if (j == par) {
      continue;
    } else {
      ++tot;
      int o = solve(j, 1, i);
      int e = solve(j, 0, i);
      if (!o and !e) {
        dp[i][p] = false;
        return false;
      }
      codd += o;
      ceven += e;
    }
  }
  if (tot % 2 == p) {
    if ((tot - ceven) % 2) {
      dp[i][p] = false;
    } else {
      dp[i][p] = true;
      for (auto &j : g[i]) {
        if (j != par and !solve(j, 0, i)) {
          bk[i][p].push_back({j, 1});
        }
      }
      bk[i][p].push_back({i, p});
      for (auto &j : g[i]) {
        if (j != par and solve(j, 0, i)) {
          bk[i][p].push_back({j, 0});
        }
      }
    }
  } else {
    if (!codd) {
      dp[i][p] = false;
    } else if ((codd - both) % 2) {
      dp[i][p] = true;
      for (auto &j : g[i]) {
        if (j != par and !solve(j, 0, i)) {
          bk[i][p].push_back({j, 1});
        }
      }
      bk[i][p].push_back({i, p});
      for (auto &j : g[i]) {
        if (j != par and solve(j, 0, i)) {
          bk[i][p].push_back({j, 0});
        }
      }
    } else if (both) {
      dp[i][p] = true;
      int k = 0;
      for (auto &j : g[i]) {
        if (j != par and solve(j, 0, i) and solve(j, 1, i)) {
          bk[i][p].push_back({j, 1});
          k = j;
          break;
        }
      }
      for (auto &j : g[i]) {
        if (j != par and !solve(j, 0, i)) {
          bk[i][p].push_back({j, 1});
        }
      }
      bk[i][p].push_back({i, p});
      for (auto &j : g[i]) {
        if (j != par and solve(j, 0, i) and j != k) {
          bk[i][p].push_back({j, 0});
        }
      }
    } else {
      dp[i][p] = false;
    }
  }
  return dp[i][p];
}
void back(int i, bool p) {
  for (auto &cur : bk[i][p]) {
    if (cur.first == i) {
      cout << i << '\n';
    } else {
      back(cur.first, cur.second);
    }
  }
}
