#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n, l = 0, k = 0;
  cin >> n;
  string str[n];
  for (int i = 0; i < n; i++) {
    cin >> str[i];
    if (str[i] == s) {
      l = 1;
      k = 1;
    } else if (s[0] == str[i][1]) {
      k = 1;
    }
    if (s[1] == str[i][0]) {
      l = 1;
    }
  }
  cout << (l + k == 2 ? "YES" : "NO");
}
