#include <bits/stdc++.h>
using namespace std;
template <class T>
inline int maximize(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
inline int minimize(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
const int N = 100001, M = 1e7 + 7;
int n, x, y;
long long ans;
vector<int> Vx[N], Vy[N];
int check(int x, int y) {
  if (x >= N || y >= N) return 0;
  int l = 0, r = Vx[x].size() - 1;
  while (l <= r) {
    int m = l + r >> 1;
    if (Vx[x][m] == y)
      return 1;
    else if (Vx[x][m] < y)
      r = m - 1;
    else
      l = m + 1;
  }
  return 0;
}
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) {
    scanf("%d%d", &x, &y);
    Vx[x].push_back(y);
    Vy[y].push_back(x);
  }
  for (int i = 0; i < N; ++i) {
    sort(Vx[i].begin(), Vx[i].end(), greater<int>());
    sort(Vy[i].begin(), Vy[i].end(), greater<int>());
  }
  for (int i = 0; i < N; ++i) {
    while (Vy[i].size()) {
      int x = Vy[i][Vy[i].size() - 1], y = i;
      if (Vy[y].size() > Vx[x].size()) {
        for (int j = 0; j < Vx[x].size() - 1; ++j) {
          int d = Vx[x][j] - y;
          if (check(x + d, y) && check(x + d, y + d)) ++ans;
        }
      } else {
        for (int j = 0; j < Vy[y].size() - 1; ++j) {
          int d = Vy[y][j] - x;
          if (check(x, y + d) && check(x + d, y + d)) ++ans;
        }
      }
      Vy[y].erase(Vy[y].end() - 1);
      Vx[x].erase(Vx[x].end() - 1);
    }
  }
  cout << ans << endl;
  return 0;
}
