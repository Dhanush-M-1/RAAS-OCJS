#include <bits/stdc++.h>
using namespace std;
void IO() {}
int ar[50005];
char ch[50005];
int m, n, k, ii;
void solve() {
  scanf("%d", &n);
  vector<pair<int, int>> v;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &ar[i]);
    v.push_back({ar[i], i});
  }
  sort(v.begin(), v.end());
  if (v[0].first + v[1].first <= v[n - 1].first) {
    printf("%d %d %d\n", v[0].second, v[1].second, v[n - 1].second);
  } else
    printf("-1\n");
}
int main() {
  IO();
  int t = 1;
  scanf("%d", &t);
  while (t--) {
    solve();
  }
  return 0;
}
