#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  long long a[n], x;
  unordered_map<long long, long long> checka, checkb, checkc;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    checka[a[i]] += 1;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    checkb[x] += 1;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    checkc[x] += 1;
  }
  for (int i = 0; i < n; i++) {
    if (checka[a[i]] != checkb[a[i]]) {
      cout << a[i] << '\n';
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (checkb[a[i]] != checkc[a[i]]) {
      cout << a[i];
      break;
    }
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int test = 1;
  while (test--) {
    solve();
    cout << '\n';
  }
  return 0;
}
