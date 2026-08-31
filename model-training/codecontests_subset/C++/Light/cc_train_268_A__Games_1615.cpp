#include <bits/stdc++.h>
int solve(int n, int i, int home, int arr1[], int count) {
  for (int j = 0; j < n; j++) {
    if (j == i) {
      continue;
    }
    if (home == arr1[j]) {
      count++;
    }
  }
  return count;
}
int main() {
  int n, count = 0, home;
  scanf("%d", &n);
  int arr[n], arr1[n];
  for (int i = 0; i < n; i++) {
    scanf("%d %d\n", &arr[i], &arr1[i]);
  }
  for (int i = 0; i < n; i++) {
    home = arr[i];
    count = solve(n, i, home, arr1, count);
  }
  printf("%d", count);
  return 0;
}
