#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int c = 0;
  int i;
  for (i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      c = 1;
      break;
    }
  }
  if (c == 1)
    cout << "YES\n" << i + 1 << " " << i + 2 << "\n";
  else
    cout << "NO\n";
}
