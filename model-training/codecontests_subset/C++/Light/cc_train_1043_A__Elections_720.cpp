#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k1, max = 0;
  cin >> n;
  int a[n];
  unsigned long long int sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum = sum + a[i];
    if (a[i] > max) max = a[i];
  }
  k1 = ((sum * 2) / n) + 1;
  if (k1 < max)
    cout << max << endl;
  else
    cout << k1 << endl;
  return 0;
}
