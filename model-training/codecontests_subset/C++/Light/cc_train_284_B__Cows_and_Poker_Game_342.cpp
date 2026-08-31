#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, ans = 0, f = 0, a = 0, ii = 0;
  cin >> t;
  char str[1000000];
  cin >> str;
  for (int i = 0; i < strlen(str); i++) {
    if (str[i] == 'A')
      a++;
    else if (str[i] == 'F')
      f++;
    else
      ii++;
  }
  if (ii > 1)
    cout << 0;
  else if (ii == 1)
    cout << 1;
  else
    cout << a;
}
