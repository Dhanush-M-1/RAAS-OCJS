#include <bits/stdc++.h>
int main() {
  int n, i, count = 0, j;
  scanf("%d", &n);
  int arr[n][2];
  for (i = 0; i < n; i++) {
    scanf("%d %d", &arr[i][0], &arr[i][1]);
  }
  for (i = 0; i < n; i++) {
    for (j = i + 1; j < n; j++) {
      if (arr[i][0] == arr[j][1]) count++;
      if (arr[i][1] == arr[j][0]) count++;
    }
  }
  printf("%d", count);
}
