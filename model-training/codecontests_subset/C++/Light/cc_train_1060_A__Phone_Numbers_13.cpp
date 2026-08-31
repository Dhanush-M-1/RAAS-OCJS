#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, temp = 0, temp1 = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] == '8') temp++;
  }
  for (int i = 1; i <= temp; i++) {
    int r = (n - i) / 10;
    if (r >= i) {
      temp1++;
    } else
      break;
  }
  cout << temp1;
  return 0;
}
