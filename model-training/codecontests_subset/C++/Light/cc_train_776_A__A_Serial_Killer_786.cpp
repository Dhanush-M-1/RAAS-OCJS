#include <bits/stdc++.h>
using namespace std;
string toBinary(int n) {
  string str;
  while (n) {
    str.push_back(n % 2 + '0');
    n /= 2;
  }
  int ln = str.size();
  for (int i = 0; i < ln; i++) {
    if (str[i] == '1') {
      str = str.substr(i, ln);
      break;
    }
  }
  return str;
}
int main() {
  int n;
  string s, t;
  cin >> s >> t;
  cin >> n;
  string t1, t2;
  cout << s << " " << t << endl;
  for (int i = 0; i < n; i++) {
    cin >> t1 >> t2;
    if (t1 == s) {
      s = t2;
      cout << s << " " << t << endl;
    } else {
      t = t2;
      cout << s << " " << t << endl;
    }
  }
}
