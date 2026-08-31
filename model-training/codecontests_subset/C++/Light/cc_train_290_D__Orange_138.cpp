#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s >> n;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] >= 'a' && s[i] < 'a' + n)
      s[i] = 'A' + s[i] - 'a';
    else if (s[i] <= 'Z' && s[i] >= 'A' + n)
      s[i] = 'a' + s[i] - 'A';
  }
  cout << s;
}
