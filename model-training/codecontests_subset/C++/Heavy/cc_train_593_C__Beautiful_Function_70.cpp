#include <bits/stdc++.h>
using namespace std;
const int oo = 0x3f3f3f3f;
int n;
void print(int second, int down) {
  bool neg = (second < 0);
  if (neg) {
    printf("((0-%d)*", -second);
  } else
    printf("(%d*", second);
  printf("((t-%d)+abs((t-%d))))", down, down);
}
void proc(int *a) {
  if (n == 1) {
    printf("%d\n", a[0]);
    return;
  }
  printf("(%d+", a[0]);
  int ly = a[0], der = 0;
  for (int(i) = (1); (i) < (n); ++(i)) {
    int ny = a[i];
    int second = (ny - (ly + der)) / 2;
    if (i == n - 1) {
      print(second, i - 1);
    } else {
      printf("(");
      print(second, i - 1);
      printf("+");
    }
    der += second + second;
    ly += der;
  }
  for (int(i) = (0); (i) < (n - 2); ++(i)) printf(")");
  puts(")");
}
pair<int, int> a[59];
int x[59], y[59];
int main() {
  while (scanf("%d", &n) == 1) {
    for (int(i) = (0); (i) < (n); ++(i)) {
      int x, y, r;
      scanf("%d%d%d", &x, &y, &r);
      a[i] = pair<int, int>(x, y);
    }
    for (int(i) = (0); (i) < (n); ++(i)) {
      x[i] = a[i].first;
      y[i] = a[i].second;
    }
    proc(x);
    proc(y);
  }
  return 0;
}
