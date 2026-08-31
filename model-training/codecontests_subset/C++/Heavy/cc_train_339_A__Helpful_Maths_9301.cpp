#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '1')
      a++;
    else if (s[i] == '2')
      b++;
    else if (s[i] == '3')
      c++;
  }
  while (1) {
    if (!a && !b && !c) break;
    if (a) {
      if (a == 1 && b == 0 && c == 0)
        cout << "1" << endl;
      else
        cout << "1+";
      a--;
    } else if (b) {
      if (b == 1 && a == 0 && c == 0)
        cout << "2" << endl;
      else
        cout << "2+";
      b--;
    } else if (c) {
      if (c == 1 && b == 0 && a == 0)
        cout << "3" << endl;
      else
        cout << "3+";
      c--;
    }
  }
  return 0;
}
