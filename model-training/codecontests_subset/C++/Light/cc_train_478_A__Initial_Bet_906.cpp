#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[6], i, sum = 0;
  for (i = 0; i < 5; i++) {
    scanf("%d", &arr[i]);
    sum = sum + arr[i];
  }
  if (sum == 0) {
    printf("-1\n");
  } else if (sum % 5 == 0) {
    printf("%d", sum / 5);
  } else {
    printf("-1");
  }
  return 0;
}
