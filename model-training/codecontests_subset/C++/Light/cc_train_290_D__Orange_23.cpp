#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  string s;
  cin >> s;
  int n;
  cin >> n;
  for (int i = 0; i < s.size(); i++) {
    s[i] = tolower(s[i]);
  }
  string ans = "";
  for (int i = 0; i < s.size(); i++) {
    int m = s[i];
    if (m < n + 97) {
      ans += toupper(s[i]);
    } else {
      ans += s[i];
    }
  }
  cout << ans;
}
