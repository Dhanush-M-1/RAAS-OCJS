#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  string s;
  cin >> s;
  string a(s);
  int n;
  cin >> n;
  for (int i = 0; i < int(s.size()); ++i) {
    if (isupper(s[i])) {
      s[i] -= 'A';
      s[i] += 'a';
    }
    if (s[i] < 'a' + n) {
      a[i] = s[i] - 'a' + 'A';
    } else
      a[i] = s[i];
  }
  cout << a;
  return 0;
}
