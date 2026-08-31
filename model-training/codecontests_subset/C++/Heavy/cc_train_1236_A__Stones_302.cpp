#include <bits/stdc++.h>
using namespace std;
const long long int INF = 1e18L + 5;
bool issorted(vector<long long int> &v, long long int n) {
  cerr << "n"
       << " is " << n << endl;
  ;
  for (long long int i = 1; i < n; i++) {
    if (v[i] <= v[i - 1]) return false;
    cout << v[i - 1] << " ";
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int T = 1;
  cin >> T;
  while (T--) {
    long long int i, a, b, c, ans = 0, x, y;
    cin >> a >> b >> c;
    while (b) {
      if (c - 2 >= 0) {
        ans += 3;
        c -= 2;
      } else
        break;
      b--;
    }
    while (a) {
      if (b - 2 >= 0) {
        ans += 3;
        b -= 2;
      } else
        break;
      a--;
    }
    cout << ans << endl;
  }
}
