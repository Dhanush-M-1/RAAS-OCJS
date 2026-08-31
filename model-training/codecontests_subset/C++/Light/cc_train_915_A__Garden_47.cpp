#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, l;
  scanf("%d", &n);
  scanf("%d", &l);
  int a[n];
  int ans = -1;
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a, a + n);
  for (int i = 0; i < n; i++) {
    if (l % a[i] == 0) ans = a[i];
  }
  ans = l / ans;
  printf("%d", ans);
}
