#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  scanf("%d%d", &n, &c);
  int a[n], b[n - 1];
  scanf("%d", &a[0]);
  for (int i = 1; i < n; i++) {
    scanf("%d", &a[i]);
    b[i - 1] = a[i - 1] - a[i] - c;
  }
  int max = 0;
  for (int i = 0; i < n - 1; i++) {
    if (b[i] > max) max = b[i];
  }
  printf("%d\n", max);
  return 0;
}
