#include <bits/stdc++.h>
using namespace std;
int a[100000][2];
int main() {
  int n, count = 1, val;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
  }
  for (int i = 1; i < n - 1; i++) {
    val = a[i][0] - a[i - 1][0];
    if (val > a[i][1]) {
      count++;
      continue;
    }
    val = a[i + 1][0] - a[i][0];
    if (val > a[i][1]) {
      count++;
      a[i][0] += a[i][1];
    }
  }
  if (n > 1) count++;
  cout << count;
  return 0;
}
