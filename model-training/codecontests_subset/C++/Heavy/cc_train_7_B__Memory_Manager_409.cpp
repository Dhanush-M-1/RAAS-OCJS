#include <bits/stdc++.h>
using namespace std;
const int INF = 2147483647;
const double PI = 3.141592653589793;
int tab[105], used[105], a, i, u, m, n, k;
char t[15];
bool good(int p, int a) {
  int i;
  for (i = p; i < p + a; i++)
    if (used[i]) return false;
  return true;
}
int pr(int a) {
  int i, j;
  for (i = 1; i <= m - a + 1; i++)
    if (good(i, a)) {
      for (j = i; j < i + a; j++) used[j] = u + 1;
      return i;
    }
  return 0;
}
void kas(int a) {
  int i = tab[a];
  while (i <= m && used[i] == a) {
    used[i] = 0;
    i++;
  }
  tab[a] = 0;
}
void defr() {
  int i, j;
  for (i = 2; i <= m; i++)
    if (used[i] != 0 && used[i - 1] == 0) {
      j = i;
      while (j - 1 >= 1 && used[j - 1] == 0) {
        swap(used[j - 1], used[j]);
        j--;
      }
      if (j == 1 || used[j - 1] != used[j]) tab[used[j]] = j;
    }
}
int main() {
  scanf("%d %d", &n, &m);
  u = 0;
  for (i = 0; i < n; i++) {
    scanf("%s", &t);
    if (t[0] == 'a') {
      scanf("%d", &a);
      k = pr(a);
      if (k) {
        u++;
        tab[u] = k;
        printf("%d\n", u);
      } else
        printf("NULL\n");
    } else if (t[0] == 'e') {
      scanf("%d", &a);
      if (a < 0 || a > 100 || tab[a] == 0)
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      else
        kas(a);
    } else {
      defr();
    }
  }
  return 0;
}
