#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  };
  int total = 0;
  for (int i = 0; i < n; i++) {
    total += a[i];
  }
  if (total % 200 == 0 && (200 * n != total || n % 2 == 0))
    cout << "YES";
  else
    cout << "NO";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
