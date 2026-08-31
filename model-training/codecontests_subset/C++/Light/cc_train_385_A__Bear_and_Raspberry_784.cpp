#include <bits/stdc++.h>
int binarySearch(int arr[], int l, int r, int x) {
  if (r >= l) {
    int mid = l + (r - l) / 2;
    if (arr[mid] == x) return mid;
    if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
    return binarySearch(arr, mid + 1, r, x);
  }
  return -1;
}
int cmpi(const void *a, const void *b) {
  return ((const int *)a)[0] - ((const int *)b)[0];
}
int cmp(const void *a, const void *b) { return *(int *)a - *(int *)b; }
int max(int a, int b) {
  if (a >= b)
    return a;
  else
    return b;
}
int main() {
  int n, c, b[1000001], tmp = 0;
  scanf("%d %d", &n, &c);
  for (int i = 0; i < n; i++) scanf("%d", &b[i]);
  for (int i = 0; i < n - 1; i++) {
    tmp = max(b[i] - b[i + 1] - c, tmp);
  }
  printf("%d\n", tmp);
  return 0;
}
