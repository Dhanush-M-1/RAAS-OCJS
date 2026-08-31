#include <bits/stdc++.h>
using namespace std;
int main() {
  string s[2];
  cin >> s[0] >> s[1];
  int n;
  cin >> n;
  for (int i = 0; i <= n; i++) {
    if (i) {
      string a, b;
      cin >> a >> b;
      if (a == s[0])
        s[0] = b;
      else if (a == s[1])
        s[1] = b;
      else if (b == s[0])
        s[0] = a;
      else
        s[1] = a;
    }
    cout << s[0] << " " << s[1] << endl;
  }
  return 0;
}
