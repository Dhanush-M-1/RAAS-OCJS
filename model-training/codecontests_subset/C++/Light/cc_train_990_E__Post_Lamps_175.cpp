#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<bool> pos(n, false);
  for (int i = 0; i < m; i++) {
    long long x;
    cin >> x;
    pos[x] = true;
  }
  long long mx = 0;
  long long cur = 0;
  for (long long i = 0; i < n; i++) {
    if (!pos[i])
      cur = 0;
    else {
      cur++;
      mx = max(mx, cur);
    }
  }
  vector<long long> price(k + 1);
  for (long long i = 1; i <= k; i++) {
    long long x;
    cin >> x;
    price[i] = x;
  }
  if (pos[0] || mx >= k) {
    cout << "-1";
    return 0;
  }
  long long prev[n];
  prev[0] = 0;
  for (long long i = 1; i < n; i++) {
    if (pos[i] == false)
      prev[i] = i;
    else
      prev[i] = prev[i - 1];
  }
  long long ans = 1e15;
  for (int i = mx + 1; i <= k; i++) {
    long long s = 0;
    long long cnt = 0;
    while (s < n) {
      cnt++;
      s = prev[s] + i;
    }
    ans = min(ans, cnt * price[i]);
  }
  cout << ans << endl;
  return 0;
}
