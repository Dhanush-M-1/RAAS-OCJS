#include <bits/stdc++.h>
using namespace std;
long long int div_floor(const long long int &a, const long long int &b) {
  return a / b - (((a ^ b) < 0) and a % b);
}
long long int div_ceil(const long long int &a, const long long int &b) {
  return a / b + (((a ^ b) >= 0) and a % b);
}
void solve() {
  int n;
  cin >> n;
  vector<string> s(n);
  for (int i = 0; i < n; i++) cin >> s[i];
  int ctr1 = (s[0][1] == '1') + (s[1][0] == '1') + (s[n - 1][n - 2] == '0') +
             (s[n - 2][n - 1] == '0');
  int ctr2 = (s[0][1] == '0') + (s[1][0] == '0') + (s[n - 1][n - 2] == '1') +
             (s[n - 2][n - 1] == '1');
  if (ctr1 >= 2) {
    cout << 4 - ctr1 << '\n';
    if (s[0][1] != '1') cout << 1 << " " << 2 << '\n';
    if (s[1][0] != '1') cout << 2 << " " << 1 << '\n';
    if (s[n - 1][n - 2] != '0') cout << n << " " << n - 1 << '\n';
    if (s[n - 2][n - 1] != '0') cout << n - 1 << " " << n << '\n';
    return;
  }
  if (ctr2 >= 2) {
    cout << 4 - ctr2 << '\n';
    if (s[0][1] != '0') cout << 1 << " " << 2 << '\n';
    if (s[1][0] != '0') cout << 2 << " " << 1 << '\n';
    if (s[n - 1][n - 2] != '1') cout << n << " " << n - 1 << '\n';
    if (s[n - 2][n - 1] != '1') cout << n - 1 << " " << n << '\n';
    return;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  cin >> t;
  while (t--) solve();
}
