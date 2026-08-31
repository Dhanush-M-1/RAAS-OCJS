#include <bits/stdc++.h>
using namespace std;
int main() {
  stack<string> s;
  vector<pair<string, string> > v;
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string s3, s4;
    cin >> s3 >> s4;
    v.push_back(make_pair(s3, s4));
  }
  s.push(s1);
  s.push(s2);
  cout << s1 << " " << s2 << '\n';
  for (int i = 0; i < n; i++) {
    if (v[i].first == s.top()) {
      s.pop();
      string s5 = s.top();
      cout << s5 << " " << v[i].second << '\n';
      s.push(v[i].second);
    } else {
      string s6 = s.top();
      s.pop();
      s.pop();
      s.push(s6);
      s.push(v[i].second);
      cout << s6 << " " << v[i].second << '\n';
    }
  }
}
