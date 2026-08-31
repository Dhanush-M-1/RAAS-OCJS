#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  vector<int> v;
  for (int i = 0; i < s.length(); i += 2) {
    v.push_back(s[i]);
  }
  string res;
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size() - 1; i++) {
    res.push_back(v[i]);
    res.push_back('+');
  }
  res.push_back(v[v.size() - 1]);
  cout << res;
  return 0;
}
