#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int cnt = 0;
  int n = s.length();
  string x = "";
  for (int i = 0; i < n; i++) {
    if (s[i] != '+') {
      x += s[i];
      cnt++;
    }
  }
  sort(x.begin(), x.end());
  string::iterator it;
  int j = 1;
  cnt--;
  while (cnt--) {
    it = x.insert(x.begin() + j, '+');
    j += 2;
  }
  cout << x;
}
