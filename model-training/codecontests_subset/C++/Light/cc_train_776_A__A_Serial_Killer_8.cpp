#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  string a, b;
  cin >> a >> b;
  short n;
  cin >> n;
  string res[n + 1];
  res[0] = a + " " + b;
  for (int i = 1; i <= n; ++i) {
    string m, r;
    cin >> m >> r;
    if (m == a)
      a = r;
    else
      b = r;
    res[i] = a + " " + b;
  }
  for (int i = 0; i < n + 1; ++i) cout << res[i] << "\n";
}
