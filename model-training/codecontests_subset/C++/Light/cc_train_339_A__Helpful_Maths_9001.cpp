#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int x;
  x = s.length();
  int b[(x / 2) + 1];
  for (int i = 0; i < (x / 2) + 1; i++) b[i] = 0;
  int j = 0;
  for (int i = 0; i < s.length(); i = i + 2) {
    b[j] = (s[i] - '0');
    j++;
  }
  sort(b, b + j);
  for (int k = 0; k < j; k++) {
    cout << b[k];
    if (k != j - 1) cout << '+';
  }
  return 0;
}
