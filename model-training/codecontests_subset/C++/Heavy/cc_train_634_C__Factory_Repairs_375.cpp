#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const int mof = 1000000007;
const int inf = 1000000010;
const long long llinf = 1000000007000000007;
const double pi = 3.14159265359;
int a[211111];
int a2[211111];
int t[211111];
int t2[211111];
int n, k, A, B, q;
int sum(int r) {
  int result = 0;
  for (; r >= 0; r = (r & (r + 1)) - 1) result += t[r];
  return result;
}
void inc(int i, int delta) {
  if (a[i] + delta > B) {
    delta = B - a[i];
    a[i] = B;
  } else {
    a[i] = a[i] + delta;
  }
  for (; i < n; i = (i | (i + 1))) t[i] += delta;
}
int sum(int l, int r) { return sum(r) - sum(l - 1); }
void init(int a[]) {
  for (unsigned i = 0; i < n; i++) inc(i, a[i]);
}
int sum2(int r) {
  int result = 0;
  for (; r >= 0; r = (r & (r + 1)) - 1) result += t2[r];
  return result;
}
void inc2(int i, int delta) {
  if (a2[i] + delta > A) {
    delta = A - a2[i];
    a2[i] = A;
  } else {
    a2[i] = a2[i] + delta;
  }
  for (; i < n; i = (i | (i + 1))) t2[i] += delta;
}
int sum2(int l, int r) { return sum2(r) - sum2(l - 1); }
void init2(int a[]) {
  for (unsigned i = 0; i < n; i++) inc2(i, a[i]);
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &A, &B, &q);
  while (q--) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int d, a;
      scanf("%d%d", &d, &a);
      inc(d - 1, a);
      inc2(d - 1, a);
    } else {
      int p;
      scanf("%d", &p);
      printf("%d\n", sum(0, p - 2) + sum2(p + k - 1, n - 1));
    }
  }
  return 0;
}
