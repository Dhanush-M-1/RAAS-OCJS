#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n;
  scanf("%d", &n);
  int s1 = 0, s2 = 0, s3 = 0;
  int* arr = new int[n];
  int* arr2 = new int[n - 1];
  int* arr3 = new int[n - 2];
  for (i = 0; i < n; i++) {
    scanf("%d", &arr[i]);
    s1 += arr[i];
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &arr2[i]);
    s2 += arr2[i];
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &arr3[i]);
    s3 += arr3[i];
  }
  printf("%d\n", s1 - s2);
  printf("%d\n", s2 - s3);
}
