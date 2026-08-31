#include <bits/stdc++.h>
using namespace std;
int n, m, r, c;
char s[404][404], t[404][404];
bitset<404> ok[26][404], res[404];
bitset<404> bs(bitset<404> ini, int cyclen, int mov) {
  return ((ini << 1) >> mov + 1) | (ini << cyclen - mov);
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = (1); i <= (n); i++) scanf(" %s", s[i] + 1);
  scanf("%d %d", &r, &c);
  for (int i = (1); i <= (r); i++) scanf(" %s", t[i] + 1);
  for (int i = (1); i <= (n); i++)
    for (int j = (1); j <= (m); j++) ok[s[i][j] - 'a'][i][j] = true;
  for (int i = (1); i <= (n); i++)
    for (int j = (1); j <= (m); j++) res[i][j] = true;
  for (int i = (1); i <= (r); i++)
    for (int j = (1); j <= (c); j++) {
      char cur = t[i][j];
      if (cur == '?') continue;
      for (int k = (1); k <= (n); k++) {
        int R = (k - i + 1) % n + n;
        if (R > n) R -= n;
        res[R] &= bs(ok[cur - 'a'][k], m, (j - 1) % m);
      }
    }
  for (int i = (1); i <= (n); i++) {
    for (int j = (1); j <= (m); j++) {
      if (res[i][j])
        printf("1");
      else
        printf("0");
    }
    printf("\n");
  }
  return 0;
}
