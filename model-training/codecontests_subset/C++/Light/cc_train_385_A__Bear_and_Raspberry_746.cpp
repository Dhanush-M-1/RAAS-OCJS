#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[101], an = 0, n, x;
  scanf("%d%d", &n, &x);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < n - 1; i++) an = max(a[i] - a[i + 1] - x, an);
  printf("%d\n", an);
  return 0;
}
