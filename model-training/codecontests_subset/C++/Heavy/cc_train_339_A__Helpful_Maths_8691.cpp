#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int c1 = 0, c2 = 0, c3 = 0, a;
  cin >> s;
  for (int i = 0; i < s.length(); i = i + 2) {
    a = (s[i]);
    if (a == '1') c1++;
    if (a == '2') c2++;
    if (a == '3') c3++;
  }
  while (1) {
    if (c1) {
      cout << '1';
      c1--;
      if (c1 + c2 + c3 == 0)
        break;
      else
        cout << '+';
      continue;
    }
    if (c2) {
      cout << '2';
      c2--;
      if (c1 + c2 + c3 == 0)
        break;
      else
        cout << '+';
      continue;
    }
    if (c3) {
      cout << '3';
      c3--;
      if (c1 + c2 + c3 == 0)
        break;
      else
        cout << '+';
      continue;
    }
  }
}
