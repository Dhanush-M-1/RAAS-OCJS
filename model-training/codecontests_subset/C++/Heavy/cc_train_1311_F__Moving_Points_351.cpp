#include <bits/stdc++.h>
using namespace std;
const long long int N = 2e5 + 2;
struct Fenwick {
  long long int BIT[N] = {};
  void update(long long int idx, long long int val) {
    for (long long int i = idx; i < N; i += (i & -i)) {
      BIT[i] += val;
    }
  }
  long long int query(long long int k) {
    long long int sum = 0;
    for (long long int i = k; i > 0; i -= (i & -i)) {
      sum += BIT[i];
    }
    return sum;
  }
};
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int n;
  cin >> n;
  long long int x[n + 1], v[n + 1];
  vector<pair<long long int, long long int> > vp;
  for (long long int i = 1; i <= n; i++) cin >> x[i];
  vector<pair<long long int, long long int> > rr;
  for (long long int i = 1; i <= n; i++) {
    cin >> v[i];
    vp.push_back({x[i], v[i]});
  }
  sort(vp.begin(), vp.end());
  for (long long int i = 0; i < n; i++) {
    rr.push_back({vp[i].second, i});
  }
  sort(rr.begin(), rr.end());
  long long int rank = 1;
  for (auto it : rr) {
    long long int idx = it.second;
    vp[idx].second = rank++;
  }
  long long int ans = 0;
  Fenwick ob1, ob2;
  long long int leftLess[n + 5], rightBade[n + 5];
  for (long long int i = 0; i < n; i++) {
    long long int vel = vp[i].second;
    leftLess[i] = ob1.query(vel - 1);
    ob1.update(vel, 1);
  }
  for (long long int i = n - 1; i >= 0; i--) {
    long long int vel = vp[i].second;
    long long int total = n - 1 - i;
    long long int less = ob2.query(vel - 1);
    rightBade[i] = total - less;
    ob2.update(vel, 1);
  }
  for (long long int i = 0; i < n; i++) {
    long long int val = vp[i].first;
    ans += val * (leftLess[i] - rightBade[i]);
  }
  cout << ans;
}
