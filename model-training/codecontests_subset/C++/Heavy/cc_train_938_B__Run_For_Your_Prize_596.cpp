#include <bits/stdc++.h>
using namespace std;
int n, a[100005];
template <typename Malfurion>
void read(Malfurion &x) {
  x = 0;
  char ch = getchar();
  while (!isdigit(ch)) {
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = (x << 1) + (x << 3) + (ch ^ 48);
    ch = getchar();
  }
}
void init() {
  read(n);
  for (register int i = 1; i <= n; i++) read(a[i]);
}
bool cmp(int cmp1, int cmp2) { return cmp1 < cmp2; }
int main() {
  init();
  sort(a + 1, a + 1 + n, cmp);
  a[0] = 1;
  a[n + 1] = 1000000;
  int ans = INT_MAX, totr, totl;
  for (register int i = 0; i <= n; i++) {
    totl = a[i] - a[0];
    totr = a[n + 1] - a[i + 1];
    ans = min(ans, max(totr, totl));
  }
  cout << ans << endl;
  return 0;
}
