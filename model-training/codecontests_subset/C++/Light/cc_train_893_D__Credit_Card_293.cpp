#include <bits/stdc++.h>
using namespace std;
int A[110000];
int pre[110000];
int limit[110000];
int main() {
  int n, d;
  cin >> n >> d;
  for (int i = 1; i <= n; i++) {
    cin >> A[i];
    pre[i] += A[i];
  }
  for (int i = 2; i <= n; i++) {
    pre[i] += pre[i - 1];
  }
  for (int i = n; i >= 1; i--) {
    if (i != n)
      limit[i] = min(limit[i + 1], d - pre[i]);
    else
      limit[i] = d - pre[i];
  }
  bool ok = 1;
  for (int i = 1; i <= n; i++) {
    if (limit[i] < 0) ok = 0;
    if (A[i] == 0 && (limit[i] + pre[i] < 0)) ok = 0;
  }
  if (!ok) {
    cout << -1 << endl;
  } else {
    long long tot = 0;
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (A[i] == 0 && (tot + pre[i] < 0)) ans++, tot = limit[i];
    }
    cout << ans << endl;
  }
  return 0;
}
