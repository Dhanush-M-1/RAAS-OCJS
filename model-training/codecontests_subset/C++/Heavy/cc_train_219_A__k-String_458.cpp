#include <bits/stdc++.h>
using namespace std;
char a[100010];
int b[26];
int main() {
  int n;
  memset(a, 0, sizeof(a));
  while (scanf("%d %s", &n, a) != EOF) {
    bool flag = 1;
    memset(b, 0, sizeof(b));
    for (int i = 0; a[i]; i++) {
      b[a[i] - 'a']++;
    }
    int k = 0;
    memset(a, 0, sizeof(a));
    for (int i = 0; i < 26; i++) {
      if (b[i] % n != 0) {
        flag = 0;
      } else {
        int x = b[i] / n;
        while (x) {
          a[k++] = char('a' + i);
          x--;
        }
      }
    }
    if (flag) {
      for (int i = 0; i < n; i++) printf("%s", a);
      cout << endl;
    } else
      cout << "-1" << endl;
  }
  return 0;
}
