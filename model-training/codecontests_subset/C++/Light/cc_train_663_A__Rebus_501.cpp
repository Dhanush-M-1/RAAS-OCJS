#include <bits/stdc++.h>
const int MAXN = 100005;
const long long inf = 1e18;
using namespace std;
void solve() {
  int c[] = {0, 0};
  int sign = 0, n;
  vector<char> v;
  char s;
  cin >> s;
  v.push_back('+');
  while (s != '=') {
    if (s == '?')
      c[sign]++;
    else if (s == '-') {
      sign = 1;
      v.push_back(s);
    } else if (s == '+') {
      sign = 0;
      v.push_back(s);
    }
    cin >> s;
  }
  cin >> n;
  int sum = n;
  int mnp = c[0] - n * c[1];
  int mxp = (n * c[0]) - c[1];
  if (n <= mxp and n >= mnp)
    cout << "Possible" << '\n';
  else {
    cout << "Impossible";
    return;
  }
  for (int j = 0; j < v.size(); j++) {
    s = v[j];
    if (j != 0) cout << s << " ";
    for (int i = n; i > 0; i--) {
      if (s == '+') {
        mnp = c[0] - 1 - n * c[1];
        mxp = (c[0] - 1) * n - c[1];
        if (sum - i <= mxp and sum - i >= mnp) {
          cout << i << " ";
          sum -= i;
          c[0]--;
          break;
        }
      } else {
        mnp = c[0] - n * (c[1] - 1);
        mxp = (c[0]) * n - (c[1] - 1);
        if (sum + i <= mxp and sum + i >= mnp) {
          cout << i << " ";
          sum += i;
          c[1]--;
          break;
        }
      }
    }
  }
  cout << "= " << n;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
