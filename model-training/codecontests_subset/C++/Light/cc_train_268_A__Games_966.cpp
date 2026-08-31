#include <bits/stdc++.h>
int main() {
  int n, i, a = 0;
  scanf("%d", &n);
  int arr[n][2];
  for (i = 0; i < n; i++) {
    scanf("%d %d", &arr[i][0], &arr[i][1]);
  }
  for (i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      if (arr[i][0] == arr[j][1]) {
        a++;
      }
      if (arr[i][1] == arr[j][0]) {
        a++;
      }
    }
  }
  printf("%d", a);
  return 0;
}
