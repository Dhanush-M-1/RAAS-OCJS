#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, j, k, l;
  string s;
  cin >> l >> s;
  int fl = 0;
  for (i = 0; i < l - 1; i++)
    if (s[i] > s[i + 1]) {
      fl = 1;
      break;
    }
  if (fl) {
    cout << "YES\n";
    cout << i + 1 << " " << i + 2;
  } else
    cout << "NO\n";
  return 0;
}
