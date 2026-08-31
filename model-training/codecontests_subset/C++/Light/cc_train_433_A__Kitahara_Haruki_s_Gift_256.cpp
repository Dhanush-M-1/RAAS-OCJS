#include <bits/stdc++.h>
using namespace std;
int high_bit_finder(long long int a) { return log2(a) + 1; }
void solve() {
  int n;
  cin >> n;
  int a[n];
  int c1 = 0, c2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100) {
      c1++;
    } else {
      c2++;
    }
  }
  long long int sum = 0;
  for (int i = 0; i < n; i++) sum += a[i];
  if (sum % 200 != 0) {
    cout << "NO" << '\n';
    return;
  }
  sum = sum / 2;
  for (int i = 0; i <= c2; i++) {
    if (200 * i <= sum && sum - 200 * i <= 100 * c1) {
      cout << "YES" << '\n';
      return;
    }
  }
  cout << "NO" << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
