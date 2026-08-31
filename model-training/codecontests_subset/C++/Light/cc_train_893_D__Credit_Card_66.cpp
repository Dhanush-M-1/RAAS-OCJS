#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, lim;
int a[N];
set<pair<int, int> > S;
int main() {
  scanf("%d%d", &n, &lim);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
  int curMoney = 0, store = 0, ans = 0;
  for (int i = 1; i <= n; ++i) {
    if (a[i] == 0) {
      if (curMoney < 0) {
        int get = min(store, lim + S.begin()->first);
        get = min(get, -curMoney);
        store -= get;
        curMoney += get;
        if (curMoney < 0) {
          curMoney = 0;
          S.clear();
          store = lim;
          ++ans;
        }
      }
    } else {
      curMoney += a[i];
      if (curMoney > lim) {
        puts("-1");
        return 0;
      }
      S.insert(pair<int, int>(-curMoney, i));
    }
  }
  printf("%d", ans);
  return 0;
}
