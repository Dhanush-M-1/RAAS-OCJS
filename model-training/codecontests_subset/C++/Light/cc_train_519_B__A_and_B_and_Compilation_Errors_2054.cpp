#include <bits/stdc++.h>
using namespace std;
const int M = 1e5 + 10;
int a[M];
int b[M];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < n - 1; i++) scanf("%d", &b[i]);
  sort(a, a + n);
  sort(b, b + n - 1);
  int i;
  for (i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) break;
  }
  printf("%d\n", a[i]);
  for (i = 0; i < n - 2; i++) scanf("%d", &a[i]);
  sort(a, a + n - 2);
  for (i = 0; i < n - 2; i++) {
    if (b[i] != a[i]) break;
  }
  printf("%d\n", b[i]);
}
