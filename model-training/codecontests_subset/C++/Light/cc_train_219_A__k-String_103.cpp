#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, j;
  cin >> n;
  string s;
  cin >> s;
  map<int, int> m;
  vector<char> v;
  for (i = 0; i < s.length(); i = i + 1) {
    m[s[i]] = m[s[i]] + 1;
  }
  for (i = 97; i < 123; i = i + 1) {
    if (m[i] % n != 0) {
      cout << -1 << endl;
      goto label;
    } else {
      for (j = 0; j < (m[i] / n); j = j + 1) {
        v.push_back(char(i));
      }
    }
  }
  for (i = 0; i < n; i = i + 1) {
    for (auto it = v.begin(); it != v.end(); it++) {
      cout << *it;
    }
  }
label:;
}
