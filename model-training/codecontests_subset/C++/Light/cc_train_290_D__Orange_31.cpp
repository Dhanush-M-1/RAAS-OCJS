#include <bits/stdc++.h>
using namespace std;
char s[5050];
int n, k;
int main() {
  scanf("%s", &s);
  scanf("%d", &k);
  n = strlen(s);
  for (int i = 0; i < n; ++i)
    if (('A' <= s[i]) && (s[i] <= 'Z')) {
      if (s[i] - 'A' < k)
        printf("%c", s[i]);
      else
        printf("%c", s[i] - 'A' + 'a');
    } else {
      if (s[i] - 'a' < k)
        printf("%c", s[i] - 'a' + 'A');
      else
        printf("%c", s[i]);
    }
  puts("");
  return 0;
}
