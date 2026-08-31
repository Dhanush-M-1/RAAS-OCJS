#include <bits/stdc++.h>
using namespace std;
char s[100];
int main() {
  int i, n;
  cin >> s >> n;
  for (i = 0; s[i]; i++) {
    if (s[i] < 'a') s[i] += 'a' - 'A';
    if (s[i] < 'a' + n) s[i] += 'A' - 'a';
  }
  cout << s << endl;
  return 0;
}
