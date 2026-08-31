#include <bits/stdc++.h>
using namespace std;
int n, c[2 * 100000 + 10], num[3];
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i < n + 1; ++i) {
    char t;
    cin >> t;
    if (t == 'A') {
      c[i] = 0;
      num[0]++;
    } else if (t == 'I') {
      c[i] = 1;
      num[1]++;
    } else {
      c[i] = 2;
      num[2]++;
    }
  }
  int ans = 0;
  for (int i = 1; i < n + 1; ++i) {
    if (c[i] == 2) continue;
    int t[3] = {num[0], num[1], num[2]};
    t[c[i]]--;
    if (!t[1]) ++ans;
  }
  cout << ans << '\n';
  return 0;
}
