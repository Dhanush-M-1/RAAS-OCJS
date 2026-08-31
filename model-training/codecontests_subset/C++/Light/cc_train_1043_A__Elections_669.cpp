#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int max = 0;
  int sum = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] > max) max = a[i];
    sum += a[i];
  }
  int ans = max;
  while ((ans * n) - (2 * sum) <= 0) {
    ans++;
  }
  cout << ans;
  return 0;
}
