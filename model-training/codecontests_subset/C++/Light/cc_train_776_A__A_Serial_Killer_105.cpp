#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  cin >> s1 >> ws >> s2;
  int t;
  cin >> t;
  vector<pair<string, string> > v;
  for (int i = 0; i < t; i++) {
    string a, b;
    cin >> a >> ws >> b;
    v.push_back(make_pair(a, b));
  }
  cout << s1 << " " << s2 << endl;
  for (int i = 0; i < t; i++) {
    if (s1 == v[i].first) {
      s1 = v[i].second;
      cout << s1 << " " << s2 << endl;
    } else if (s2 == v[i].first) {
      s2 = v[i].second;
      cout << s1 << " " << s2 << endl;
    }
  }
}
