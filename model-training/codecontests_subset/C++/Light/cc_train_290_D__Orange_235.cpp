#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s >> n;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] <= 'Z') s[i] += 'a' - 'A';
    if (s[i] < 'a' + n) s[i] += 'A' - 'a';
  }
  cout << s << "\n";
}
