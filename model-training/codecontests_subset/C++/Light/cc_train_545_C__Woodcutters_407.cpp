#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 2;
  cin >> n;
  int x[n + 10], h[n + 10];
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - x[i - 1] > h[i]) {
      ans++;
    } else if (x[i + 1] - x[i] > h[i]) {
      ans++;
      x[i] += h[i];
    }
  }
  cout << (n == 1 ? 1 : ans);
  return 0;
}
