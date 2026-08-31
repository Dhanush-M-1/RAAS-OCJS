#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string s;
  cin >> s;
  int c = 0, c1 = 0, c2 = 0, c3 = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '1') c1++;
    if (s[i] == '2') c2++;
    if (s[i] == '3') c3++;
    if (s[i] == '+') c++;
  }
  if (c != 0) {
    while (c > 0) {
      while (c1 > 0) {
        cout << "1";
        if (c > 0) cout << "+";
        c1--;
        c--;
      }
      while (c2 > 0) {
        cout << "2";
        if (c > 0) cout << "+";
        c2--;
        c--;
      }
      while (c3 > 0) {
        cout << "3";
        if (c > 0) cout << "+";
        c3--;
        c--;
      }
    }
  } else
    cout << s;
  return 0;
}
