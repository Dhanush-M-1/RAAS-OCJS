#include <bits/stdc++.h>
using namespace std;
const long double epsylon = 1e-9;
const std::string PROGRAM_NAME = "ivo";
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<char> a(n + 1, 0);
  for (int i = 0; i < m; ++i) {
    int x;
    scanf("%d", &x);
    a[x] = 1;
  }
  a[n] = 1;
  int worst = 0;
  int cur = 0;
  for (int i = 0; i < n; ++i) {
    if (a[i]) {
      cur++;
      worst = max(worst, cur);
    } else {
      cur = 0;
    }
  }
  if (worst > k || a[0]) {
    cout << -1 << endl;
    return 0;
  }
  vector<long long> costs(k);
  for (int i = 0; i < (int)costs.size(); ++i) {
    int temp;
    scanf("%d", &temp);
    costs[i] = temp;
  }
  vector<int> prev(n + 1);
  prev[0] = 0;
  int last_good = 0;
  for (int i = 1; i <= n; ++i) {
    if (a[i] == 0) {
      last_good = i;
      prev[i] = i;
    } else {
      prev[i] = last_good;
    }
  }
  long long best = -1;
  for (int step = worst + 1; step <= k; ++step) {
    long long total = 0;
    long long cur = 0;
    while (cur < n) {
      total += costs[step - 1];
      cur += step;
      if (cur < n && a[cur]) {
        cur = prev[cur];
      }
    }
    if (best == -1 || total < best) {
      best = total;
    }
  }
  cout << best << endl;
  return 0;
}
