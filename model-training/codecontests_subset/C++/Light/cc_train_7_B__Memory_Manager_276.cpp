#include <bits/stdc++.h>
using namespace std;
char cmd[20];
int t, m, s[101];
int find(int l) {
  int mxv = 0;
  for (int i = 0; i < m; i++) {
    if (s[i] == 0) {
      mxv++;
      if (mxv == l) return i - l + 1;
    } else {
      mxv = 0;
    }
  }
  return -1;
}
int main() {
  scanf("%d%d", &t, &m);
  int num = 1;
  for (int i = 0; i < t; i++) {
    scanf("%s", cmd);
    if (strcmp(cmd, "alloc") == 0) {
      int n;
      scanf("%d", &n);
      int index = find(n);
      if (index == -1)
        puts("NULL");
      else {
        for (int i = index; i < index + n; i++) s[i] = num;
        printf("%d\n", num);
        num++;
      }
    } else if (strcmp(cmd, "erase") == 0) {
      int x;
      scanf("%d", &x);
      bool ck = false;
      if (x > 0) {
        for (int i = 0; i < m; i++)
          if (s[i] == x) {
            s[i] = 0;
            ck = true;
          }
      }
      if (!ck) puts("ILLEGAL_ERASE_ARGUMENT");
    } else {
      int i = 0, j = 0;
      while (i < m && j < m) {
        while (i < m && s[i] != 0) i++;
        while (j < m && s[j] == 0) j++;
        if (i >= m || j >= m) break;
        if (i < j) {
          s[i] = s[j];
          s[j] = 0;
        } else
          j++;
      }
    }
  }
}
