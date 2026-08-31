#include <bits/stdc++.h>
int main() {
  int arr[10000], n, c;
  scanf("%d %d", &n, &c);
  for (int i = 0; i < n; i++) {
    scanf("%d", &arr[i]);
  }
  int max = -1;
  for (int i = 0; i < n - 1; i++) {
    if (arr[i] - arr[i + 1] - c > max) {
      max = arr[i] - arr[i + 1] - c;
    }
  }
  if (max == -1) max = 0;
  printf("%d\n", max);
  return 0;
}
