#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int ca, cf, ci;
  ca = cf = ci = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A')
      ca++;
    else if (s[i] == 'F')
      cf++;
    else
      ci++;
  }
  if (ci == 0)
    cout << ca;
  else if (ci == 1)
    cout << "1";
  else
    cout << "0";
}
