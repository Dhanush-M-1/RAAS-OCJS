#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1;
  string s2;
  string victim;
  string replace;
  short n;
  cin >> s1 >> s2 >> n;
  cout << s1 << " " << s2 << endl;
  for (short i = 0; i < n; i++) {
    cin >> victim >> replace;
    if (victim == s1)
      s1 = replace;
    else
      s2 = replace;
    cout << s1 << " " << s2 << endl;
  }
  return 0;
}
