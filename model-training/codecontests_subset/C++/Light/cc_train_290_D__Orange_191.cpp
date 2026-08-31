#include <bits/stdc++.h>
using namespace std;
const long double pi = 3.141592653589793238462643l;
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  for (int i = 0; i < int(s.size()); i++) {
    if (s[i] >= 'a' && s[i] <= 'z') {
      if (s[i] < 'a' + n) {
        s[i] += 'A' - 'a';
      }
    } else {
      if (s[i] >= 'A' + n) {
        s[i] += 'a' - 'A';
      }
    }
  }
  cout << s << endl;
  return 0;
}
