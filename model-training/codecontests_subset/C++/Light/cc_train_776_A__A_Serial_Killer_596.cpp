#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2, x, y, m, o;
  int n;
  cin >> s1 >> s2;
  cin >> n;
  vector<pair<string, string> > v1;
  m = s1;
  o = s2;
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    if (x == s1) {
      v1.push_back(make_pair(y, s2));
      s1 = y;
    } else {
      v1.push_back(make_pair(y, s1));
      s2 = y;
    }
  }
  cout << m << " " << o << endl;
  vector<pair<string, string> >::iterator it = v1.begin();
  while (it != v1.end()) {
    cout << it->first << " " << it->second << endl;
    it++;
  }
}
