#include <bits/stdc++.h>
using namespace std;
int n, ans, sq = 335;
bool hv[100005];
map<int, bool> m[100005];
vector<int> v[100005], h;
bool ck(int x, int y, int dis) {
  return (m[x].count(y + dis) && m[x + dis].count(y) &&
          m[x + dis].count(y + dis));
}
bool Smallck(int x, int y, int dis) {
  return (m[x + dis].count(y) && m[x + dis].count(y + dis));
}
bool SmallCk(int x, int y, int dis) {
  return (m[x - dis].count(y) && m[x - dis].count(y + dis));
}
void BigBitch(int x) {
  for (int i = 0; i < h.size(); i++) {
    if (h[i] <= x) continue;
    for (int j = 0; j < v[x].size(); j++) {
      int poy = v[x][j];
      ans += ck(x, poy, h[i] - x);
    }
  }
}
void SmallBitch(int x) {
  for (int i = 0; i < v[x].size(); i++) {
    for (int j = i + 1; j < v[x].size(); j++) {
      int y1 = v[x][i], y2 = v[x][j];
      int dis = abs(y2 - y1);
      if (x + dis <= 1e5) ans += Smallck(x, min(y2, y1), dis);
      if (x >= dis) {
        if (hv[x - dis]) ans += SmallCk(x, min(y2, y1), dis);
      }
    }
  }
}
int main() {
  scanf("%d", &n);
  int x, y;
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &x, &y);
    v[x].push_back(y);
    m[x][y] = 1;
  }
  for (int i = 0; i <= 1e5; i++) {
    if (v[i].size() >= sq) {
      hv[i] = 1;
      h.push_back(i);
    }
  }
  for (int i = 0; i <= 1e5; i++) {
    if (hv[i])
      BigBitch(i);
    else
      SmallBitch(i);
  }
  printf("%d", ans);
}
