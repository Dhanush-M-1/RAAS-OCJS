#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int N = 3e5 + 4;
int main() {
  int n, m;
  scanf("%d", &n);
  scanf("%d", &m);
  int a[n + 1];
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  vector<int> v[n + 1];
  for (int i = 0; i < m; i++) {
    int x, y;
    scanf("%d", &x);
    scanf("%d", &y);
    v[x].push_back(y);
  }
  vector<int> will_block(n + 1, 0);
  int blocks = 1;
  will_block[a[n]] = 1;
  int ans = 0;
  for (int i = n - 1; i > 0; i--) {
    int can_skip = 0;
    for (int it : v[a[i]])
      if (will_block[it]) can_skip++;
    if (can_skip == blocks)
      ans++;
    else {
      will_block[a[i]] = 1;
      blocks++;
    }
  }
  printf("%d", ans);
  return 0;
}
