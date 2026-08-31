#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
const long long MAXN = 1e5 + 3;
const long long inf = 2e9;
long long max(long long a, long long b) {
  if (a > b)
    return a;
  else
    return b;
}
long long min(long long a, long long b) {
  if (a < b)
    return a;
  else
    return b;
}
long long dx[] = {1, -1, 0, 0};
long long dy[] = {0, 0, -1, 1};
bool cmp(pair<long long, long long> p1, pair<long long, long long> p2) {
  if (p1.first < p2.first)
    return true;
  else if (p1.first == p2.first) {
    if (p1.second < p2.second) return true;
    return false;
  }
  return false;
}
void solve() {
  long long n;
  cin >> n;
  long long li, ri, di;
  for (long long i = (long long)0; i < (long long)n; ++i) {
    cin >> li >> ri >> di;
    long long t1 = li / di;
    long long t2 = ri / di;
    if (li % di == 0) t1--;
    t2++;
    if (t1 >= 1)
      cout << di << "\n";
    else
      cout << t2 * di << "\n";
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long nT = 1;
  for (long long i = (long long)1; i <= (long long)nT; ++i) solve();
  return 0;
}
