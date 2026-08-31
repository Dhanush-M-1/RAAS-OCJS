#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long inf = 922337203685477;
const long long mininf = -922337203685477;
const long long nax = 0;
long long t, l, r, d;
void solve() {
  cin >> l >> r >> d;
  long long mini = (l + d - 1) / d;
  long long maxi = r / d;
  if (mini <= 1) {
    cout << (maxi + 1) * d << '\n';
  } else {
    cout << d << '\n';
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> t;
  while (t--) {
    solve();
  }
}
