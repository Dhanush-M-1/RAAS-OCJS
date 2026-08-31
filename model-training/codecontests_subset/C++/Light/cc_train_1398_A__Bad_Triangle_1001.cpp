#include <bits/stdc++.h>
using namespace std;
int a[50005];
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);
    if (a[0] + a[1] <= a[n - 1])
      printf("%d %d %d\n", 1, 2, n);
    else
      printf("-1\n");
  }
  return 0;
}
