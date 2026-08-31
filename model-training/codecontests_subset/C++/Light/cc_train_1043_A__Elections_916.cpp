#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  int s = 0, a[n + 1], mx = INT_MIN;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    s += a[i];
    mx = max(mx, a[i]);
  }
  s *= 2;
  cout << max(mx, s / n + 1);
  return 0;
}
