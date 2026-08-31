#include <bits/stdc++.h>
using namespace std;
const int inf = 1000000000;
const int MOD = 1000000007;
int s[11];
vector<int> g;
vector<int> ans[11];
vector<string> solve(long long n) {
  vector<string> res(6, "0");
  if (n < 0) {
    res[0] = "-";
    return res;
  }
  if (n == 0) return res;
  for (int i1 = 0; i1 <= 2; ++i1)
    for (int i2 = i1; i2 <= 2; ++i2)
      for (int i3 = i2; i3 <= 2; ++i3)
        for (int i4 = i3; i4 <= 2; ++i4)
          for (int i5 = i4; i5 <= 2; ++i5)
            for (int i6 = i5; i6 <= 2; ++i6) {
              int cur = g[i1] + g[i2] + g[i3] + g[i4] + g[i5] + g[i6];
              if (cur % 10 != n % 10) continue;
              vector<string> got = solve((n - cur) / 10);
              if (got[0] == "-") continue;
              got[0] += char(g[i1] + 48);
              got[1] += char(g[i2] + 48);
              got[2] += char(g[i3] + 48);
              got[3] += char(g[i4] + 48);
              got[4] += char(g[i5] + 48);
              got[5] += char(g[i6] + 48);
              return got;
            }
  res[0] = "-";
  return res;
}
int main() {
  g.push_back(0);
  g.push_back(4);
  g.push_back(7);
  int t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    vector<string> a = solve(n);
    if (a[0] == "-")
      cout << "-1";
    else
      for (int i = 0; i <= 5; ++i) {
        int pos = 0;
        while (pos < (int)((a[i]).size()) - 1 && a[i][pos] == '0') ++pos;
        for (int j = pos; j <= (int)((a[i]).size()) - 1; ++j) cout << a[i][j];
        cout << " ";
      }
    cout << endl;
  }
}
