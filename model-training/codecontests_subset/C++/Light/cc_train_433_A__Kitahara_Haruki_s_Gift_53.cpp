#include <bits/stdc++.h>
using namespace std;
int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
void prtn(long long i) { cout << i << "\n"; }
vector<vector<long long> > v;
bool check(vector<long long> v) {
  set<long long> s;
  for (auto i : v) s.insert(i);
  if (s.size() == 1)
    return true;
  else
    return false;
}
int dp[105][20005];
bool solve1(vector<long long> a, long long n, long long rq) {
  if (rq == 0) return true;
  if (n == 0) return false;
  if (a[n - 1] > rq)
    return dp[n][rq] = solve1(a, n - 1, rq);
  else
    return dp[n][rq] = solve1(a, n - 1, rq) || solve1(a, n - 1, rq - a[n - 1]);
}
void solve() {
  long long n;
  cin >> n;
  vector<long long> a(n);
  long long h = 0, t_h = 0, f = 0;
  for (int i = 0; i < n; i++) cin >> a[i], a[i] == 100 ? h++ : t_h++;
  if (n == 1)
    f = 0;
  else if (2 * t_h == h)
    f = 1;
  else if (t_h == 0 and h % 2 == 0)
    f = 1;
  else if (h == 0 and t_h % 2 == 0)
    f = 1;
  else if (h % 2 == 0 and t_h % 2 == 1 and h > 0)
    f = 1;
  else if (h % 2 == 0 and t_h % 2 == 0)
    f = 1;
  if (f)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
int main() {
  int t = 1;
  while (t--) {
    solve();
  }
}
