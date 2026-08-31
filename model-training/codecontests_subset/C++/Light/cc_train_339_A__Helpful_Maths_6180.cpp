#include <bits/stdc++.h>
using namespace std;
void count(char *s, int *c) {
  while (*s != '\0') {
    ++c[*s - '0'];
    s += 2;
  }
}
void sort(char *s, int *c) {
  for (int i = 1; i <= 3; ++i) {
    for (int j = 0; j < c[i]; ++j) {
      *s = '0' + i;
      s += 2;
    }
  }
}
int main(void) {
  ios_base::sync_with_stdio(false);
  int c[4] = {0};
  char s[105];
  cin >> s;
  count(s, c);
  sort(s, c);
  cout << s;
  return 0;
}
