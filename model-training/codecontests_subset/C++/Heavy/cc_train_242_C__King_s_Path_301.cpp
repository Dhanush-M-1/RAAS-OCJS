#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x0, y0, x1, y1;
  map<pair<int, int>, int> cases;
  scanf("%d %d", &x0, &y0);
  scanf("%d %d", &x1, &y1);
  scanf("%d", &n);
  int r, a, b;
  for (int i = 0; i < n; i++) {
    scanf("%d %d %d", &r, &a, &b);
    for (int i = a; i < b + 1; i++) {
      cases[make_pair(r, i)] = 0;
    }
  }
  set<pair<int, int> > attente;
  attente.insert(make_pair(x0, y0));
  set<pair<int, int> >::iterator it;
  int x, y, res = 0;
  while (attente.size() > 0) {
    set<pair<int, int> > temp;
    for (it = attente.begin(); it != attente.end(); it++) {
      tie(x, y) = *it;
      cases[make_pair(x, y)] = 1;
      if (x == x1 && y == y1) {
        printf("%d\n", res);
        return 0;
      }
      int X[] = {-1, -1, -1, 0, 0, 1, 1, 1};
      int Y[] = {-1, 0, 1, -1, 1, -1, 0, 1};
      for (int i = 0; i < 8; i++) {
        if (cases.find(make_pair(x + X[i], y + Y[i])) != cases.end() &&
            cases[make_pair(x + X[i], y + Y[i])] == 0) {
          temp.insert(make_pair(x + X[i], y + Y[i]));
        }
      }
    }
    res++;
    attente = temp;
  }
  printf("%d\n", -1);
}
