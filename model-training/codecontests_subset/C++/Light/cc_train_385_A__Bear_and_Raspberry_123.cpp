#include <bits/stdc++.h>
using namespace std;
int a[500], c, i, n, big;
int main() {
  while (~scanf(" %d %d", &n, &c)) {
    for (i = 0; i < n; i++) {
      scanf(" %d", &a[i]);
    }
    big = 0;
    for (i = 0; i < n - 1; i++) {
      if (a[i] - a[i + 1] - c > big) big = a[i] - a[i + 1] - c;
    }
    printf("%d\n", big);
  }
  return 0;
}
