#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int a[n][2], i;
  for (i = 0; i < n; i++) scanf("%d", &a[i][0]), scanf("%d", &a[i][1]);
  int cnt = 0;
  for (i = 1; i < n - 1; i++) {
    if (a[i][0] - a[i][1] > a[i - 1][0]) {
      cnt++;
      continue;
    }
    if (a[i][0] + a[i][1] < a[i + 1][0]) {
      cnt++;
      a[i][0] = a[i][0] + a[i][1];
      continue;
    }
  }
  if (n >= 2)
    cout << cnt + 2 << endl;
  else if (n == 1)
    cout << cnt + 1 << endl;
  else
    cout << cnt << endl;
  return 0;
}
