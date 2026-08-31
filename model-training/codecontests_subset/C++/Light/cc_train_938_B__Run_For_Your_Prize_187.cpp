#include <bits/stdc++.h>
using namespace std;
int a[200000];
int main(int argc, char const *argv[]) {
  int n;
  while (scanf("%d", &n) != EOF) {
    for (int i = 0; i < n; ++i) {
      scanf("%d", &a[i]);
    }
    int res = 1000000 - a[0];
    for (int i = 0; i < n; ++i) {
      int temp = a[i] - 1;
      if (i != n - 1) {
        temp = max(temp, 1000000 - a[i + 1]);
      }
      res = min(temp, res);
    }
    printf("%d\n", res);
  }
  return 0;
}
