#include <bits/stdc++.h>
using namespace std;
int n;
void solve() {
  int i, j, x, sum = 0, a;
  vector<int> ans;
  map<int, int> m, m1;
  map<int, int>::iterator it;
  for (i = 0; i < n; i++) {
    scanf("%d", &a);
    m[a]++;
    sum += a;
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &a);
    m1[a]++;
  }
  for (it = m.begin(); it != m.end(); it++) {
    if (it->second - m1[it->first] == 1) {
      ans.push_back(it->first);
    }
  }
  x = 0;
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &a);
    x += a;
  }
  printf("%d\n%d", ans[0], sum - x - ans[0]);
  return;
}
int main() {
  scanf("%d", &n);
  solve();
  return 0;
}
