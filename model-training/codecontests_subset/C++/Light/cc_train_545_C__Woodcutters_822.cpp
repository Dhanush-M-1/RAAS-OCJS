#include <bits/stdc++.h>
using namespace std;
const int MAX = -1e6 - 500;
long long n, x[100005], h[100005], h_new[100005];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  for (int i = 0; i < n - 1; i++) {
    h_new[i] = x[i + 1] - x[i] - 1;
  }
  int ans = 2;
  if (n < 2) {
    cout << n;
    return 0;
  }
  h[0] = 0;
  for (int i = 1; i < n - 1; i++) {
    if (h_new[i - 1] >= h[i]) {
      ans++;
      h[i] = 0;
    } else if (h_new[i] >= h[i]) {
      h_new[i] -= h[i];
      h[i] = 0;
      ans++;
    }
  }
  cout << ans;
  return 0;
}
