#include <bits/stdc++.h>
using namespace std;
int GCD(int a, int b) {
  while (b) b ^= a ^= b ^= a %= b;
  return a;
}
void solve() {
  int n;
  int sum = 0, mx = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    sum += a;
    mx = max(mx, a);
  }
  int total = sum * 2 + 1;
  int av = total / n;
  int ans = max(av, mx);
  if (((ans * n) - sum) <= sum) ans++;
  cout << ans << endl;
  return;
}
int main() {
  int tst = 1;
  while (tst--) solve();
  return 0;
}
