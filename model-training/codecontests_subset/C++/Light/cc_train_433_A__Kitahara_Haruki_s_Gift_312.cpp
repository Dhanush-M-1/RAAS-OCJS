#include <bits/stdc++.h>
using namespace std;
int i, ctr, j, n, k, l, m, d, ctr1, t, sum, num;
int main() {
  ctr1 = 0;
  ctr = 0;
  cin >> n;
  sum = 0;
  for (i = 0; i < n; i++) {
    cin >> t;
    if (t == 100)
      ctr++;
    else
      ctr1++;
  }
  if (ctr != 0) {
    if (ctr % 2 == 0)
      printf("YES\n");
    else
      printf("NO\n");
  } else {
    if (ctr1 % 2 != 0)
      printf("NO\n");
    else
      printf("YES\n");
  }
  return 0;
}
