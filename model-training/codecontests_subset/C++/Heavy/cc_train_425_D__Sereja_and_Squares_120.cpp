#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int N = 1e5 + 10;
set<int> X[N], Y[N];
bool check(int x, int y) {
  if (x < 0 || x >= N || y < 0 || y >= N) return 0;
  return X[x].count(y);
}
void erase(int x, int y) {
  X[x].erase(y);
  Y[y].erase(x);
}
ll ans = 0;
void solvex(int x) {
  while (!X[x].empty()) {
    int y = *X[x].begin();
    erase(x, y);
    for (auto y2 : X[x]) {
      int len = y2 - y;
      if (check(x + len, y) && check(x + len, y + len)) {
        ans++;
      }
      if (check(x - len, y) && check(x - len, y + len)) {
        ans++;
      }
    }
  }
}
void solvey(int y) {
  while (!Y[y].empty()) {
    int x = *Y[y].begin();
    erase(x, y);
    for (auto x2 : Y[y]) {
      int len = x2 - x;
      if (check(x, y + len) && check(x + len, y + len)) {
        ans++;
      }
      if (check(x, y - len) && check(x + len, y - len)) {
        ans++;
      }
    }
  }
}
int main() {
  int n;
  scanf("%d", &n);
  vector<int> x(n), y(n);
  for (int i = 0; i < n; ++i) {
    scanf("%d%d", &x[i], &y[i]);
  }
  for (int i = 0; i < n; ++i) {
    X[x[i]].insert(y[i]);
    Y[y[i]].insert(x[i]);
  }
  for (int i = 0; i < N; ++i) {
    if (X[i].size() * X[i].size() <= n) {
      solvex(i);
    }
  }
  for (int i = 0; i < N; ++i) {
    solvey(i);
  }
  cout << ans << endl;
  return 0;
}
