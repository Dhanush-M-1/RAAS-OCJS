#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  vector<int> v;
  vector<char> h;
  vector<char> g;
  cin >> s;
  for (int i = 0; i < s.length(); i++) {
    if (i % 2 == 0) {
      int x = s[i] - '0';
      v.push_back(x);
    }
  }
  for (int i = 0; i < v.size(); i++) {
    for (int j = i + 1; j < v.size(); j++) {
      if (v[i] > v[j]) {
        int y = v[i];
        v[i] = v[j];
        v[j] = y;
      }
    }
  }
  for (int i = 0; i < v.size(); i++) {
    char c = v[i] + '0';
    h.push_back(c);
  }
  int count = -1;
  for (int j = 0; j < (2 * h.size()) - 1; j++) {
    if (j % 2 != 0) {
      g.push_back('+');
    } else {
      g.push_back(h[j - (++count)]);
    }
  }
  for (int j = 0; j < (2 * v.size()) - 1; j++) {
    cout << g[j];
  }
  return 0;
}
