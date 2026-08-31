#include <bits/stdc++.h>
using namespace std;
const long long MAX = 123456789;
const long long inf = 123456789000000000;
const double EPS = 1e-10;
const double PI = 2 * asin(1.0);
const long long mod = 1e9 + 7;
inline int cmp(double x, double y = 0, double tol = EPS) {
  return (x <= y + tol) ? (x + tol < y) ? -1 : 0 : 1;
}
map<pair<int, int>, int> mapa;
int menor;
int mx[8] = {-1, -1, -1, 0, 0, 1, 1, 1}, my[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
bool inside(int x, int y) {
  return ((x >= 1 && x <= 1e9) && (y >= 1 && y <= 1e9));
}
void bfs(int x0, int y0, int x, int y) {
  queue<pair<pair<int, int>, int> > fila;
  fila.push(make_pair(pair<int, int>(x0, y0), 0));
  mapa[make_pair(x0, y0)] = 0;
  bool achou = false;
  while (!fila.empty()) {
    int a = fila.front().first.first;
    int b = fila.front().first.second;
    int dist = fila.front().second;
    fila.pop();
    for (int i = 0; i < 8; i++) {
      if (inside(a + mx[i], b + my[i])) {
        if (mapa.find(make_pair(a + mx[i], b + my[i])) != mapa.end()) {
          if (mapa[make_pair(a + mx[i], b + my[i])] == 1) {
            if (a + mx[i] == x && b + my[i] == y) {
              menor = dist + 1;
              achou = true;
              break;
            }
            fila.push(make_pair(make_pair(a + mx[i], b + my[i]), dist + 1));
            mapa[make_pair(a + mx[i], b + my[i])] = 0;
          }
        }
      }
    }
    if (achou) break;
  }
}
int main() {
  int x0, y0;
  scanf("%d%d", &x0, &y0);
  int x, y;
  scanf("%d%d", &x, &y);
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    int r;
    scanf("%d", &r);
    int a, b;
    scanf("%d%d", &a, &b);
    for (int j = a; j < b + 1; ++j) mapa[pair<int, int>(r, j)] = 1;
  }
  menor = -1;
  bfs(x0, y0, x, y);
  cout << menor << endl;
}
