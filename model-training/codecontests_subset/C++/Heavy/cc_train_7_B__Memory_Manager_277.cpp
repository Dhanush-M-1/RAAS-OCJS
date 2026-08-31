#include <bits/stdc++.h>
using namespace std;
char ss[30];
int mem[200], cur = 0, n, m;
int goodal(int start, int _long) {
  for (int i = 1; i <= _long; ++i)
    if (mem[i + start - 1] != 0 || i + start - 1 > m) return 0;
  return 1;
}
void _fill(int start, int _long) {
  for (int i = 1; i <= _long; ++i) mem[i + start - 1] = cur;
}
void show() {
  for (int i = 1; i <= m; ++i) printf("%d ", mem[i]);
  printf("\n");
}
void alloc() {
  int ind;
  scanf("%d", &ind);
  scanf("\n");
  for (int i = 1; i <= m; ++i)
    if (goodal(i, ind)) {
      ++cur;
      _fill(i, ind);
      printf("%d\n", cur);
      return;
    }
  printf("NULL\n");
}
void erase() {
  int ind, flag = 0;
  scanf("%d", &ind);
  scanf("\n");
  for (int i = 1; i <= m; ++i)
    if (mem[i] == ind && ind != 0) flag = 1, mem[i] = 0;
  if (flag == 0) printf("ILLEGAL_ERASE_ARGUMENT\n");
}
void defragment() {
  scanf("\n");
  int now = 1;
  for (int i = 1; i <= m; ++i)
    if (mem[i] == 0) {
      now = i;
      break;
    }
  for (int i = 1; i <= m; ++i)
    if (i > now && mem[i] != 0) mem[now++] = mem[i], mem[i] = 0;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) {
    scanf("%s", &ss);
    if (ss[0] == 'a')
      alloc();
    else if (ss[0] == 'e')
      erase();
    else
      defragment();
  }
  return 0;
}
