#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, t = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') t++;
  }
  if (n >= 11 && t > 0)
    cout << min(t, n / 11);
  else
    cout << 0;
}
