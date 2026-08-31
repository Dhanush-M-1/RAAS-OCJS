#include <bits/stdc++.h>
using namespace std;
void solve() {
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin.ignore();
  cin >> n;
  cin.ignore();
  string s[n], ss[n];
  for (int i = 0; i < n; i++) {
    cin >> s[i] >> ss[i];
  }
  cout << s1 << " " << s2 << endl;
  for (int i = 0; i < n; i++) {
    if (s1 == s[i]) {
      s1 = ss[i];
    } else if (s1 == ss[i]) {
      s1 = s[i];
    } else if (s2 == s[i]) {
      s2 = ss[i];
    } else
      s2 = s[i];
    cout << s1 << " " << s2 << endl;
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  { solve(); }
  return 0;
}
