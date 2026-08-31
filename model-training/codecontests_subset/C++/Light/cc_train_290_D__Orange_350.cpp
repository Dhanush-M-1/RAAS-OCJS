#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[55];
  int n;
  cin >> s >> n;
  int l = strlen(s);
  for (int i = 0; i < l; i++) {
    if (s[i] >= 'a' && s[i] <= 'z' && s[i] - 'a' + 1 <= n)
      s[i] = s[i] + 'A' - 'a';
    if (s[i] >= 'A' && s[i] <= 'Z' && s[i] - 'A' + 1 > n)
      s[i] = s[i] - 'A' + 'a';
  }
  cout << s << endl;
  return 0;
}
