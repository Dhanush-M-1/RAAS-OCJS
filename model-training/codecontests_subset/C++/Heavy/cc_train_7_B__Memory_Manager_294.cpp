#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
int a[100 + 10], b[100 + 10], id, n, m;
char s[1000 + 10];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = (0); i < (n); i++) {
    int k;
    scanf("%s", s);
    if (s[0] == 'a') {
      cin >> k;
      bool g = false;
      if (k > 0) {
        for (int i = (0); i < (m - k + 1); i++) {
          bool f = true;
          for (int j = (i); j < (i + k); j++)
            if (a[j] != 0) f = false;
          if (f) {
            g = true;
            id++;
            for (int j = (i); j < (i + k); j++) a[j] = id;
            break;
          }
        }
      }
      if (!g)
        printf("NULL\n");
      else
        printf("%d\n", id);
    } else if (s[0] == 'e') {
      cin >> k;
      bool f = false;
      for (int i = (0); i < (m); i++)
        if (a[i] == k) {
          f = true;
          a[i] = 0;
        }
      if (!f || k == 0) printf("ILLEGAL_ERASE_ARGUMENT\n");
    } else if (s[0] == 'd') {
      int p = 0;
      for (int i = (0); i < (m); i++) {
        if (a[i] != 0) {
          a[p++] = a[i];
          if (i >= p) a[i] = 0;
        }
      }
    }
  }
  return 0;
}
