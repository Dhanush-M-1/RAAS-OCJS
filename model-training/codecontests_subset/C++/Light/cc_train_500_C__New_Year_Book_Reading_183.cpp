#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, m;
  scanf("%d%d", &n, &m);
  vector<int> w(n);
  for (int i(0), _l((int)(n)-1); i <= _l; ++i) scanf("%d", &w[i]);
  vector<int> order(m);
  long long ans(0);
  for (int i(0), _l((int)(m)-1); i <= _l; ++i) {
    scanf("%d", &order[i]);
    set<int> SET;
    for (int j = i - 1; j >= 0 && order[j] != order[i]; --j) {
      SET.insert(order[j]);
    }
    long long tw(0);
    for (int q : SET) {
      tw += w[q - 1];
    }
    ans += tw;
  }
  cout << ans << endl;
}
int main() {
  solve();
  return 0;
}
