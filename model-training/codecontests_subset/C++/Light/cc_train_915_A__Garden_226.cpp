#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, k;
  scanf("%d %d", &n, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a + 1, a + 1 + n);
  for (int i = n; i >= 1; i--) {
    if (k % a[i] == 0) {
      printf("%d\n", k / a[i]);
      return 0;
    }
  }
  return 0;
}
