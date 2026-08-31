#include <bits/stdc++.h>
using namespace std;
long long A[2], B[2], C[2];
int check(long long p, long long q) {
  long long a, b, c;
  a = (-C[0] * p - C[1] * q);
  b = (-C[1] * p + C[0] * q);
  c = (C[0] * C[0] + C[1] * C[1]);
  return (a % c == 0 && b % c == 0);
}
int check2() {
  if (A[0] == B[0] && A[1] == B[1]) return 1;
  if ((-1 * A[1]) == B[0] && A[0] == B[1]) return 1;
  if ((-1 * A[0]) == B[0] && (-1 * A[1]) == B[1]) return 1;
  if (A[1] == B[0] && (-1 * A[0]) == B[1]) return 1;
  return 0;
}
int main(void) {
  int i, T, j, m, n;
  for (i = 0; i < 2; i++) scanf("%I64d", &A[i]);
  for (i = 0; i < 2; i++) scanf("%I64d", &B[i]);
  for (i = 0; i < 2; i++) scanf("%I64d", &C[i]);
  if (C[0] == 0 && C[1] == 0) {
    if (check2())
      printf("YES\n");
    else
      printf("NO\n");
  } else if (check(B[0] - A[0], B[1] - A[1]) ||
             check(B[0] - A[1], B[1] + A[0]) ||
             check(B[0] + A[0], B[1] + A[1]) || check(B[0] + A[1], B[1] - A[0]))
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
