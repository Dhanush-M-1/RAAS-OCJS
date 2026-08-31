#include <bits/stdc++.h>
using namespace std;
long long a[100005], n;
bool t[100005];
long long sparse1[100005][20], sparse2[100005][20];
void built() {
  for (long long i = 1; i <= n; i++) {
    sparse1[i][0] = a[i];
    sparse2[i][0] = a[i];
  }
  for (long long j = 1; j < 20; j++) {
    for (long long i = 1; i <= n - (1 << j) + 1; i++) {
      sparse1[i][j] =
          max(sparse1[i][j - 1], sparse1[i + (1 << (j - 1))][j - 1]);
      sparse2[i][j] =
          min(sparse2[i][j - 1], sparse2[i + (1 << (j - 1))][j - 1]);
    }
  }
}
long long getmax(long long l, long long r) {
  long long ans = INT_MIN;
  for (long long j = 19; j >= 0; j--) {
    if (l + (1 << j) - 1 <= r) {
      ans = max(ans, sparse1[l][j]);
      l += (1 << j);
    }
  }
  return ans;
}
long long getmin(long long l, long long r) {
  long long ans = INT_MAX;
  for (long long j = 19; j >= 0; j--) {
    if (l + (1 << j) - 1 <= r) {
      ans = min(ans, sparse2[l][j]);
      l += (1 << j);
    }
  }
  return ans;
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long d = 0, l = 1, k, no = 0;
  cin >> n >> k;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    t[i] = (a[i] == 0);
    a[i] += a[i - 1];
  }
  built();
  for (long long i = 1; i <= n; i++) {
    if (d + a[i] > k) return cout << -1, 0;
    if (t[i] && a[i] + d < 0) {
      if (no == 0 || -a[i] + getmax(l, i) > k)
        l = i;
      else if (-a[i] + getmax(l, i) <= k)
        no--;
      no++;
      d = -a[i];
    }
  }
  cout << no;
}
