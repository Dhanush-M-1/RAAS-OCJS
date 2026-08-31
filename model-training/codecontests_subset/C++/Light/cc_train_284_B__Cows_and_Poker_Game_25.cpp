#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int i = 0, A = 0;
  for (int j = 0; j < n; j++) {
    if (s[j] == 'I') i++;
    if (s[j] == 'A') A++;
  }
  if (i == 1)
    cout << 1 << "\n";
  else if (i > 1)
    cout << 0 << "\n";
  else if (i == 0) {
    cout << A << "\n";
  }
  return 0;
}
