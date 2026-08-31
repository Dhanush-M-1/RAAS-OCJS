#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
int main() {
  int k;
  string s, st;
  cin >> k >> s;
  map<char, int> m;
  set<char> s1;
  if (s.length() % k) {
    cout << -1;
    return 0;
  }
  for (auto i = 0; i < s.length(); i++) {
    if (m.find(s[i]) == m.end())
      m.insert({s[i], 1});
    else
      m[s[i]]++;
    s1.insert(s[i]);
  }
  for (auto i = m.begin(); i != m.end(); ++i) {
    if (i->second % k) {
      cout << -1;
      return 0;
    }
  }
  for (auto i = s1.begin(); i != s1.end(); ++i) {
    while (m[*i] != 0) {
      st += *i;
      m[*i] -= k;
    }
  }
  for (auto i = 0; i < k; i++) cout << st;
}
