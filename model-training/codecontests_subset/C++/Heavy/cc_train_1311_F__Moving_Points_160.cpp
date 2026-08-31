#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
void update(vector<long long>& v, long long ind, long long val) {
  ind++;
  long long n = v.size();
  while (ind <= n) {
    v[ind] += val;
    ind += ((ind) & (-ind));
  }
}
long long query(vector<long long>& v, long long ind) {
  ind++;
  long long res = 0;
  while (ind > 0) {
    res += v[ind];
    ind -= ((ind) & (-ind));
  }
  return res;
}
void solve() {
  long long n;
  cin >> n;
  vector<pair<long long, long long>> points(n);
  for (long long i = 0; i < n; i++) cin >> points[i].first;
  vector<long long> vel;
  for (long long i = 0; i < n; i++) {
    cin >> points[i].second;
    vel.push_back(points[i].second);
  }
  sort((vel).begin(), (vel).end());
  sort((points).begin(), (points).end());
  vel.resize(unique((vel).begin(), (vel).end()) - vel.begin());
  vector<long long> no(vel.size() + 1, 0), csum(vel.size() + 1, 0);
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    long long v_new =
        lower_bound(vel.begin(), vel.end(), points[i].second) - vel.begin();
    ans += -(query(csum, v_new)) + (points[i].first * query(no, v_new));
    update(csum, v_new, points[i].first);
    update(no, v_new, 1);
  }
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  solve();
}
