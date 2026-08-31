#include <bits/stdc++.h>
using namespace std;
int main() {
  string s[2];
  int n;
  while (cin >> s[0] >> s[1]) {
    cout << s[0] << " " << s[1] << "\n";
    cin >> n;
    for (int i = 0; i < n; i++) {
      string aux[2];
      cin >> aux[0] >> aux[1];
      for (int j = 0; j < 2; j++) {
        if (s[j] == aux[0]) s[j] = aux[1];
      }
      cout << s[0] << " " << s[1] << "\n";
    }
  }
  return 0;
}
