#include <bits/stdc++.h>
using namespace std;
int x[100005], h[100005];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  int ans = 0;
  int last = -1e9 - 5;
  for (int i = 0; i < n - 1; i++) {
    if (x[i] - h[i] > last) {
      ans++;
      last = x[i];
    } else if (x[i] + h[i] < x[i + 1]) {
      ans++;
      last = x[i] + h[i];
    } else
      last = x[i];
  }
  if (x[n - 1] > last) ans++;
  cout << ans;
}
