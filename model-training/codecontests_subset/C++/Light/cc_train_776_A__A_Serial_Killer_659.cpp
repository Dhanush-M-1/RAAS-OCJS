#include <bits/stdc++.h>
using namespace std;
int main() {
  set<string> s;
  string s1, s2;
  cin >> s1 >> s2;
  s.insert(s1);
  s.insert(s2);
  cout << s1 << " " << s2 << endl;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string x, y;
    cin >> x >> y;
    if (s.find(x) != s.end()) {
      s.erase(x);
      s.insert(y);
    } else if (s.find(y) != s.end()) {
      s.erase(y);
      s.insert(x);
    } else {
      continue;
    }
    set<string>::iterator it;
    for (it = s.begin(); it != s.end(); it++) {
      cout << *it << " ";
    }
    cout << endl;
  }
  return 0;
}
