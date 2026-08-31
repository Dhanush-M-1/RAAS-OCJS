#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5;
const long long mak = 1e9 + 5;
map<long long, int> mapas;
vector<int> grafas[maxn];
int visited[maxn] = {};
int X[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int Y[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long x1, y1, x2, y2;
  cin >> y1 >> x1 >> y2 >> x2;
  int n;
  cin >> n;
  mapas[x1 * mak + y1] = 1;
  if (mapas[x2 * mak + y2] == 0) mapas[x2 * mak + y2] = 2;
  if (abs(x1 - x2) <= 1 && abs(y1 - y2) <= 1) {
    grafas[1].push_back(2);
    grafas[2].push_back(1);
  }
  for (int i = 0; i < n; ++i) {
    long long r, a, b;
    cin >> r >> a >> b;
    for (long long x = a; x <= b; ++x) {
      if (mapas[x * mak + r] == 0) {
        mapas[x * mak + r] = mapas.size();
        for (int c = 0; c < 8; ++c) {
          int is = mapas[x * mak + r];
          int dbr = mapas[(x + X[c]) * mak + r + Y[c]];
          if (dbr != 0) {
            grafas[dbr].push_back(is);
            grafas[is].push_back(dbr);
          } else
            mapas.erase((x + X[c]) * mak + r + Y[c]);
        }
      }
    }
  }
  deque<int> dekas;
  dekas.push_back(1);
  visited[1] = 1;
  while (dekas.size()) {
    int dbr = dekas.front();
    int kada = visited[dbr] + 1;
    dekas.pop_front();
    if (dbr == 2) {
      cout << kada - 2;
      return 0;
    }
    for (int v : grafas[dbr]) {
      if (visited[v] == 0) {
        visited[v] = kada;
        dekas.push_back(v);
      }
    }
  }
  cout << -1;
  return 0;
}
