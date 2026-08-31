#include <bits/stdc++.h>
using namespace std;
bool f[1000];
int t, m;
char s[100];
int cnt;
int start[1000], len[1000];
bool used[1000];
void solve() {
  scanf("%d%d", &t, &m);
  for (int i = 0; i < t; i++) {
    scanf("%s", s);
    if (s[0] == 'a') {
      int n;
      scanf("%d", &n);
      int q = 0;
      for (int i = 0; i + n <= m; i++) {
        bool ok = true;
        for (int j = i; j < i + n; j++)
          if (used[j]) {
            ok = false;
            break;
          }
        if (ok) {
          printf("%d\n", ++cnt);
          f[cnt] = true;
          for (int j = i; j < i + n; j++) used[j] = true;
          start[cnt] = i;
          len[cnt] = n;
          q = 1;
          break;
        }
      }
      if (q == 0) {
        printf("NULL\n");
      }
    } else if (s[0] == 'e') {
      int x;
      scanf("%d", &x);
      if (x >= 0 && x < 1000 && f[x]) {
        f[x] = false;
        for (int j = start[x]; j < start[x] + len[x]; j++) used[j] = false;
      } else {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      }
    } else {
      int min_st = -1;
      int have = 0;
      memset(used, 0, sizeof(used));
      while (true) {
        int q = -1;
        int mi = 1000;
        for (int i = 1; i <= cnt; i++)
          if (f[i] && start[i] > min_st && start[i] < mi) {
            q = i;
            mi = start[i];
          }
        if (q == -1) break;
        min_st = start[q];
        start[q] = have;
        have += len[q];
      }
      for (int i = 0; i < have; i++) used[i] = true;
    }
  }
}
int main() {
  solve();
  return 0;
}
