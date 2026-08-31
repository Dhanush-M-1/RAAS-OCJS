#include <bits/stdc++.h>
using namespace std;
const int N = 5e4 + 5;
long long a[N];
void solve() {
  long long n, i;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i];
  long long x, y, z;
  x = a[0];
  y = a[1];
  z = a[n - 1];
  if (x + y <= z) {
    cout << "1 2 " << n << '\n';
    return;
  }
  cout << "-1\n";
}
int main() {
  int t;
  cin >> t;
  while (t--) solve();
}
