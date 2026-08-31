#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
  cin >> s;
  cin >> n;
  for (int i = 0; i < s.size(); i++) {
    if ((s[i] >= 'a') && (s[i] < 'a' + n)) s[i] -= 'a' - 'A';
    if ((s[i] < 'a') && (s[i] >= 'A' + n)) s[i] += 'a' - 'A';
  }
  cout << s;
  return 0;
}
