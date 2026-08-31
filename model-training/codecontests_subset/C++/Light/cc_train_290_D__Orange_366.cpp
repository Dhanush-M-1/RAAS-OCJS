#include <bits/stdc++.h>
using namespace std;
string s;
int a;
int main() {
  int i, d = 'A' - 'a';
  cin >> s;
  cin >> a;
  for (i = 0; i < s.size(); i++) {
    if (s[i] >= 'a' && s[i] <= 'z') {
      if (int(s[i] - 'a') + 1 <= a) s[i] += d;
    } else if (s[i] >= 'A' && s[i] <= 'Z') {
      if (int(s[i] - 'A') + 1 > a) s[i] -= d;
    }
  }
  cout << s << endl;
  return 0;
}
