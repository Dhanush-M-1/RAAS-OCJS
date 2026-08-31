#include <bits/stdc++.h>
using namespace std;
int main() {
  set<string> s;
  string a, b;
  cin >> a >> b;
  s.insert(a);
  s.insert(b);
  int n;
  cin >> n;
  cout << a << " " << b << endl;
  for (int i = (0); i < (n); ++i) {
    string c, d;
    cin >> c >> d;
    s.erase(s.find(c));
    s.insert(d);
    for (__typeof((s).begin()) j = ((s).begin()); j != (s).end(); ++j) {
      cout << (*j) << " ";
    }
    cout << endl;
  }
}
