#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int l, r, d;
  cin >> l >> r >> d;
  if (d < l) {
    cout << d;
    return;
  }
  long long int x = r / d;
  x++;
  cout << x * d;
  return;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tc = 1;
  cin >> tc;
  while (tc--) {
    solve();
    cout << endl;
  }
  return 0;
}
