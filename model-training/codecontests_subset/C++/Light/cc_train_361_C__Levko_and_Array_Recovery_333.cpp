#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 5;
const int maxn = 5005;
struct node {
  int t, l, r, m;
} op[maxn];
int n, m;
int num[maxn], add[maxn];
int main() {
  int flag, flag1;
  while (cin >> n >> m) {
    for (int i = 1; i <= m; i++)
      cin >> op[i].t >> op[i].l >> op[i].r >> op[i].m;
    for (int i = 1; i <= n; i++) num[i] = inf;
    memset(add, 0, sizeof(add));
    for (int i = m; i >= 1; i--) {
      if (op[i].t == 1)
        for (int j = op[i].l; j <= op[i].r; j++) num[j] -= op[i].m;
      else
        for (int j = op[i].l; j <= op[i].r; j++) num[j] = min(num[j], op[i].m);
    }
    for (int i = 1; i <= m; i++) {
      flag1 = flag = 0;
      for (int j = op[i].l; j <= op[i].r; j++) {
        if (op[i].t == 1)
          add[j] += op[i].m;
        else {
          if (add[j] + num[j] > op[i].m) {
            flag = 1;
            break;
          }
          if (add[j] + num[j] == op[i].m) flag1 = 1;
        }
      }
      if (!flag1 && op[i].t == 2) flag = 1;
      if (flag) break;
    }
    if (flag)
      cout << "NO\n";
    else {
      cout << "YES\n";
      for (int i = 1; i <= n; i++) {
        if (num[i] >= inf) num[i] = 1e9;
        if (i != n)
          cout << num[i] << " ";
        else
          cout << num[i] << "\n";
      }
    }
  }
  return 0;
}
