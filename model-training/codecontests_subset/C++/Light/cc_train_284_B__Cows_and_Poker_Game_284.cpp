#include <bits/stdc++.h>
using namespace std;
int sol1, sol2, sol3, n;
string str;
int main() {
  cin >> n >> str;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == 'A')
      sol1++;
    else if (str[i] == 'I')
      sol2++;
  }
  sol3 = str.length() - sol1 - sol2;
  if (sol2 == 0) {
    cout << sol1 << endl;
    return 0;
  }
  if (sol2 > 1)
    cout << 0 << endl;
  else
    cout << 1 << endl;
  return 0;
}
