#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  int n, x, y, p;
  scanf("%d", &n), scanf("%d", &x), scanf("%d", &y);
  int perc;
  perc = ((y * n) / 100);
  if ((perc * 100) < (y * n)) perc++;
  p = perc - x;
  if (p <= 0) {
    printf("%d\n", 0);
  } else {
    printf("%d\n", p);
  }
  return 0;
}
