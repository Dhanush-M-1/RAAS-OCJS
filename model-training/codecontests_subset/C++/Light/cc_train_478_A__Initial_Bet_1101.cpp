#include <bits/stdc++.h>
using namespace std;
int A[5];
int B[5];
int main() {
  for (int i = 0; i < 5; ++i) scanf("%d", &A[i]);
  if ((A[0] + A[1] + A[2] + A[3] + A[4]) % 5 != 0 ||
      (A[0] + A[1] + A[2] + A[3] + A[4]) == 0) {
    printf("-1");
    return 0;
  }
  int x = (A[0] + A[1] + A[2] + A[3] + A[4]) / 5;
  for (int i = 0; i < 5; ++i) B[i] = x - A[i];
  if (B[0] + B[1] + B[2] + B[3] + B[4] == 0) {
    printf("%d", x);
    return 0;
  } else {
    printf("-1");
    return 0;
  }
  return 0;
}
