#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[3], t[5];
  bool fg[2] = {0, 0};
  scanf("%s", s);
  int n;
  scanf("%d%*c", &n);
  for (int i = 0; i < n; i++) {
    scanf("%s", t);
    if (t[0] == s[0] && t[1] == s[1]) {
      fg[0] = fg[1] = 1;
    }
    if (t[0] == s[1]) fg[1] = 1;
    if (t[1] == s[0]) fg[0] = 1;
  }
  if (fg[0] == 1 && fg[1] == 1)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
