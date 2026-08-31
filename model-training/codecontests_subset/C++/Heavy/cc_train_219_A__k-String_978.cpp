#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:36777216")
using namespace std;
inline int MAX(int a, int b) { return (a > b) ? (a) : (b); }
inline int MIN(int a, int b) { return (a < b) ? (a) : (b); }
int main() {
  int const sz = 100;
  int i, j, a[26], b, k;
  string s;
  cin >> k >> s;
  int l = s.length();
  for (i = 0; i <= 25; i++) a[i] = 0;
  for (i = 0; i <= l - 1; i++) a[s[i] - 'a']++;
  for (i = 0; i <= 25; i++)
    if (a[i] % k != 0) {
      cout << "-1";
      return 0;
    } else
      a[i] /= k;
  string pat = "";
  for (i = 0; i <= 25; i++)
    if (a[i])
      for (j = 1; j <= a[i]; j++) pat += 'a' + i;
  for (i = 1; i <= k; i++) cout << pat;
  return 0;
}
