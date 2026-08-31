#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j;
  string s;
  cin >> n;
  cin >> s;
  n = s.size();
  for (i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) break;
  }
  if (i != n - 1) {
    cout << "YES"
         << "\n";
    cout << i + 1 << " " << i + 2 << "\n";
  } else {
    cout << "NO"
         << "\n";
  }
}
