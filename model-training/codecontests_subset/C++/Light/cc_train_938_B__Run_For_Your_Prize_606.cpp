#include <bits/stdc++.h>
using namespace std;
void ggg() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
}
const int INF = 10e6;
const int N = 1e6;
int main() {
  ggg();
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int ans = 0;
  for (int i = 0; i < n; i++) {
    a[i] = min(a[i] - 1, N - a[i]);
  }
  for (int i = 0; i < n; i++) {
    if (a[i] > ans) ans = a[i];
  }
  cout << ans << endl;
  return 0;
}
