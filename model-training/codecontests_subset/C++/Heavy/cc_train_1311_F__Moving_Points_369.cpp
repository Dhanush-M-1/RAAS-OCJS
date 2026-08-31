#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int INF = 1000000007;
const int MAXN = (int)2e5 + 1;
void setIO(string name) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  freopen((name + ".in").c_str(), "r", stdin);
  freopen((name + ".out").c_str(), "w", stdout);
}
pair<pair<long long, long long>, int> xv[MAXN];
long long n, BIT[MAXN], BIT2[MAXN];
void update(int x, long long val) {
  for (; x <= n; x += x & -x) {
    BIT[x] += val;
    BIT2[x]++;
  }
}
pair<long long, long long> query(int x) {
  long long sum = 0;
  long long num = 0;
  for (; x > 0; x -= x & -x) {
    sum += BIT[x];
    num += BIT2[x];
  }
  return {sum, num};
}
bool comp(pair<pair<long long, long long>, int> a,
          pair<pair<long long, long long>, int> b) {
  if (a.first.second == b.first.second) return a.first.first < b.first.first;
  return a.first.second < b.first.second;
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> xv[i].first.first;
  }
  for (int i = 0; i < n; i++) {
    cin >> xv[i].first.second;
  }
  sort(xv, xv + n);
  for (int i = 0; i < n; i++) {
    xv[i].second = i + 1;
  }
  long long ans = 0;
  sort(xv, xv + n, comp);
  for (int i = 0; i < n; i++) {
    pair<long long, long long> res = query(xv[i].second);
    ans += (res.second * xv[i].first.first - res.first);
    update(xv[i].second, xv[i].first.first);
  }
  cout << ans;
  return 0;
}
