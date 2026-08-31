#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string a, s, b, c;
  cin >> a >> s;
  cin >> n;
  cout << a << " " << s << endl;
  while (n--) {
    cin >> b >> c;
    if (b == a)
      a = c;
    else if (b == s)
      s = c;
    cout << a << " " << s << endl;
  }
  return 0;
}
