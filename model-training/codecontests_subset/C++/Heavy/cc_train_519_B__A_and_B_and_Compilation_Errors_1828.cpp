#include <bits/stdc++.h>
long long int arr[100002], arr2[100002];
int cmpfunc(const void* a, const void* b) { return (*(int*)a - *(int*)b); }
int main() {
  long long int n, i, x;
  scanf("%I64d", &n);
  for (i = 0; i < n; i++) scanf("%I64d", &arr[i]);
  for (i = 0; i < n - 1; i++) scanf("%I64d", &arr2[i]);
  qsort(arr, n, sizeof(long long int), cmpfunc);
  qsort(arr2, n - 1, sizeof(long long int), cmpfunc);
  x = 0;
  for (i = 0; i < n - 1; i++) {
    if (arr[i] != arr2[i]) {
      x = arr[i];
      break;
    }
  }
  if (x == 0) x = arr[n - 1];
  printf("%I64d\n", x);
  for (i = 0; i < n - 2; i++) scanf("%I64d", &arr[i]);
  qsort(arr, n - 2, sizeof(long long int), cmpfunc);
  x = 0;
  for (i = 0; i < n - 2; i++) {
    if (arr[i] != arr2[i]) {
      x = arr2[i];
      break;
    }
  }
  if (x == 0) x = arr2[n - 2];
  printf("%I64d\n", x);
  return 0;
}
