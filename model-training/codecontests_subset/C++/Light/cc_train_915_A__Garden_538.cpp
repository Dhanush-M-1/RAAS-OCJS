#include <bits/stdc++.h>
using namespace std;
int a[110];
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a + 1, a + n + 1);
  for (int i = n; i >= 1; i--) {
    if (k % a[i] == 0) {
      printf("%d\n", k / a[i]);
      break;
    }
  }
  return 0;
}
