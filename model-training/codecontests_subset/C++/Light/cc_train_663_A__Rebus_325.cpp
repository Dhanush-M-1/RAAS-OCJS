#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;
int c[2] = {1, 0}, n;
string sign = "+";
vector<int> ans;
bool possible() {
  int d = n, lo, hi;
  for (char s : sign) {
    if (s == '+') {
      c[0]--;
      hi = min(n, c[1] * n - c[0] + d);
      lo = max(1, c[1] - c[0] * n + d);
      d -= lo;
    } else {
      c[1]--;
      hi = min(n, c[0] * n - c[1] - d);
      lo = max(1, c[0] - c[1] * n - d);
      d += lo;
    };
    if (lo > hi) return false;
    ans.push_back(lo);
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout << fixed;
  for (string tok;;) {
    cin >> tok >> tok;
    if (tok[0] == '=') break;
    sign += tok[0];
    c[tok[0] == '+' ? 0 : 1]++;
  }
  cin >> n;
  ;
  ;
  if (possible()) {
    cout << "Possible" << endl;
    for (size_t i = 0; i < sign.size(); i++) {
      if (i > 0) cout << sign[i] << ' ';
      cout << ans[i] << ' ';
    }
    cout << "= " << n << endl;
  } else {
    cout << "Impossible" << endl;
  }
  return 0;
}
