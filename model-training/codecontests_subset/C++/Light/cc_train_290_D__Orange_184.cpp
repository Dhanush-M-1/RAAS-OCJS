#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, ans;
  int n;
  cin >> s;
  cin >> n;
  for (int i = 0; i < s.size(); i++) {
    char tp;
    if (s[i] >= 'A' && s[i] <= 'Z')
      tp = (s[i] + ('a' - 'A'));
    else
      tp = (s[i]);
    if (tp < n + 97) {
      cout << char((tp - ('a' - 'A')));
    } else
      cout << char(tp);
  }
  cout << endl;
  return 0;
}
