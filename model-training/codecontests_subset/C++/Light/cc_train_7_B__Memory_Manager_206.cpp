#include <bits/stdc++.h>
using namespace std;
long long id[200], pos[200];
string s;
int main() {
  int t, n;
  scanf("%d%d", &t, &n);
  for (int i = (0); i < (n); ++i) id[i] = -4000000000ll;
  for (int i = (0); i < (200); ++i) pos[i] = -1;
  int k = 1;
  while (t--) {
    cin >> s;
    if (s[0] == 'a') {
      int p;
      scanf("%d", &p);
      bool f1 = false;
      for (int i = (0); i < (n); ++i)
        if ((id[i] == -4000000000ll) && (i + p <= n)) {
          bool f = true;
          for (int j = (0); j < (p); ++j)
            if (id[i + j] != -4000000000ll) {
              f = false;
              break;
            }
          if (f) {
            f1 = true;
            for (int j = i; j < i + p; j++) id[j] = k;
            break;
          }
        }
      if (f1) {
        pos[k - 1] = p;
        printf("%d\n", k);
        k++;
      } else
        printf("NULL\n");
    }
    if (s[0] == 'e') {
      int e;
      scanf("%d", &e);
      bool f1 = false;
      for (int i = (0); i < (n); ++i)
        if (id[i] == e) {
          f1 = true;
          id[i] = -4000000000ll;
        }
      if (!f1)
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      else
        pos[e - 1] = -1;
    }
    if (s[0] == 'd') {
      for (int i = (0); i < (n); ++i)
        if (id[i] != -4000000000ll) {
          int k = i;
          while ((k > 0) && (id[k - 1] == -4000000000ll)) {
            swap(id[k], id[k - 1]);
            k--;
          }
        }
    }
  }
  return 0;
}
