#include <bits/stdc++.h>
using namespace std;
int n, all[100008];
int c;
int main() {
  int ans = 0;
  scanf("%d%d", &n, &c);
  for (int i = 0; i < n; i++) scanf("%d", &all[i]);
  for (int i = 0; i < n - 1; i++) {
    ans = max(ans, all[i] - all[i + 1] - c);
  }
  cout << ans;
}
