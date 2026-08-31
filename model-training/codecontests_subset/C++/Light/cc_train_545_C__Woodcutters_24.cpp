#include <bits/stdc++.h>
using namespace std;
int Max(int a, int b, int c) {
  cout << a << " " << b << " " << c << endl;
  return max(a, max(b, c));
}
int main() {
  int n;
  cin >> n;
  int x[n], h[n];
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  int ans = 1, pos = x[0];
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > pos) {
      ans++;
      pos = x[i];
      continue;
    }
    if (x[i] + h[i] < x[i + 1]) {
      ans++;
      pos = x[i] + h[i];
      continue;
    }
    pos = x[i];
  }
  if (n >= 2) ans++;
  cout << ans;
}
