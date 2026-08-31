#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const int N = 1e5 + 10;
int a[N];
long long n, d;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> d;
  long long m = 0;
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    if (!a[i]) {
      m++;
    }
  }
  m++;
  long long maxbal[m];
  vector<long long> sum[m];
  long long acc[m];
  long long i = 0;
  long long j = 0;
  while (i != m) {
    while (a[j] != 0 && j != n) {
      sum[i].push_back(a[j]);
      j++;
    }
    j++;
    acc[i] = 0;
    if (!sum[i].empty()) {
      acc[i] = accumulate(sum[i].begin(), sum[i].end(), 0);
      if (acc[i] > d) {
        cout << -1;
        return 0;
      }
    }
    i++;
  }
  for (long long i = 0; i < m; i++) {
    for (long long j = 1; j < sum[i].size(); j++) {
      sum[i][j] += sum[i][j - 1];
    }
    sort(sum[i].begin(), sum[i].end());
    if (sum[i].empty() == false && sum[i].back() > d) {
      cout << -1;
      return 0;
    }
  }
  for (long long i = m - 2; i >= 0; i--) {
    maxbal[i] = 0;
    if (acc[i + 1] > d && i == m - 2) {
      cout << -1;
      return 0;
    }
    if (i == m - 2) {
      if (!sum[i + 1].empty() && sum[i + 1].back() <= d &&
          sum[i + 1].back() >= 0) {
        maxbal[i] = d - sum[i + 1].back();
      } else if ((!sum[i + 1].empty() && sum[i + 1].back() < 0) ||
                 sum[i + 1].empty()) {
        maxbal[i] = d;
      }
      continue;
    }
    if (!sum[i + 1].empty() && sum[i + 1].back() <= d &&
        sum[i + 1].back() >= 0) {
      if (maxbal[i + 1] - acc[i + 1] > d - sum[i + 1].back()) {
        maxbal[i] = d - sum[i + 1].back();
      } else {
        maxbal[i] = maxbal[i + 1] - acc[i + 1];
      }
    } else if (!sum[i + 1].empty() && sum[i + 1].back() < 0) {
      if (maxbal[i + 1] - sum[i + 1].back() < d) {
        maxbal[i] = maxbal[i + 1] - sum[i + 1].back();
      } else {
        maxbal[i] = d;
      }
    } else {
      maxbal[i] = maxbal[i + 1];
    }
    if (maxbal[i] > d || maxbal[i] < 0) {
      cout << -1;
      return 0;
    }
  }
  long long bal = 0;
  long long cnt = 0;
  long long k = 0;
  for (long long i = 0; i < n; i++) {
    if (a[i] != 0) {
      bal += a[i];
    } else {
      if (bal < 0) {
        bal = maxbal[k];
        cnt++;
      }
      if (bal < 0) {
        cout << -1;
        return 0;
      }
      k++;
    }
    if (bal > d) {
      cout << -1;
      return 0;
    }
  }
  cout << cnt;
  return 0;
}
