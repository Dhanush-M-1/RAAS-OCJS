#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int sum = 0, sum1 = 0, sum2 = 0;
  int a[n], b[n], c[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    sum1 += b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    sum2 += c[i];
  }
  cout << sum - sum1 << endl;
  cout << sum1 - sum2 << endl;
}
