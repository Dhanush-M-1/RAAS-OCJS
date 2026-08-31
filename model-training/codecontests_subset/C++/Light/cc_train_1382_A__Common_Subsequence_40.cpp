#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 7;
int a[N], b[N];
void run() {
  int n, m;
  scanf("%d%d", &n, &m);
  unordered_set<int> mp;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", a + i);
    mp.insert(a[i]);
  }
  for (int i = 1; i <= m; ++i) scanf("%d", b + i);
  for (int i = 1; i <= m; ++i)
    if (mp.find(b[i]) != mp.end()) {
      puts("YES");
      printf("1 %d\n", b[i]);
      return;
    }
  puts("NO");
}
int main() {
  int _;
  scanf("%d", &_);
  while (_--) run();
  return 0;
}
