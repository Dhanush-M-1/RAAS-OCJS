#include <bits/stdc++.h>
using namespace std;
vector<long long> v;
pair<long long, long long> p;
map<long long, long long> mp;
set<long long> st;
deque<long long> dq;
priority_queue<long long> pq;
long long mn = INT_MAX, mx = INT_MIN;
long long n, m, tc, i, j, tmp, q, sum, cn, ans, res, pos, flag, l, x, k, dif;
string s, str;
long long pre = 1e15;
long long now = -1e17;
long long a[2000007], b[2000007];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  if (n >= 2)
    ans = 2;
  else
    ans = 1;
  for (i = 0; i < n; i++) cin >> a[i] >> b[i];
  for (i = 1; i < n - 1; i++) {
    if (a[i] - b[i] > a[i - 1])
      ans++;
    else if (a[i] + b[i] < a[i + 1]) {
      a[i] += b[i];
      ans++;
    }
  }
  cout << ans;
  return 0;
}
