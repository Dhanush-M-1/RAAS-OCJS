#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  string s;
  cin >> k;
  cin >> s;
  vector<char> v;
  if (k == 1) {
    cout << s << endl;
    return 0;
  }
  if (k > s.size()) {
    cout << -1 << endl;
    return 0;
  }
  int f[27] = {0};
  for (int i = 0; i < s.size(); i++) {
    f[s[i] - 96]++;
  }
  int fl = 1;
  for (int i = 1; i <= 26; i++) {
    if (f[i] % k == 0) {
      continue;
    } else {
      cout << -1 << endl;
      return 0;
    }
  }
  for (int i = 1; i <= 26; i++) {
    if (f[i] > 0) {
      int h = f[i] / k;
      while (h != 0) {
        v.push_back(i + 96);
        h--;
      }
      f[i] = 0;
    }
  }
  while (k--) {
    for (int i = 0; i < v.size(); i++) {
      cout << v[i];
    }
  }
  cout << endl;
}
