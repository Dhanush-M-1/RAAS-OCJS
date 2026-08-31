#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, a[150], i = 0;
  for (i = 97; i <= 122; i++) a[i] = 0;
  cin >> k;
  char s[1005], b[1005];
  scanf("%s", s);
  i = 0;
  while (s[i] != '\0') {
    a[(int)s[i]]++;
    i++;
  }
  int l = strlen(s);
  if (l % k != 0) {
    cout << -1;
    return 0;
  } else {
    int j, m = 0, x;
    for (j = 97; j < 123; j++) {
      if (a[j] != 0) {
        if (a[j] % k != 0) {
          cout << -1;
          return 0;
        } else {
          i = a[j] / k;
          for (x = m; x < m + i; x++) {
            b[x] = (char)j;
          }
          m = m + i;
        }
      }
    }
    b[m] = '\0';
    if (k * m != l) {
      cout << -1;
      return 0;
    } else
      i = l / m;
    strcpy(s, b);
    for (j = 1; j < i; j++) strcat(s, b);
    puts(s);
    return 0;
  }
}
