#include <bits/stdc++.h>
using namespace std;
int h[111];
int main() {
  string s;
  cin >> s;
  int j = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '1') {
      h[j] = 1;
      j++;
    } else if (s[i] == '2') {
      h[j] = 2;
      j++;
    } else if (s[i] == '3') {
      h[j] = 3;
      j++;
    } else {
      continue;
    }
  }
  sort(h, h + j);
  int p = 0;
  for (int i = 0; i < j; i++) {
    if (p) {
      cout << "+";
    }
    p++;
    cout << h[i];
  }
}
