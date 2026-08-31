#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, i;
  scanf("%d", &t);
  while (t--) {
    scanf("%d", &n);
    vector<int> a(n);
    for (i = 0; i < n; i++) scanf("%d", &a[i]);
    if (a[0] + a[1] <= a[n - 1])
      printf("1 2 %d\n", n);
    else
      printf("-1\n");
  }
  return 0;
}
