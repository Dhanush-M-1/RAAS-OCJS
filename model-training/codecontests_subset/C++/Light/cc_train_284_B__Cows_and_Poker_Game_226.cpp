#include <bits/stdc++.h>
using namespace std;
char s[222222];
int main() {
  int i, n, na = 0, ni = 0, nf = 0;
  scanf("%d", &n);
  scanf("%s", s);
  n = strlen(s);
  for (i = 0; i < n; i++) {
    if (s[i] == 'A')
      na++;
    else if (s[i] == 'I')
      ni++;
    else if (s[i] == 'F')
      nf++;
  }
  if (ni >= 2)
    cout << 0 << endl;
  else if (ni == 1)
    cout << 1 << endl;
  else {
    cout << na << endl;
  }
  return 0;
}
