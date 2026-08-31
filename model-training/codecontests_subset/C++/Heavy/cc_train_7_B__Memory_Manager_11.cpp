#include <bits/stdc++.h>
using namespace std;
char s[100];
int n, m, ans;
int blocks = 0;
int a[1010];
int alloc(int x) {
  for (int i = 1; i <= m; i++) {
    int j = i;
    int num = 0;
    while (num != x && j <= m && a[j] == 0) {
      num++;
      j++;
    }
    if (num != x) {
      i = j;
    } else {
      blocks++;
      for (int k = i; k < j; k++) {
        a[k] = blocks;
      }
      return blocks;
    }
  }
  return 0;
}
int erase(int x) {
  if (x <= 0) {
    return -1;
  }
  bool flag = false;
  for (int i = 1; i <= m; i++) {
    while (a[i] == x) {
      a[i++] = 0;
      flag = true;
    }
  }
  if (flag == true) {
    return -2;
  }
  return -1;
}
int defragment() {
  for (int i = 1; i <= m; i++) {
    if (a[i] == 0) {
      for (int j = i + 1; j <= m; j++) {
        if (a[j]) {
          swap(a[i], a[j]);
          break;
        }
      }
    }
  }
  return -5;
}
int main() {
  int x;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%s", &s);
    if (s[0] == 'a') {
      scanf("%d", &x);
      ans = alloc(x);
    } else if (s[0] == 'e') {
      scanf("%d", &x);
      ans = erase(x);
    } else if (s[0] == 'd') {
      ans = defragment();
    }
    if (ans == 0) {
      printf("NULL\n");
    } else if (ans == -1) {
      printf("ILLEGAL_ERASE_ARGUMENT\n");
    } else if (ans >= 1) {
      printf("%d\n", ans);
    }
  }
}
