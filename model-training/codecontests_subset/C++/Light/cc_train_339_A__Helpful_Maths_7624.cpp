#include <bits/stdc++.h>
using namespace std;
int main() {
  int l;
  string s;
  cin >> s;
  sort(s.begin(), s.end());
  l = s.size() / 2;
  for (; l < s.size() - 1; l++) {
    cout << s[l] << '+';
  }
  cout << s[s.size() - 1];
}
