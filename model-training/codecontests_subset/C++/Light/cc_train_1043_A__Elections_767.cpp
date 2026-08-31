#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s, i, j, r;
  cin >> n;
  int a[110];
  s = 0;
  int mx = 0;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    s += a[i];
    mx = max(mx, a[i]);
  }
  int cnt = 0;
  for (i = mx; i <= 300; i++) {
    cnt = 0;
    for (j = 0; j < n; j++) {
      cnt += (i - a[j]);
    }
    if (cnt > s) break;
  }
  printf("%d\n", i);
  return 0;
}
