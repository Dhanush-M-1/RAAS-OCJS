#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int mx = -99999;
  for (int i = 0; i < n - 1; i++) mx = max(mx, a[i] - a[i + 1] - k);
  if (mx < 0) mx = 0;
  printf("%d\n", mx);
  return 0;
}
