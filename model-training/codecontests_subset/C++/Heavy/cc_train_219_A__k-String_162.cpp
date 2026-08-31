#include <bits/stdc++.h>
using namespace std;
int v[26];
int main() {
  int n;
  int i;
  int j;
  scanf("%d", &n);
  char s[1005];
  getchar();
  gets(s);
  char t[30];
  memset(v, 0, sizeof(v));
  int len = strlen(s);
  if (len % n != 0)
    cout << -1 << endl;
  else {
    for (i = 0; i < len; i++) {
      v[s[i] - 'a']++;
    }
    for (i = 0; i < 26; i++) {
      if (v[i] % n != 0) break;
    }
    int pp = n;
    int kk;
    if (i == 26) {
      while (pp--) {
        for (i = 0; i < 26; i++) {
          if (v[i] != 0) {
            kk = v[i] / n;
            while (kk--) printf("%c", i + 'a');
          }
        }
      }
      cout << endl;
    } else
      cout << -1 << endl;
  }
}
