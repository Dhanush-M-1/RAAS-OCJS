#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 5;
long long Bit[N][2], n;
long long get(long long i, long long k) {
  long long ans = 0;
  for (i; i > 0; i -= i & (-i)) {
    ans += Bit[i][k];
  }
  return ans;
}
void update(long long i, long long val, long long k) {
  for (i; i <= n; i += i & (-i)) {
    Bit[i][k] += val;
  }
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  srand(time(NULL));
  ;
  long long k, i, t, j, m, x, y, z, c = 0, ans = 0;
  cin >> n;
  vector<pair<long long, long long> > v(n), v1(n);
  for (i = 0; i < n; i++) cin >> v[i].first;
  for (i = 0; i < n; i++) cin >> v[i].second;
  sort((v).begin(), (v).end());
  vector<long long> v0(n);
  map<long long, long long> mp;
  c = 1;
  for (i = 0; i < n; i++) {
    v1[i].first = v[i].second;
    v1[i].second = i;
  }
  sort((v1).begin(), (v1).end());
  for (i = 0; i < n; i++) {
    if (mp[v1[i].first] == 0) {
      mp[v1[i].first] = c;
      c++;
    }
    v0[v1[i].second] = mp[v1[i].first];
  }
  for (i = 0; i < n; i++) {
    x = get(v0[i], 0);
    y = get(v0[i], 1);
    ans += x * v[i].first - y;
    update(v0[i], 1, 0);
    update(v0[i], v[i].first, 1);
  }
  cout << ans;
}
