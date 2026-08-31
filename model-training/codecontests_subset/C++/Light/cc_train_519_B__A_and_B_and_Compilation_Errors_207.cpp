#include <bits/stdc++.h>
int n;
int arr[3];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < 3; i++) {
    for (int j = n - 1; j >= i; j--) {
      int num;
      scanf("%d", &num);
      arr[i] += num;
    }
  }
  printf("%d\n", arr[0] - arr[1]);
  printf("%d\n", arr[1] - arr[2]);
  return 0;
}
