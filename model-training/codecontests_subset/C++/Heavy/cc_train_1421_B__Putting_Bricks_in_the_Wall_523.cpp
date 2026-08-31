#include <bits/stdc++.h>
using namespace std;
bool isrange(int second, int first, int n, int m) {
  if (0 <= second && second < n && 0 <= first && first < m) return true;
  return false;
}
int dy[4] = {1, 0, -1, 0}, dx[4] = {0, 1, 0, -1},
    ddy[8] = {1, 0, -1, 0, 1, 1, -1, -1}, ddx[8] = {0, 1, 0, -1, 1, -1, 1, -1};
string a[222];
int dp[222][222], n;
bool can(int second, int first) {
  if (second == n - 1 && first == n - 1) return true;
  dp[second][first] = 1;
  for (int e = 0; e < 4; e++) {
    int ny = second + dy[e];
    int nx = first + dx[e];
    if (isrange(ny, nx, n, n) && dp[ny][nx] == 0) {
      if (a[ny][nx] == 'F' || a[ny][nx] == a[second][first]) {
        if (can(ny, nx)) return true;
      }
    }
  }
  return false;
}
void init() {
  for (int e = 0; e < n; e++)
    for (int p = 0; p < n; p++) dp[e][p] = 0;
  dp[0][0] = 1;
}
bool isit() {
  init();
  bool suc1 = can(0, 1);
  init();
  bool suc2 = can(1, 0);
  if (!suc1 && !suc2) return false;
  return true;
}
void inverse(int second, int first) {
  if (a[second][first] == '0')
    a[second][first] = '1';
  else
    a[second][first] = '0';
}
vector<pair<int, int> > vv;
int main(void) {
  int t;
  scanf("%d", &t);
  while (t--) {
    scanf("%d", &n);
    vv.clear();
    vv.push_back(make_pair(0, 1));
    vv.push_back(make_pair(1, 0));
    vv.push_back(make_pair(1, 1));
    vv.push_back(make_pair(n - 2, n - 1));
    vv.push_back(make_pair(n - 1, n - 2));
    if (n != 3) vv.push_back(make_pair(n - 2, n - 2));
    for (int e = 0; e < n; e++) cin >> a[e];
    bool suc = false;
    if (!isit()) {
      printf("0\n");
      suc = true;
    }
    if (!suc) {
      for (int e = 0; e < (int)vv.size(); e++) {
        inverse(vv[e].first, vv[e].second);
        if (!isit()) {
          printf("1\n%d %d\n", vv[e].first + 1, vv[e].second + 1);
          suc = true;
          break;
        }
        inverse(vv[e].first, vv[e].second);
      }
    }
    if (!suc) {
      for (int e = 0; e < (int)vv.size(); e++) {
        for (int p = e + 1; p < (int)vv.size(); p++) {
          inverse(vv[e].first, vv[e].second);
          inverse(vv[p].first, vv[p].second);
          if (!isit()) {
            printf("2\n");
            printf("%d %d\n", vv[e].first + 1, vv[e].second + 1);
            printf("%d %d\n", vv[p].first + 1, vv[p].second + 1);
            suc = true;
            break;
          }
          inverse(vv[e].first, vv[e].second);
          inverse(vv[p].first, vv[p].second);
        }
        if (suc) break;
      }
    }
  }
  return 0;
}
