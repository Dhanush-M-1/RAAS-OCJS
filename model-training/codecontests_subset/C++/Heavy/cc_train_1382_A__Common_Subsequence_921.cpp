#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e3 + 10;
int n, m, T;
int a[MAXN], b[MAXN];
inline void Read(int &Ret) {
  char ch;
  bool flag = 0;
  for (; ch = getchar(), !isdigit(ch);)
    if (ch == '-') flag = 1;
  for (Ret = ch - '0'; ch = getchar(), isdigit(ch); Ret = Ret * 10 + ch - '0')
    ;
  flag && (Ret = -Ret);
}
int main() {
  Read(T);
  while (T--) {
    Read(n);
    Read(m);
    for (int i = 1; i <= n; i++) Read(a[i]);
    for (int i = 1; i <= m; i++) Read(b[i]);
    bool flag = false;
    int ans;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a[i] == b[j]) {
          ans = a[i];
          flag = true;
          break;
        }
      }
      if (flag) break;
    }
    if (flag) {
      printf("YES\n1 %d\n", ans);
    } else
      printf("NO\n");
  }
}
