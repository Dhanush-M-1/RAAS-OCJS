#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[100], t[100];
  char lib[3] = {'1', '2', '3'};
  int c, m = 0;
  cin >> s;
  c = strlen(s);
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < c; j++) {
      if (s[j] == lib[i]) {
        t[m] = lib[i];
        m++;
        t[m] = '+';
        m++;
      }
    }
  }
  for (int i = 0; i < c; i++) {
    if (i == (c - 1))
      cout << t[i] << endl;
    else
      cout << t[i];
  }
  return 0;
}
