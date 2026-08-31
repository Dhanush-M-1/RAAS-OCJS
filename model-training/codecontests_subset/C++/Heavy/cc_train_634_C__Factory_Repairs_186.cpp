#include <bits/stdc++.h>
using namespace std;
int A[2010000], L[2010000], R[2010000];
int n, m, x, y, q;
void addL(int a, int b) {
  for (int i = a; i <= n; i += ((i) & (-i))) L[i] += b;
}
void addR(int a, int b) {
  for (int i = n - a + 1; i <= n; i += ((i) & (-i))) R[i] += b;
}
int getL(int a) {
  int ans = 0;
  for (; a > 0; a -= ((a) & (-a))) ans += L[a];
  return ans;
}
int getR(int a) {
  int ans = 0;
  for (a = n - a + 1; a > 0; a -= ((a) & (-a))) ans += R[a];
  return ans;
}
int main() {
  scanf("%d %d %d %d %d", &n, &m, &y, &x, &q);
  for (; q; q--) {
    int ch;
    scanf("%d", &ch);
    if (ch == 1) {
      int a, b;
      scanf("%d %d", &b, &a);
      int pas = A[b];
      A[b] += a;
      addL(b, min(A[b], x) - min(pas, x));
      addR(b, min(A[b], y) - min(pas, y));
    } else {
      int a;
      scanf("%d", &a);
      int ans = 0;
      ans += getL(a - 1);
      ans += getR(a + m);
      printf("%d\n", ans);
    }
  }
  return 0;
}
