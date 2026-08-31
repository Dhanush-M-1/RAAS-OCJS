#include <bits/stdc++.h>
using namespace std;
int main() {
  string p;
  cin >> p;
  int n, k = 1;
  cin >> n;
  string str[n];
  for (int i = 0; i < n; i++) {
    cin >> str[i];
    if (str[i] == p) {
      cout << "YES"
           << "\n";
      return 0;
    }
  }
  for (int i = 0; i < n; i++) {
    if (p[0] == str[i][1]) {
      k = 0;
      break;
    }
  }
  if (k == 1) {
    cout << "NO"
         << "\n";
    return 0;
  }
  for (int i = 0; i < n; i++) {
    if (p[1] == str[i][0]) {
      cout << "YES"
           << "\n";
      return 0;
    }
  }
  cout << "NO"
       << "\n";
}
