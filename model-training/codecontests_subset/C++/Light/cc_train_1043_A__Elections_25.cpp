#include <bits/stdc++.h>
using namespace std;
int a[222];
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  int sum = 0;
  int ma = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    ma = max(ma, a[i]);
  }
  int ans = 0;
  for (int i = ma; i <= 300; i++) {
    if (i * n - sum > sum) {
      ans = i;
      break;
    }
  }
  cout << ans << endl;
  return 0;
}
