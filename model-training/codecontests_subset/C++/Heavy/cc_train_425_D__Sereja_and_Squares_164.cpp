#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
const int INF = 1e9 + 7;
struct point {
  int x, y;
  point() {}
  point(int kx, int ky) {
    x = kx;
    y = ky;
  }
};
point mas[N];
vector<int> setX[N], setY[N];
map<pair<int, int>, bool> mp;
bool cmp(point a, point b) {
  if (a.x == b.x) return a.y < b.y;
  return a.x < b.x;
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int kx, ky;
    cin >> kx >> ky;
    mas[i] = point(kx, ky);
    setX[ky].push_back(kx);
    setY[kx].push_back(ky);
    mp[make_pair(kx, ky)] = 1;
  }
  sort(mas + 1, mas + n + 1, cmp);
  for (int i = 0; i <= 1e5; i++) {
    sort(setX[i].begin(), setX[i].end());
    sort(setY[i].begin(), setY[i].end());
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    int X = mas[i].x, Y = mas[i].y;
    if (setX[Y].size() <= setY[X].size()) {
      int pos = 0;
      while (pos < setX[Y].size() && setX[Y][pos] <= X) pos++;
      int posY = 0;
      while (posY < setY[X].size() && setY[X][posY] <= Y) posY++;
      if (pos < setX[Y].size() && posY < setY[X].size()) {
        for (int id = pos; id < setX[Y].size(); id++) {
          int z = setX[Y][id] - X;
          int t = posY;
          while (t < setY[X].size() - 1 && setY[X][t] - Y < z) t++;
          if (setY[X][t] - Y == z && mp[make_pair(setX[Y][id], setY[X][t])])
            ans++;
          posY = t;
        }
      }
    } else {
      int pos = 0;
      while (pos < setY[X].size() && setY[X][pos] <= Y) pos++;
      int posX = 0;
      while (posX < setX[Y].size() && setX[Y][posX] <= X) posX++;
      if (posX < setX[Y].size() && pos < setY[X].size()) {
        for (int id = pos; id < setY[X].size(); id++) {
          int z = setY[X][id] - Y;
          int t = posX;
          while (t < setX[Y].size() - 1 && setX[Y][t] - X < z) t++;
          if (setX[Y][t] - X == z && mp[make_pair(setX[Y][t], setY[X][id])])
            ans++;
          posX = t;
        }
      }
    }
  }
  cout << ans;
}
