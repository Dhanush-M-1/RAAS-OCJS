#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, ans = 1;
  cin >> n;
  vector<int> x(n + 1, 0), h(n + 1, 0);
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  x[n] = INT_MAX;
  for (int i = 1; i < n; i++) {
    if (x[i] - x[i - 1] > h[i]) {
      ans++;
    } else if (x[i + 1] - x[i] > h[i]) {
      x[i] += h[i];
      ans++;
    }
  }
  cout << ans << endl;
}
