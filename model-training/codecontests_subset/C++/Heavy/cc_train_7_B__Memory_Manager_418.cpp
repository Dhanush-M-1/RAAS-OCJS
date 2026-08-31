#include <bits/stdc++.h>
using namespace std;
const int maxn = 30;
const int N = 210;
char op[maxn];
int memory[N], t, n, is[N];
int m, s[N], id = 1, siz[N];
set<int> stor;
int f[N];
bool is_null(int s, int e) {
  for (int i = s; i < e; i++)
    if (memory[i] != 0) return false;
  return true;
}
int main() {
  scanf("%d%d", &t, &m);
  memset(is, -1, sizeof(is));
  for (int i = 0; i < t; i++) {
    scanf("%s", &op);
    if (strcmp(op, "alloc") == 0) {
      int x, i;
      scanf("%d", &x);
      for (i = 1; i <= m; i++) {
        if (i + x - 1 <= m && memory[i] == 0 && is_null(i, i + x)) {
          for (int j = i; j < i + x; j++) memory[j] = id;
          break;
        }
      }
      if (i <= m) {
        is[id] = i;
        siz[id] = x;
        stor.insert(id);
        printf("%d\n", id++);
      } else {
        printf("NULL\n");
      }
    } else if (strcmp(op, "erase") == 0) {
      int x;
      scanf("%d", &x);
      if (stor.count(x) == 0)
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      else {
        stor.erase(x);
        for (int i = is[x]; i < is[x] + siz[x]; i++) memory[i] = 0;
        is[x] = -1;
      }
    } else if (strcmp(op, "defragment") == 0) {
      int num = 0;
      for (int i = 1; i <= m; i++)
        if (memory[i] && (!num || memory[i] != f[num - 1]))
          f[num++] = memory[i];
      memset(memory, 0, sizeof(memory));
      int pre = 1;
      for (int i = 0; i < num; i++)
        if (is[f[i]] != -1) {
          int h = f[i];
          for (int j = pre; j < pre + siz[h]; j++) memory[j] = h;
          is[h] = pre;
          pre += siz[h];
        }
    }
  }
  return 0;
}
