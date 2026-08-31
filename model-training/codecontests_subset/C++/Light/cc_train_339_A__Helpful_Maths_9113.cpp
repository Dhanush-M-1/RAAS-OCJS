#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  getline(cin, s);
  int n = s.size();
  for (int i = 0; i < n; i++) {
    if (s[i] == '+') continue;
    for (int j = 0; j < n; j++) {
      if (s[j] == '+') continue;
      if (s[i] < s[j]) swap(s[i], s[j]);
    }
  }
  cout << s;
  return 0;
}
