#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  bool flag = false;
  for (int i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      flag = true;
      char ch = s[i];
      s[i] = s[i - 1];
      s[i - 1] = ch;
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      break;
    }
  }
  if (!flag) {
    cout << "NO" << endl;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
