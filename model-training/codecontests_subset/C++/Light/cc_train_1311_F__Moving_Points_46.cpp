#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int x[N];
long long ans;
pair<int, int> a[N];
int main(void) {
  std::ios::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i].second, x[i] = a[i].second;
  for (int i = 0; i < n; i++) cin >> a[i].first;
  sort(a, a + n), sort(x, x + n);
  for (int i = 0; i < n; i++)
    ans += (long long)(lower_bound(x, x + n, a[i].second) - x - n + 1 + i) *
           a[i].second;
  cout << ans << endl;
  return 0;
}
