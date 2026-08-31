#include <bits/stdc++.h>
using namespace std;
long long query(vector<long long>& ft, int pos) {
  long long ans = 0;
  while (pos > 0) {
    ans += ft[pos - 1];
    pos -= (pos & (-pos));
  }
  return ans;
}
void update(vector<long long>& ft, int pos, long long val, int& ceil) {
  while (pos <= ceil) {
    ft[pos - 1] += val;
    pos += (pos & (-pos));
  }
}
int main() {
  int n;
  cin >> n;
  vector<pair<int, int>> p(n);
  vector<int> v(n);
  for (int i = 0; i < n; i++) cin >> p[i].first;
  for (int i = 0; i < n; i++) {
    cin >> p[i].second;
    v[i] = p[i].second;
  }
  sort(p.begin(), p.end());
  sort(v.begin(), v.end());
  v.resize(unique(v.begin(), v.end()) - v.begin());
  int ceil = v.size();
  vector<long long> ftx(ceil), ftc(ceil);
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    int pos = lower_bound(v.begin(), v.end(), p[i].second) - v.begin();
    ans += query(ftc, pos + 1) * (1ll * p[i].first) - query(ftx, pos + 1);
    update(ftc, pos + 1, 1, ceil);
    update(ftx, pos + 1, p[i].first, ceil);
  }
  cout << ans << endl;
  return 0;
}
