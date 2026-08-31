#include <bits/stdc++.h>
using namespace std;
void solve();
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  cerr << "time taken : " << (float)clock() / CLOCKS_PER_SEC << " secs" << endl;
  return 0;
}
int getCommon(int arr1[], int arr2[], int m, int n) {
  int i = 0, j = 0;
  while (i < m && j < n) {
    if (arr1[i] < arr2[j])
      i++;
    else if (arr2[j] < arr1[i])
      j++;
    else {
      return arr2[j];
    }
  }
  return -1;
}
void solve() {
  int n, m;
  cin >> n >> m;
  int a[n], b[m];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < m; i++) {
    cin >> b[i];
  }
  sort(a, a + n);
  sort(b, b + m);
  int ans = getCommon(a, b, n, m);
  if (ans == -1) {
    cout << "NO" << '\n';
  } else {
    cout << "YES" << '\n';
    cout << "1 " << ans << '\n';
  }
}
