#include <bits/stdc++.h>
void sort(int arr[], int n) {
  int temp = 0;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j <= n - i; j++) {
      if (arr[j] > arr[j + 1]) {
        temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
}
int main() {
  char string[202];
  scanf("%s", string);
  int arr[202] = {0};
  int n = 1;
  int batas = strlen(string);
  for (int i = 0; i < batas; i++) {
    if (string[i] >= 48 && string[i] <= 57) {
      arr[n] = (string[i] - '0');
      n++;
    }
  }
  sort(arr, n - 1);
  for (int i = 1; i < n; i++) {
    if (i == n - 1) {
      printf("%d\n", arr[i]);
    } else {
      printf("%d+", arr[i]);
    }
  }
  return 0;
}
