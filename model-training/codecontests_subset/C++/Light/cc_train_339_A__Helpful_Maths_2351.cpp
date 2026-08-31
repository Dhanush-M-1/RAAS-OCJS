#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, len;
  char s[105];
  cin >> s;
  len = strlen(s);
  for (i = 0; i < len; i++) {
    for (j = 0; j < len - i - 2; j += 2) {
      if (s[j] > s[j + 2]) {
        swap(s[j], s[j + 2]);
      }
    }
  }
  printf("%s", s);
  return 0;
}
