#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, d;
  cin >> n >> d;
  int a[100101];
  for (int i = 0; i < n; i++) cin >> a[i];
  long long sum = 0;
  bool ok = true;
  for (int i = 0; i < n; i++) {
    sum += a[i];
    if (a[i] == 0) {
      if (sum < 0) sum = 0;
    }
    if (sum > d) ok = false;
  }
  if (!ok) {
    cout << -1;
    return 0;
  }
  int ans = 0;
  sum = 0;
  for (int i = 0; i < n; i++) {
    sum += a[i];
    if (sum > d) sum = d;
    if (a[i] == 0) {
      if (sum < 0) {
        sum = d;
        ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
