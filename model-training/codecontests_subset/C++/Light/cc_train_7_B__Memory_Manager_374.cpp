#include <bits/stdc++.h>
using namespace std;
int n, q, x;
int a[1005], cnt, v[1005], tot;
string oper;
bool found(int x) {
  for (int i = 1; i <= n; i++)
    if (a[i] == x) return true;
  return false;
}
int main() {
  cin >> q >> n;
  while (q--) {
    cin >> oper;
    if (oper == "erase") {
      cin >> x;
      if (!found(x) || x == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
        continue;
      }
      for (int i = 1; i <= n; i++)
        if (a[i] == x) a[i] = 0;
    } else if (oper == "alloc") {
      cin >> x;
      int len = 0, l = 0, i;
      for (i = 1; i <= n; i++) {
        if (a[i] == 0) {
          len++;
          if (l == 0) l = i;
          if (len == x) {
            v[++tot] = ++cnt;
            cout << cnt << endl;
            for (int j = l; j <= i; j++) a[j] = cnt;
            break;
          }
        } else
          l = len = 0;
      }
      if (i > n) cout << "NULL\n";
    } else if (oper == "defragment") {
      int s = 0, w[105];
      for (int i = 1; i <= n; i++)
        if (a[i] > 0) w[++s] = a[i];
      memset(a, 0, sizeof(a));
      for (int i = 1; i <= s; i++) a[i] = w[i];
    }
  }
  return 0;
}
