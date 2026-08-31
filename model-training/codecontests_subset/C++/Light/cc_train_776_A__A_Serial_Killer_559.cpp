#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  int n;
  cin.sync_with_stdio(false);
  set<string> s;
  while (cin >> a >> b) {
    s.clear();
    s.insert(a);
    s.insert(b);
    cin >> n;
    cout << a << " " << b << endl;
    for (int i = 0; i < n; i++) {
      cin >> a >> b;
      s.erase(s.find(a));
      s.insert(b);
      for (set<string>::iterator it = s.begin(); it != s.end(); it++) {
        cout << *it << " ";
      }
      cout << endl;
    }
  }
  return 0;
}
