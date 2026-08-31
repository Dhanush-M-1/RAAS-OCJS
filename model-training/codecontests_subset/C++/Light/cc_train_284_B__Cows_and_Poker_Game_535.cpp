#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, b = 0, k = 0;
  string s;
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'I') k++;
    if (s[i] == 'A') b++;
  }
  if (k == 0)
    cout << b;
  else if (k == 1)
    cout << 1;
  else
    cout << 0;
}
