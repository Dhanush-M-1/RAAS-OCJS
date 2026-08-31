#include <bits/stdc++.h>
using namespace std;
long long int mod(long long int x) {
  if (x >= 0)
    return x;
  else
    return -x;
}
int main() {
  long long int n;
  cin >> n;
  long long int a[n][2];
  for (long long int i = 0; i < n; ++i) {
    cin >> a[i][0] >> a[i][1];
  }
  if (n <= 2) {
    cout << n;
    return 0;
  }
  long long int count = 0, x = a[0][0];
  for (long long int i = 1; i < n - 1; ++i) {
    if (a[i][0] - a[i][1] > x) {
      x = a[i][0];
      count++;
      continue;
    }
    if (a[i][0] + a[i][1] < a[i + 1][0]) {
      x = a[i][0] + a[i][1];
      count++;
      continue;
    }
    x = a[i][0];
  }
  cout << count + 2;
  return 0;
}
