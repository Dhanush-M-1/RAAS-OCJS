#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, sum;
  cin >> n;
  int fill;
  int a[100000][2];
  for (i = 0; i < n; i++) {
    cin >> a[i][0];
    cin >> a[i][1];
  }
  if (n == 1) {
    cout << 1;
    return 0;
  }
  if (n == 2) {
    cout << 2;
    return 0;
  }
  sum = 0;
  fill = 0;
  for (i = 1; i < n - 1; i++) {
    if (a[i][1] < (a[i][0] - a[i - 1][0] - fill)) {
      sum++;
      fill = 0;
    } else {
      if (a[i][1] < (a[i + 1][0] - a[i][0])) {
        sum++;
        fill = a[i][1];
      } else {
        fill = 0;
      }
    }
  }
  sum += 2;
  cout << sum;
  return 0;
}
