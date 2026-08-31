#include <bits/stdc++.h>
using namespace std;
int main() {
  string s27;
  int n16;
  cin >> s27 >> n16;
  string res4;
  for (int i26 = 0; i26 < s27.size(); i26++) {
    int a19 = s27[i26];
    if ('a' <= a19 && a19 <= 'z')
      a19 -= 'a';
    else
      a19 -= 'A';
    if (a19 < n16)
      res4.push_back('A' + a19);
    else
      res4.push_back('a' + a19);
  }
  cout << res4 << "\n";
}
