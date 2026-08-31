#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s;
  cin >> n;
  int ig = 0, p = 0, se = 0;
  for (int i = 0; i < n; i++) {
    string t;
    cin >> t;
    if (t == s) ig = 1;
    if (t[1] == s[0]) p = 1;
    if (t[0] == s[1]) se = 1;
  }
  if ((p && se) || ig)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
