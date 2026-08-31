#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5;
long long a[maxn], sum[maxn], d_sum[maxn];
long long n, d;
long long get(int l, int r) { return sum[r] - sum[l - 1]; }
vector<int> c;
int main() {
  cin >> n >> d;
  int cnt = 0;
  bool ok = true;
  sum[0] = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    sum[i] = sum[i - 1] + a[i];
    if (sum[i] > d) ok = false;
    if (a[i] == 0) c.push_back(i);
  }
  long long MAX = 1e18 + 5;
  for (int i = n; i >= 0; i--) {
    d_sum[i] = min(MAX, d - sum[i]);
    MAX = min(MAX, d_sum[i]);
  }
  long long s = 0;
  for (int i = 0; i < c.size(); i++) {
    int idx = c[i];
    if (idx == 0) continue;
    sum[idx] += s;
    if (sum[idx] < 0) {
      cnt++;
      sum[idx] += d_sum[idx] - s;
      if (sum[idx] < 0) ok = false;
      s = d_sum[idx];
    }
  }
  if (!ok)
    cout << -1 << endl;
  else
    cout << cnt << endl;
  return 0;
}
