#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int i, l = 0, c, p;
  bool flag = 0;
  cin >> s;
  while (s[l] != '\0') {
    l++;
  }
  p = s[0] - 48;
  for (i = 0; i < l; i = i + 2) {
    c = s[i] - 48;
    if (c > p) continue;
    if ((c == p) || c < p) {
      flag = 1;
      int j, temp[(l + 1) / 2];
      for (j = 0; j < l; j = j + 2) {
        temp[(j + 1) / 2] = s[j] - 48;
      }
      sort(temp, temp + (l + 1) / 2);
      for (j = 0; j < l; j = j + 2) {
        s[j] = temp[(j + 1) / 2] + 48;
      }
      break;
    }
    p = c;
  }
  cout << s;
  return 0;
}
