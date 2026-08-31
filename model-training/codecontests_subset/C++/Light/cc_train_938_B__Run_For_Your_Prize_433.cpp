#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int a[n];
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  int mn = min(a[n - 1] - 1, 1000000 - a[0]);
  for (int i = 0; i < n - 1; i++) {
    mn = min(mn, max(a[i] - 1, 1000000 - a[i + 1]));
  }
  printf("%d\n", mn);
  return 0;
}
