#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[30];
  int b[30];
  printf("? %d %d\n", 0, 0);
  fflush(stdout);
  int x;
  cin >> x;
  long long int p = pow(2, 29);
  long long int q = 0;
  long long int c = 0;
  long long int d = 0;
  for (int i = 0; i < 30; i++) {
    c = c + p;
    d = d + q;
    printf("? %lld %lld\n", c, d);
    fflush(stdout);
    int y;
    cin >> y;
    c = c - p + q;
    d = d - q + p;
    printf("? %lld %lld\n", c, d);
    fflush(stdout);
    int z;
    cin >> z;
    c = c - q + p;
    d = d - p + q;
    if (y == -1 && z == 1) {
      a[i] = 1;
      b[i] = 1;
    } else if (y == 1 && z == -1) {
      a[i] = 0;
      b[i] = 0;
    } else if (y == z) {
      if (x == 1) {
        a[i] = 1;
        b[i] = 0;
        if (y == 1)
          x = 1;
        else if (y == -1)
          x = -1;
      } else if (x == -1) {
        a[i] = 0;
        b[i] = 1;
        if (y == 1)
          x = 1;
        else if (y == -1)
          x = -1;
      }
    }
    if (a[i] == 0) c = c - p;
    if (b[i] == 0)
      d = d - q;
    else if (b[i] == 1)
      d = d + p;
    p = p / 2;
  }
  long long int u = 0;
  long long int t = 1;
  for (int i = 29; i >= 0; i--) {
    u = u + a[i] * t;
    t = t * 2;
  }
  long long int v = 0;
  t = 1;
  for (int i = 29; i >= 0; i--) {
    v = v + b[i] * t;
    t = t * 2;
  }
  printf("! %lld %lld\n", u, v);
  fflush(stdout);
  return 0;
}
