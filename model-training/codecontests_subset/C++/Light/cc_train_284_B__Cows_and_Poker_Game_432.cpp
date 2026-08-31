#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a = 0, l = 0, f = 0;
  string s;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A')
      a++;
    else if (s[i] == 'I')
      l++;
    else
      f++;
  }
  if (l >= 2)
    cout << 0;
  else if (l == 1)
    cout << 1;
  else
    cout << a;
  return 0;
}
