#include <bits/stdc++.h>
using namespace std;
pair<int, long long> a[200005];
int t[200005];
map<int, int> M;
pair<int, long long> f[200005];
int n;
void update(int gt) {
  int x = M[gt];
  while (x <= n) {
    f[x] = {f[x].first + 1, f[x].second + gt};
    x += (x & -x);
  }
}
pair<int, long long> get(int x) {
  int cnt = 0;
  long long sum = 0;
  while (x >= 1) {
    cnt += f[x].first;
    sum += f[x].second;
    x -= (x & -x);
  }
  return make_pair(cnt, sum);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].second;
    t[i] = a[i].second;
  }
  for (int i = 1; i <= n; i++) cin >> a[i].first;
  sort(a + 1, a + n + 1);
  sort(t + 1, t + n + 1);
  for (int i = 1; i <= n; i++) M[t[i]] = i;
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    pair<int, long long> res;
    res = get(M[a[i].second] - 1);
    ans += (1ll * a[i].second * res.first - res.second);
    update(a[i].second);
  }
  cout << ans;
}
