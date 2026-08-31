#include <bits/stdc++.h>
using namespace std;
string s, d, f, g;
int n;
int main() {
  cin >> s >> d >> n;
  cout << s << " " << d << endl;
  for (int i = 0; i < n; i++) {
    cin >> f >> g;
    if (f == s) {
      s.erase(s.begin(), s.end());
      s = g;
      cout << s << " " << d << endl;
    } else {
      d.erase(d.begin(), d.end());
      d = g;
      cout << s << " " << d << endl;
    }
  }
}
