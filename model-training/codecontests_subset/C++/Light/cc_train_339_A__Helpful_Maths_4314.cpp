#include <bits/stdc++.h>
using namespace std;
vector<char> v;
int main() {
  string s;
  cin >> s;
  for (int(i) = (0); (i) < (s.size()); ++(i)) {
    if (s[i] != '+') {
      v.push_back(s[i]);
    }
  }
  sort(v.begin(), v.end());
  for (int(i) = (0); (i) < (v.size()); ++(i)) {
    if (i + 1 == v.size()) {
      cout << v[i];
    } else
      cout << v[i] << "+";
  }
  return 0;
}
