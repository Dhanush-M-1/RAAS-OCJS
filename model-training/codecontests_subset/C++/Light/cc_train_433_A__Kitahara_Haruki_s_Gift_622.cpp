#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const long long INF = 1e18;
void solve() {
  int n, temp, n200 = 0, n100 = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    if (temp == 200)
      n200++;
    else
      n100++;
  }
  if (n200 % 2 == 0) {
    if (n100 % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  } else {
    if (n100 >= 2 && n100 % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int TC = 1, t = 0;
  while (t++ < TC) {
    solve();
    cout << "\n";
  }
  cerr << "Time : " << 1000 * ((double)clock()) / (double)CLOCKS_PER_SEC
       << "ms\n";
  return 0;
}
