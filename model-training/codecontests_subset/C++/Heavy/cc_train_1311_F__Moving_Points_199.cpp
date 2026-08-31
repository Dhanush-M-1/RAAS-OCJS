#include <bits/stdc++.h>
using namespace std;
const int INF32 = 1E9;
const long long INF64 = 4E18;
const long long M = 1E9 + 7;
const double EPS = 1E-9;
const double PI = 2 * acos(0);
vector<long long> suffix_sum(1E6);
bool cmp_v(pair<long long, long long> a, pair<long long, long long> b) {
  return (a.second < b.second);
}
long long solve(vector<pair<long long, long long> >& points, int start,
                int end) {
  if ((end - start) == 1) return 0;
  int mid = (start + end) / 2;
  long long d1 = solve(points, start, mid);
  long long d2 = solve(points, mid, end);
  sort(points.begin() + mid, points.begin() + end, cmp_v);
  for (int i = end - 1; i >= mid; --i) {
    suffix_sum[i] = points[i].first;
    if (i != end - 1) suffix_sum[i] += suffix_sum[i + 1];
  }
  long long d = 0;
  for (int i = start; i < mid; ++i) {
    int p = lower_bound(points.begin() + mid, points.begin() + end, points[i],
                        cmp_v) -
            points.begin();
    d += suffix_sum[p];
    d -= (end - p) * points[i].first;
  }
  return d1 + d2 + d;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<pair<long long, long long> > points(n);
  for (int i = 0; i < n; ++i) {
    cin >> points[i].first;
  }
  for (int i = 0; i < n; ++i) {
    cin >> points[i].second;
  }
  sort(points.begin(), points.end());
  cout << solve(points, 0, n) << '\n';
  return 0;
}
