#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, key, l;
  char s[1020], res[1020];
  int a[30];
  while (cin >> k) {
    cin >> s;
    l = strlen(s);
    memset(a, 0, sizeof(a));
    for (int i = 0; i < l; i++) {
      key = s[i] - 'a';
      a[key]++;
    }
    int kk = 1, len = 0;
    for (int i = 0; i < 26; i++) {
      if (a[i] % k == 0) {
        for (int j = 0; j < a[i] / k; j++) {
          res[len++] = 'a' + i;
        }
      } else {
        kk = 0;
        break;
      }
    }
    res[len] = 0;
    if (kk == 0) {
      cout << "-1" << endl;
    } else {
      for (int i = 0; i < k; i++) printf("%s", res);
      cout << endl;
    }
  }
}
