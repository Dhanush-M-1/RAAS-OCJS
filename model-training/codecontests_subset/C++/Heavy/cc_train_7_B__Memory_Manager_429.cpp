#include <bits/stdc++.h>
using namespace std;
const int MAXM = 110;
int inx, t, n, tot;
char c[20];
struct In {
  int l;
  int r;
  int len;
  int id;
} s[MAXM];
int find_pos(int x) {
  if (tot == 0) {
    if (x <= n) {
      s[tot].l = 1;
      s[tot].r = x;
      s[tot].len = x;
      s[tot].id = inx;
      tot++;
      return inx;
    } else
      return -1;
  } else {
    int i, j;
    for (i = 0; i < tot; i++) {
      if (i == 0) {
        if (s[i].l - 1 >= x) {
          for (j = tot; j > i; j--) {
            s[j].l = s[j - 1].l;
            s[j].r = s[j - 1].r;
            s[j].len = s[j - 1].len;
            s[j].id = s[j - 1].id;
          }
          s[i].l = 1;
          s[i].r = x;
          s[i].len = x;
          s[i].id = inx;
          tot++;
          return inx;
        }
      } else {
        if (s[i].l - s[i - 1].r - 1 >= x) {
          for (j = tot; j > i; j--) {
            s[j].l = s[j - 1].l;
            s[j].r = s[j - 1].r;
            s[j].len = s[j - 1].len;
            s[j].id = s[j - 1].id;
          }
          s[i].l = s[i - 1].r + 1;
          s[i].r = s[i - 1].r + x;
          s[i].len = x;
          s[i].id = inx;
          tot++;
          return inx;
        }
      }
    }
    if (n - s[tot - 1].r >= x) {
      s[tot].l = s[tot - 1].r + 1;
      s[tot].r = s[tot - 1].r + x;
      s[tot].len = x;
      s[tot].id = inx;
      tot++;
      return inx;
    } else
      return -1;
  }
}
int find_erase(int x) {
  int i, j;
  for (i = 0; i < tot; i++)
    if (s[i].id == x) break;
  if (i == tot) return -1;
  for (j = i; j < tot - 1; j++) {
    s[j].l = s[j + 1].l;
    s[j].r = s[j + 1].r;
    s[j].len = s[j + 1].len;
    s[j].id = s[j + 1].id;
  }
  tot--;
  return i;
}
void update() {
  int i;
  for (i = 0; i < tot; i++) {
    if (i == 0) {
      s[i].l = 1;
      s[i].r = s[i].len;
    } else {
      s[i].l = s[i - 1].r + 1;
      s[i].r = s[i - 1].r + s[i].len;
    }
  }
}
int main() {
  inx = 1;
  scanf("%d%d", &t, &n);
  tot = 0;
  int i, j;
  while (t--) {
    scanf("%s", c);
    if (c[0] == 'a') {
      scanf("%d", &i);
      j = find_pos(i);
      if (j == -1)
        printf("NULL\n");
      else {
        inx++;
        printf("%d\n", j);
      }
    } else if (c[0] == 'e') {
      scanf("%d", &i);
      j = find_erase(i);
      if (j == -1) printf("ILLEGAL_ERASE_ARGUMENT\n");
    } else {
      update();
    }
  }
  return 0;
}
