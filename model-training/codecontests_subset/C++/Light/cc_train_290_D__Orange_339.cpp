#include <bits/stdc++.h>
using namespace std;
const int maxn = 55;
char s[maxn];
int main() {
  ios::sync_with_stdio(false);
  int n;
  scanf("%s %d", s, &n);
  int len = strlen(s);
  for (int i = 0; i < len; ++i) {
    if (isupper(s[i])) s[i] = s[i] - 'A' + 'a';
  }
  n += 97;
  for (int i = 0; i < len; ++i) {
    if (s[i] < n) {
      s[i] = s[i] - 'a' + 'A';
    }
  }
  puts(s);
  return 0;
}
