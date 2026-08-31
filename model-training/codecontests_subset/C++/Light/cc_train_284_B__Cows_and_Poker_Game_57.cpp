#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n, i, a, f, in;
  char ch;
  cin >> n;
  a = 0;
  in = 0;
  f = 0;
  for (i = 0; i < n; i++) {
    cin >> ch;
    if (ch == 'A')
      a++;
    else if (ch == 'I')
      in++;
    else
      f++;
  }
  if (in == 1)
    cout << in;
  else if (in > 1)
    cout << 0;
  else {
    cout << (a);
  }
  return 0;
}
