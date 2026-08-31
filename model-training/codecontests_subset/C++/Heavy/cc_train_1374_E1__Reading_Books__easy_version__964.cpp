#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
long long dx[] = {-1, 0, 1, 0};
long long dy[] = {0, -1, 0, 1};
vector<pair<long long, long long> > v[4];
long long n, m, k;
vector<long long> uttar;
bool check = false;
long long call(long long x) {
  check = false;
  if (x > m) {
    check = true;
    return INT_MAX;
  }
  long long res = 0;
  uttar.clear();
  for (long long i = 0; i < x; i++) {
    res += v[3][i].first;
    uttar.push_back(v[3][i].second);
  }
  long long rem = m - x;
  vector<pair<long long, long long> > baki;
  if (x < k) {
    long long bacha = k - x;
    if (v[1].size() < bacha || v[2].size() < bacha || rem < bacha * 2) {
      check = true;
      return INT_MAX - x;
    }
    rem -= bacha * 2;
    for (long long i = 0; i < bacha; i++) {
      uttar.push_back(v[1][i].second);
      uttar.push_back(v[2][i].second);
      res += v[1][i].first;
      res += v[2][i].first;
    }
    for (long long i = 1; i <= 2; i++)
      for (long long j = bacha; j < v[i].size(); j++) {
        baki.push_back(v[i][j]);
      }
    for (auto i : v[0]) baki.push_back(i);
  } else {
    for (long long i = 1; i <= 2; i++)
      for (auto j : v[i]) {
        baki.push_back(j);
      }
    for (auto j : v[0]) baki.push_back(j);
  }
  sort(baki.begin(), baki.end());
  if (baki.size() < rem) {
    check = true;
    return INT_MAX - x;
  }
  for (long long i = 0; i < rem; i++) {
    uttar.push_back(baki[i].second);
    res += baki[i].first;
  }
  return res;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (long long i = 0; i < n; i++) {
    long long t, x, y;
    cin >> t >> x >> y;
    if (x && y)
      v[3].push_back({t, i});
    else if (x) {
      v[2].push_back({t, i});
    } else if (y)
      v[1].push_back({t, i});
    else
      v[0].push_back({t, i});
  }
  for (long long i = 0; i < 4; i++) {
    sort(v[i].begin(), v[i].end());
  }
  long long s = -1, e = min(m, (long long)v[3].size());
  while (e - s > 1) {
    long long mid1 = (s + e) >> 1;
    long long mid2 = mid1 + 1;
    if (call(mid1) > call(mid2))
      s = mid1;
    else
      e = mid1;
  }
  long long ans = call(e);
  if (check) {
    cout << "-1"
         << "\n";
    return 0;
  }
  cout << ans << "\n";
  for (auto i : uttar) cout << i + 1 << " ";
  cout << "\n";
}
