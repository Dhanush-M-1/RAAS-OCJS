#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
long long positions[maxn], speeds[maxn];
pair<long long, long long> pairs[maxn];
map<long long, long long> m;
bool comp(pair<long long, long long>& a, pair<long long, long long>& b) {
  if (a.second == b.second) return a.first < b.first;
  return a.second < b.second;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> positions[i];
  for (int i = 0; i < n; ++i) cin >> speeds[i];
  for (long long i = 0; i < n; ++i) pairs[i] = {positions[i], speeds[i]};
  sort(positions, positions + n);
  sort(pairs, pairs + n, comp);
  long long ans = 0;
  for (long long i = 0; i < n; ++i) {
    ans += ((2 * i) - n + 1) * positions[i];
    m[positions[i]] = i;
  }
  for (int i = 0; i < n; ++i) ans -= pairs[i].first * (m[pairs[i].first] - i);
  cout << ans;
}
