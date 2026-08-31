#include <bits/stdc++.h>
using namespace std;
long long dif(long long a, long long b) {
  if (a > b)
    return a - b;
  else
    return b - a;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  long long n, k;
  cin >> n >> k;
  long long arr[n][3], a = 0, b = 0, c = k, d = k, ans = 0;
  vector<long long> p, q, r;
  for (long long i = 0; i < n; i++) {
    cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
    if (arr[i][1] == 1) a++;
    if (arr[i][2] == 1) b++;
    if (arr[i][1] == 1 && arr[i][2] == 1) {
      p.push_back(arr[i][0]);
    } else if (arr[i][1] == 1)
      q.push_back(arr[i][0]);
    else if (arr[i][2] == 1)
      r.push_back(arr[i][0]);
  }
  if (a < k || b < k) {
    cout << -1;
    return 0;
  }
  sort(q.begin(), q.end());
  sort(r.begin(), r.end());
  for (long long i = 0; i < min(q.size(), r.size()); i++) {
    p.push_back(q[i] + r[i]);
  }
  sort(p.begin(), p.end());
  for (long long i = 0; i < k; i++) ans += p[i];
  cout << ans << "\n";
  return 0;
}
