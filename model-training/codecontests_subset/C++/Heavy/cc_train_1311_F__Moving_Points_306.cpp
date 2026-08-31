#include <bits/stdc++.h>
int dr[] = {2, 2, -2, -2, 1, -1, 1, -1};
int dc[] = {1, -1, 1, -1, 2, 2, -2, -2};
int dr1[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dc1[] = {1, -1, 1, 0, -1, 0, 1, -1};
int dr2[] = {0, 0, 1, -1};
int dc2[] = {1, -1, 0, 0};
using namespace std;
long long a[200005];
long long dp[200005];
long long tr[2][200005];
void update(long long f, long long x, long long val) {
  while (x < 200005) {
    tr[f][x] += val;
    x += x & (-x);
  }
}
long long query(long long f, long long x) {
  long long s = 0;
  while (x > 0) {
    s += tr[f][x];
    x -= x & (-x);
  }
  return s;
}
int main() {
  long long n, i, j;
  string t;
  while (cin >> n) {
    for (i = 1; i <= n; i++) cin >> a[i];
    vector<pair<long long, long long> > v;
    map<long long, long long> mp;
    for (i = 1; i <= n; i++) {
      long long x;
      cin >> x;
      v.push_back(make_pair(a[i], x));
      mp[x];
    }
    map<long long, long long>::iterator it;
    sort(v.begin(), v.end());
    long long cn = 0;
    for (it = mp.begin(); it != mp.end(); it++) it->second = ++cn;
    long long ans = 0;
    reverse(v.begin(), v.end());
    for (i = 0; i < v.size(); i++) {
      long long p = v[i].first;
      long long q = mp[v[i].second];
      long long r = query(0, cn) - query(0, q - 1);
      long long r1 = query(1, cn) - query(1, q - 1);
      update(0, q, 1);
      update(1, q, p);
      ans += (r1 - p * r);
    }
    cout << ans << endl;
  }
  return 0;
}
