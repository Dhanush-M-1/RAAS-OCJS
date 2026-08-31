#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int m = count(s.begin(), s.end(), '8');
  int ans = 0;
  for (int i = 1; i <= m; ++i) {
    ans = max(ans, min(i, (n - i) / 10));
  }
  cout << ans << endl;
}
