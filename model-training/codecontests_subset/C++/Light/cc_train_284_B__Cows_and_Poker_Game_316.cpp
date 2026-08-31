#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int a = 0, i = 0;
  for (char c : s) {
    if (c == 'A')
      a++;
    else if (c == 'I')
      i++;
    if (i > 1) {
      cout << 0;
      return 0;
    }
  }
  if (i == 1)
    cout << 1;
  else
    cout << a;
  return 0;
}
