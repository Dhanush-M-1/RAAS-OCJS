#include <bits/stdc++.h>
using namespace std;
const int MAXN = 501011;
int a[MAXN];
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    if (a[1] + a[2] > a[n])
      printf("-1\n");
    else
      printf("1 2 %d\n", n);
  }
  return 0;
}
