#include <bits/stdc++.h>
using namespace std;
const int maxn = 200;
int a[maxn];
int main() {
  int n, c;
  while (scanf("%d%d", &n, &c) != EOF) {
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);
    int res = -1;
    for (int i = 0; i < n - 1; i++) {
      int tmp = a[i] - a[i + 1];
      res = max(res, tmp);
    }
    res -= c;
    if (res < 0)
      puts("0");
    else
      printf("%d\n", res);
  }
  return 0;
}
