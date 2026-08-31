#include <bits/stdc++.h>
using namespace std;
const int MX = 100010;
const int oo = (1 << 31) - 1;
struct cell {
  int x, y;
  cell(int a, int b) {
    x = a;
    y = b;
  }
  bool operator<(const cell &arg) const {
    if (x == arg.x) return y < arg.y;
    return x < arg.x;
  }
  cell() { x = y = 0; }
} Cell[MX], way[8];
int dist[MX], nmap;
map<cell, int> mapa;
queue<int> cola;
int main() {
  way[0].x = 0, way[0].y = 1;
  way[1].x = 1, way[1].y = 0;
  way[2].x = 0, way[2].y = -1;
  way[3].x = -1, way[3].y = 0;
  way[4].x = 1, way[4].y = 1;
  way[5].x = -1, way[5].y = -1;
  way[6].x = 1, way[6].y = -1;
  way[7].x = -1, way[7].y = 1;
  int r, a, b, xo, yo, x1, y1, N;
  cell aux, next;
  scanf("%d %d %d %d", &xo, &yo, &x1, &y1);
  scanf("%d", &N);
  nmap = 0;
  for (int i = 0; i < N; i++) {
    scanf("%d %d %d", &r, &a, &b);
    for (int j = a; j <= b; j++) {
      aux = cell(r, j);
      if (mapa.find(aux) == mapa.end()) {
        mapa[aux] = nmap;
        Cell[nmap] = aux;
        dist[nmap] = oo;
        nmap++;
      }
    }
  }
  dist[mapa[cell(xo, yo)]] = 0;
  cola.push(mapa[cell(xo, yo)]);
  int ia, in;
  while (!cola.empty()) {
    ia = cola.front();
    aux = Cell[ia];
    cola.pop();
    for (int i = 0; i < 8; i++) {
      next.x = aux.x + way[i].x;
      next.y = aux.y + way[i].y;
      if (mapa.find(next) != mapa.end()) {
        in = mapa[next];
        if (dist[in] > dist[ia] + 1) {
          dist[in] = dist[ia] + 1;
          cola.push(in);
        }
      }
    }
  }
  r = mapa[cell(x1, y1)];
  if (dist[r] == oo)
    printf("-1\n");
  else
    printf("%d\n", dist[r]);
  return 0;
}
