#include <bits/stdc++.h>
using namespace std;
const int maxn = 107;
char oper[maxn];
int q;
int l[maxn], r[maxn];
void dfs(int n, int last) {
  if (n == 0) {
    printf("%d", last);
    return;
  }
  if (oper[n] == '+') {
    int _ = 1, __ = q;
    while (_ <= __) {
      int mid = (_ + __) / 2;
      int x = last - mid;
      if (x < r[n - 1]) {
        __ = mid - 1;
      } else if (x > l[n - 1]) {
        _ = mid + 1;
      } else {
        dfs(n - 1, last - mid);
        printf(" %c %d", oper[n], mid);
        return;
      }
    }
  } else {
    int _ = 1, __ = q;
    while (_ <= __) {
      int mid = (_ + __) / 2;
      int x = last + mid;
      if (x < r[n - 1]) {
        _ = mid + 1;
      } else if (x > l[n - 1]) {
        __ = mid - 1;
      } else {
        dfs(n - 1, last + mid);
        printf(" %c %d", oper[n], mid);
        return;
      }
    }
  }
}
int main() {
  char s[2];
  int n = 0;
  while (true) {
    scanf("%s", s);
    if (s[0] == '?')
      ++n;
    else if (s[0] == '=')
      break;
    else
      oper[n] = s[0];
  }
  scanf("%d", &q);
  if (n == 1)
    printf("Possible\n%d = %d\n", q, q);
  else {
    l[0] = q;
    r[0] = 1;
    bool flag = true;
    for (int i = 1; i < n; ++i) {
      if (oper[i] == '-') {
        l[i] = l[i - 1] - 1;
        r[i] = r[i - 1] - q;
      } else {
        l[i] = l[i - 1] + q;
        r[i] = r[i - 1] + 1;
      }
    }
    if (q < r[n - 1] || q > l[n - 1])
      printf("Impossible");
    else {
      printf("Possible\n");
      dfs(n - 1, q);
      printf(" = %d", q);
    }
  }
  return 0;
}
