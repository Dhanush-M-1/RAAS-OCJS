#include <bits/stdc++.h>
using namespace std;
const long long PI = acosl(-1.0);
const long long xx = 1e6;
pair<pair<int, int>, pair<int, int>> arr[xx] = {};
int n;
long long a[xx] = {};
set<long long> s;
long long ps[xx] = {};
void buildbst(int begin, int end, long long small, long long big, int pos) {
  if (begin > end) return;
  if (begin == end) {
    s.insert(a[begin]);
    return;
  }
  if (small == big) {
    s.insert(ps[end] - ps[begin - 1]);
    return;
  }
  long long mid = (small + big) / 2;
  long long po = upper_bound(a, a + n + 1, mid) - a;
  s.insert(ps[end] - ps[begin - 1]);
  buildbst(begin, po - 1, small, a[po - 1], 2 * pos);
  buildbst(po, end, a[po], big, 2 * pos + 1);
}
void solve() {
  int n, m;
  cin >> n >> m;
  int a[1001] = {};
  int b[1001] = {};
  int t;
  for (long long i = 0; i < n; i++) {
    cin >> t;
    a[t]++;
  }
  for (long long i = 0; i < m; i++) {
    cin >> t;
    b[t]++;
  }
  for (long long i = 0; i < 1001; i++) {
    if (a[i] > 0 && b[i] > 0) {
      cout << "YES"
           << "\n";
      cout << 1 << " " << i << "\n";
      return;
    }
  }
  cout << "NO"
       << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  cin >> t;
  for (long long i = 0; i < t; i++) {
    solve();
  }
}
