#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s >> n;
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] >= 'a' && s[i] < 'a' + n) s[i] += 'A' - 'a';
    if (s[i] >= 'A' + n && s[i] <= 'Z') s[i] -= 'A' - 'a';
  }
  cout << s;
}
