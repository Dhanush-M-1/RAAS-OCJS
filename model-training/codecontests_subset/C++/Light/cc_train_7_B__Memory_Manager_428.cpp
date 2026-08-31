#include <bits/stdc++.h>
using namespace std;
int n, m, p, num;
int pl[1010];
int used[1010];
int ord[1010];
int size[1010];
int alloc(int p) {
  if (p > m) return -1;
  for (int i = 1; i <= m; i++) {
    bool flag = 1;
    if (i + p > m + 1) return -1;
    for (int j = i; j < i + p; j++)
      if (used[j]) flag = 0;
    if (flag) return i;
  }
  return -1;
}
bool cmp(int a, int b) { return pl[a] < pl[b]; }
void def() {
  int temp = 0;
  for (int i = 1; i <= m; i++) temp += used[i];
  memset(used, 0, sizeof used);
  for (int i = 1; i <= temp; i++) used[i] = 1;
  int tot = 0;
  for (int i = 1; i <= num; i++)
    if (pl[i] != -1) ord[tot++] = i;
  sort(ord, ord + tot, cmp);
  int now = 1;
  for (int i = 0; i < tot; i++) pl[ord[i]] = now, now += size[ord[i]];
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    char ctrl[20];
    scanf("%s", ctrl);
    if (ctrl[0] == 'a') {
      scanf("%d", &p);
      int a = alloc(p);
      if (a == -1) {
        puts("NULL");
        continue;
      }
      pl[++num] = a;
      size[num] = p;
      printf("%d\n", num);
      for (int i = pl[num]; i < pl[num] + size[num]; i++) used[i] = 1;
    } else if (ctrl[0] == 'e') {
      scanf("%d", &p);
      if (p > num || p <= 0 || pl[p] == -1) {
        puts("ILLEGAL_ERASE_ARGUMENT");
        continue;
      }
      for (int i = pl[p]; i < pl[p] + size[p]; i++) used[i] = 0;
      pl[p] = -1;
    } else
      def();
  }
  return 0;
}
