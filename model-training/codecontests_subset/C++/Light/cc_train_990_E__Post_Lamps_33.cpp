#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
const int N = 1e6 + 20;
vector<int> v[N];
map<int, int> mp, ml, mr;
long long n, m, k, a[N], b[N], f[N];
int num[N];
long long did[N];
string s;
long long s1, s2, ans, flag, tot, t, sum;
int cnt;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k;
  long long x;
  for (int i = 0; i < m; i++) {
    cin >> x;
    if (x == 0) return cout << -1, 0;
    did[x] = 1;
  }
  for (int i = 1; i <= k; i++) cin >> a[i];
  int cnt = 0;
  for (int i = 0; i <= n; i++) {
    if (did[i])
      num[i] = num[i - 1] + 1;
    else
      num[i] = 0;
    cnt = max(cnt, num[i]);
  }
  long long ans = inf;
  for (int i = cnt + 1; i <= k; i++) {
    long long sum = 0;
    for (int j = 0; j < n; j += i) {
      if (did[j]) {
        j -= num[j];
      }
      sum++;
    }
    ans = min(ans, a[i] * sum);
  }
  if (ans >= inf)
    cout << -1;
  else
    cout << ans << endl;
}
