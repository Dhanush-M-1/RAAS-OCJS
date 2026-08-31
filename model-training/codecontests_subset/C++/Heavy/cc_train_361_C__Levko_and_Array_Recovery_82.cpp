#include <bits/stdc++.h>
using namespace std;
const int N = 5e3 + 9;
int inc[N], arr[N];
int a[N], b[N], c[N], d[N], sum[N];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) inc[i] = 1000000001;
  for (int i = 0; i < m; ++i) {
    cin >> a[i] >> b[i] >> c[i] >> d[i];
    if (a[i] == 1) {
      for (int j = b[i]; j <= c[i]; ++j) {
        sum[j] += d[i];
      }
      continue;
    }
    for (int j = b[i]; j <= c[i]; ++j) {
      inc[j] = min(inc[j], d[i] - sum[j]);
    }
  }
  for (int i = 1; i <= n; ++i) {
    sum[i] = 0;
    if (inc[i] == 1000000001) inc[i] = 0;
  }
  for (int i = 0; i < m; ++i) {
    if (a[i] == 1) {
      for (int j = b[i]; j <= c[i]; ++j) {
        sum[j] += d[i];
      }
    } else {
      int cnt = 0;
      for (int j = b[i]; j <= c[i]; ++j) {
        if (sum[j] + inc[j] > d[i]) {
          cout << "NO\n";
          return 0;
        }
        if (sum[j] + inc[j] < d[i]) ++cnt;
      }
      if (cnt == c[i] - b[i] + 1) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; ++i) {
    cout << inc[i] << " ";
  }
  return 0;
}
