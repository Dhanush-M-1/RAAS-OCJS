#include <bits/stdc++.h>
using namespace std;
int main() {
  int sum = 0, n, k, max = 0;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    if (a[i] > max) max = a[i];
  }
  k = max;
  while ((k * n) <= (2 * sum)) k++;
  cout << k;
  return 0;
}
