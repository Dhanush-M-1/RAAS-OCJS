#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q, t, x, y;
int A[200005], B[200005];
int C[200005];
void insert1(int x, int y) {
  for (int i = x; i <= 200000; i += (i & (-i))) B[i] += y;
}
void insert2(int x, int y) {
  for (int i = x; i <= 200000; i += (i & (-i))) A[i] += y;
}
int q1(int x) {
  int tmp = 0;
  for (int i = x; i > 0; i -= (i & (-i))) tmp += B[i];
  return tmp;
}
int q2(int x) {
  int tmp = 0;
  for (int i = x; i > 0; i -= (i & (-i))) tmp += A[i];
  return tmp;
}
int main() {
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int i = (0); i < (q); i++) {
    scanf("%d %d", &t, &x);
    if (t == 1) {
      if (t == 1) scanf("%d", &y);
      if (C[x] < b) insert1(x, min(y, b - C[x]));
      if (C[x] < a) insert2(x, min(y, a - C[x]));
      C[x] += y;
    } else {
      printf("%d\n", q1(x - 1) + q2(200000) - q2(x + k - 1));
    }
  }
  return 0;
}
