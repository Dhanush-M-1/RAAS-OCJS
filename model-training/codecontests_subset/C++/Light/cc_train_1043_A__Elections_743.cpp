#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[110], k, sum = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    sum += a[i];
  }
  sort(a, a + n);
  for (k = a[n - 1];; k++) {
    if (k * n > 2 * sum) break;
  }
  printf("%d\n", k);
  return 0;
}
