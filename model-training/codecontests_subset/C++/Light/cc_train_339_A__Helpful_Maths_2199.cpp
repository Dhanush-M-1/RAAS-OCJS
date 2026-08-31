#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string s;
  cin >> s;
  int l = s.size();
  vector<char> v;
  for (int i = 0; i < l; ++i) {
    if (s[i] != '+') {
      v.push_back(s[i]);
    }
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < l; ++i) {
    if (i % 2 == 0) {
      cout << v[0];
      v.erase(v.begin());
    } else
      cout << "+";
  }
  return 0;
}
