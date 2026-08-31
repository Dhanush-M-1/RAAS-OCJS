#include <bits/stdc++.h>
void merge(long long int *a, int L, int R) {
  int M = (L + R) / 2;
  int i = L, j = M + 1, k = 0;
  int temp[R - L + 1];
  while (i <= M && j <= R) {
    if (a[i] <= a[j]) {
      temp[k] = a[i];
      ++i;
    } else {
      temp[k] = a[j];
      ++j;
    }
    ++k;
  }
  while (i <= M) {
    temp[k] = a[i];
    ++i;
    ++k;
  }
  while (j <= R) {
    temp[k] = a[j];
    ++j;
    ++k;
  }
  for (int i = 0; i < k; ++i) {
    a[L + i] = temp[i];
  }
}
void mergeSort(long long int *a, int L, int R) {
  if (L == R) {
    return;
  } else {
    int M = (L + R) / 2;
    mergeSort(a, L, M);
    mergeSort(a, M + 1, R);
    merge(a, L, R);
  }
}
int main() {
  long long int n;
  scanf("%lld", &n);
  long long int input1[n], input2[n - 1], input3[n - 2];
  for (int i = 0; i < n; i++) scanf("%lld", &input1[i]);
  for (int i = 0; i < n - 1; i++) scanf("%lld", &input2[i]);
  for (int i = 0; i < n - 2; i++) scanf("%lld", &input3[i]);
  mergeSort(input1, 0, n - 1);
  mergeSort(input2, 0, n - 2);
  mergeSort(input3, 0, n - 3);
  for (int i = 0; i < n; i++) {
    if (input1[i] != input2[i]) {
      printf("%lld\n", input1[i]);
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (input2[i] != input3[i]) {
      printf("%lld\n", input2[i]);
      break;
    }
  }
  return 0;
}
