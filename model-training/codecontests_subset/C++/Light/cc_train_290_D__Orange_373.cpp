#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int a;
  cin >> s;
  cin >> a;
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] >= 'A' && s[i] <= 'Z') {
      s[i] += 32;
    }
  }
  for (int i = 0; i < s.size(); ++i) {
    if (a + 97 > s[i]) {
      s[i] -= 32;
    }
  }
  cout << s << endl;
}
