#include <bits/stdc++.h>
using namespace std;
int n, tot = 0;
map<int, int> x[200000], y[200000];
bool exists(int xx, int yy) { return x[xx].find(yy) != x[xx].end(); }
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    x[a][b] = 1;
    y[b][a] = 1;
  }
  for (int i = 0; i < 200000; i++) {
    map<int, int>::iterator it;
    int moo = 1;
    for (it = x[i].begin(); it != x[i].end(); it++) {
      it->second = moo++;
    }
    moo = 1;
    for (it = y[i].begin(); it != y[i].end(); it++) {
      it->second = moo++;
    }
  }
  for (int i = 0; i < 200000; i++) {
    if (x[i].empty()) continue;
    int xx = i;
    map<int, int>::iterator it, it2;
    for (it = x[i].begin(); it != x[i].end(); it++) {
      int yy = it->first;
      int cx = (int)x[xx].size() - it->second;
      int cy = (int)y[yy].size() - y[yy][xx];
      if (cx < cy) {
        for (it2 = x[xx].upper_bound(yy); it2 != x[xx].end(); it2++) {
          int yy2 = it2->first;
          if (exists(xx + yy2 - yy, yy) && exists(xx + yy2 - yy, yy2)) {
            tot++;
          }
        }
      } else {
        for (it2 = y[yy].upper_bound(xx); it2 != y[yy].end(); it2++) {
          int xx2 = it2->first;
          if (exists(xx, yy + xx2 - xx) && exists(xx2, yy + xx2 - xx)) {
            tot++;
          }
        }
      }
    }
  }
  printf("%d\n", tot);
}
