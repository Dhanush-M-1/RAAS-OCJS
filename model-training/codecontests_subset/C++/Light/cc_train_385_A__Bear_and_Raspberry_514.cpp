#include <bits/stdc++.h>
using namespace std;
int a[110], n, ans = 0, m;
void init() {
  cin >> n >> m;
  for (int i = (1); i <= (n); ++i) cin >> a[i];
  for (int i = (1); i <= (n - 1); ++i) ans = max(ans, a[i] - a[i + 1]);
  ans = max(0, ans - m);
  cout << ans;
}
void work() {}
int main() {
  init();
  work();
  return 0;
}
