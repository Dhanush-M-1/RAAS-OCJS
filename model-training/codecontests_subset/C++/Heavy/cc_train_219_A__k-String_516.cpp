#include <bits/stdc++.h>
using namespace std;
int main() {
  int letters[27];
  int k;
  int l;
  int ssize;
  char s[1001];
  char c[1001];
  for (int i = 0; i < 1001; i++) c[i] = 0;
  for (int i = 0; i < 27; i++) letters[i] = 0;
  cin >> k;
  cin >> s;
  for (ssize = 0; ssize < 1001; ssize++)
    if (s[ssize] == 0) break;
  for (int i = 0; i < ssize; i++) {
    letters[s[i] - 'a']++;
  }
  for (int i = 0; i < 27; i++) {
    if (letters[i] % k) {
      cout << -1;
      exit(0);
    }
  }
  for (int i = 0; i < 27; i++) letters[i] = letters[i] / k;
  for (int i = 0, m = 0; i < 27; i++) {
    for (int j = 0; letters[i] > 0; j++) {
      c[m] = 'a' + i;
      letters[i]--;
      m++;
    }
    l = m;
  }
  for (int i = 0; i < ssize / k; i++) {
    for (int j = 0; j < k; j++) {
      c[l * j + i] = c[i];
    }
  }
  cout << c;
}
