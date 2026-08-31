#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
int main() {
  int n;
  string s;
  cin >> n;
  cin >> s;
  int cnt = 0;
  int ans = 0;
  for (int i = 0; i < (int)s.size(); i++) {
    if (s[i] == '8') {
      cnt++;
    }
    int local = min(cnt, ((int)s.size() - cnt) / 10);
    ans = max(ans, local);
  }
  cout << ans;
  return 0;
}
