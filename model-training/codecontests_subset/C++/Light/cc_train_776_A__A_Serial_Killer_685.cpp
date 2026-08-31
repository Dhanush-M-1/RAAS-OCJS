#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, c, m, b;
  cin >> s >> c;
  long long n;
  cin >> n;
  cout << s << " " << c << endl;
  for (int i = 0; i < n; i++) {
    cin >> m >> b;
    if (m == s) {
      s = b;
    } else {
      c = b;
    }
    cout << s << " " << c << endl;
  }
}
