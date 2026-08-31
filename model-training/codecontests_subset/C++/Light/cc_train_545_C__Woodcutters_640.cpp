#include <bits/stdc++.h>
using namespace std;
int main() {
  int x[1000001], h[1000001];
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  if (n == 1) {
    cout << 1;
    return 0;
  }
  int prev = x[0];
  int ans = 2;
  for (int i = 1; i < n - 1; i++) {
    if (prev < x[i] - h[i]) {
      ans++;
      prev = x[i];
    } else if (x[i] + h[i] < x[i + 1]) {
      ans++;
      prev = x[i] + h[i];
    } else {
      prev = x[i];
    }
  }
  cout << ans << endl;
  return 0;
}
