#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  for (int i = 0; i < t; i++) {
    int n;
    scanf("%d", &n);
    vector<int> a(n);
    for (int j = 0; j < n; j++) scanf("%d", &a[j]);
    if (a[0] + a[1] <= a[n - 1])
      printf("%d %d %d\n", 1, 2, n);
    else
      printf("-1\n");
  }
  return 0;
}
