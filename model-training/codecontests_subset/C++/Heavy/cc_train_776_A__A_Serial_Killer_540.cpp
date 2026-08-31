#include <bits/stdc++.h>
using namespace std;
int n, m, x, y, z, k, w;
char A[15], B[15], C[15], D[15];
int check(char *A, char *B) {
  int x = strlen(A);
  int y = strlen(B);
  if (x != y) return 0;
  for (int i = (0); i < (x); i++)
    if (A[i] != B[i]) return 0;
  return 1;
}
void assign(char *A, char *B) {
  int x = strlen(B);
  for (int i = (0); i < (x); i++) A[i] = B[i];
}
int main() {
  scanf("%s %s", &A, &B);
  scanf("%d", &n);
  printf("%s %s\n", A, B);
  while (n--) {
    scanf("%s %s", &C, &D);
    if (check(A, C) == 1) {
      memset(A, 0, sizeof(A));
      assign(A, D);
    } else {
      memset(B, 0, sizeof(B));
      assign(B, D);
    }
    printf("%s %s\n", A, B);
  }
  return 0;
}
