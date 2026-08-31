#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n], b[n - 1], c[n - 2], sum1 = 0, sum2 = 0, sum3 = 0;
  for (int i = 0; i < n; i++) cin >> a[i], sum1 += a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i], sum2 += b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i], sum3 += c[i];
  cout << sum1 - sum2 << "\n" << sum2 - sum3 << "\n";
  return 0;
}
