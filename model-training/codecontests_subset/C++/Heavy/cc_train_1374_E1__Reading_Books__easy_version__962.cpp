#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
struct indices {
  int i11, i10, i01, i00;
};
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<long long int, int> > v11, v10, v01, v00;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a && b)
      v11.push_back(pair<long long int, int>(t, i + 1));
    else if (a)
      v10.push_back(pair<long long int, int>(t, i + 1));
    else if (b)
      v01.push_back(pair<long long int, int>(t, i + 1));
    else
      v00.push_back(pair<long long int, int>(t, i + 1));
  }
  sort(v11.begin(), v11.end());
  sort(v10.begin(), v10.end());
  sort(v01.begin(), v01.end());
  sort(v00.begin(), v00.end());
  if ((int)v11.size() + min((int)v10.size(), (int)v01.size()) < k) {
    cout << -1 << '\n';
    return 0;
  }
  indices res;
  res.i11 = res.i10 = res.i01 = res.i00 = -1;
  long long int ans = 1e15;
  int b = 0, c = 0, d = 0;
  long long int acum = 0ll;
  for (auto e : v11) {
    acum += e.first;
  }
  long long int sum = acum;
  for (int a = (int)v11.size(); a >= 0; a--) {
    while (a + b < k && b < (int)v10.size()) {
      sum += v10[b].first;
      b++;
    }
    while (a + c < k && c < (int)v01.size()) {
      sum += v01[c].first;
      c++;
    }
    if (a + b + c + d > m) {
      if (d) {
        sum -= v00[d - 1].first;
        d--;
      }
    }
    int faltan = m - (a + b + c + d);
    bool can = true;
    for (int i = 0; i < faltan; i++) {
      int costb = inf, costc = inf, costd = inf;
      if (b < (int)v10.size()) {
        costb = v10[b].first;
      }
      if (c < (int)v01.size()) {
        costc = v01[c].first;
      }
      if (d < (int)v00.size()) {
        costd = v00[d].first;
      }
      if (min({costb, costc, costd}) == inf) {
        can = false;
        break;
      }
      if (costb <= costc && costb <= costd && costb != inf) {
        sum += costb;
        b++;
      } else if (costc <= costb && costc <= costd && costc != inf) {
        sum += costc;
        c++;
      } else {
        sum += costd;
        d++;
      }
    }
    if (can) {
      if (a + b >= k && a + c >= k && (a + b + c + d) == m && sum < ans) {
        ans = sum;
        res.i11 = a;
        res.i10 = b;
        res.i01 = c;
        res.i00 = d;
      }
    }
    if (a) sum -= v11[a - 1].first;
  }
  if (res.i11 < 0) {
    cout << -1 << '\n';
    return 0;
  }
  cout << ans << '\n';
  for (int i = 0; i < res.i11; i++) cout << v11[i].second << " ";
  for (int i = 0; i < res.i10; i++) cout << v10[i].second << " ";
  for (int i = 0; i < res.i01; i++) cout << v01[i].second << " ";
  for (int i = 0; i < res.i00; i++) cout << v00[i].second << " ";
  cout << '\n';
  return 0;
}
