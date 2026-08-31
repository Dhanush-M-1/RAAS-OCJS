#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  long long int n;
  cin >> n;
  getline(cin, s);
  getline(cin, s);
  long long int l = s.length();
  long long int a = 0, ii = 0, f = 0;
  for (long long int i = 0; i < l; i++) {
    if (s[i] == 'A') {
      a++;
    } else {
      if (s[i] == 'I') {
        ii++;
      } else {
        f++;
      }
    }
  }
  if (ii == 0) {
    cout << a << endl;
  } else {
    if (ii == 1) {
      cout << 1 << endl;
    } else {
      cout << 0 << endl;
    }
  }
  return 0;
}
