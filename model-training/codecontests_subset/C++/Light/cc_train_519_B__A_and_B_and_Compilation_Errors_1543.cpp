#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, sum1 = 0, sum2 = 0, sum3 = 0;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (i = 0; i < n; i++) {
    cin >> a[i];
    sum1 += a[i];
  }
  cout << endl;
  for (i = 0; i < n - 1; i++) {
    cin >> b[i];
    sum2 += b[i];
  }
  cout << endl;
  for (i = 0; i < n - 2; i++) {
    cin >> c[i];
    sum3 += c[i];
  }
  cout << endl;
  cout << sum1 - sum2 << endl;
  cout << sum2 - sum3 << endl;
  return 0;
}
