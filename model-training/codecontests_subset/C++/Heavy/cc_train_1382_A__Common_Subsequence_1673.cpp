#include <bits/stdc++.h>
using namespace std;
vector<int> graph[200001];
vector<int> visit;
long long int power(int n) {
  if (n == 0) return 1;
  if (n == 1) return 2;
  if (n % 2)
    return ((((power(n / 2)) % 1000000007) * (power(n / 2) % 1000000007) %
             1000000007) *
            2) %
           1000000007;
  return (((power(n / 2)) % 1000000007) * (power(n / 2) % 1000000007) %
          1000000007);
}
void solve() {
  int i, n, m;
  cin >> n >> m;
  int a[1001] = {0}, b[1001] = {0};
  int arr;
  for (i = 0; i < n; i++) {
    cin >> arr;
    a[arr] = 1;
  }
  for (i = 0; i < m; i++) {
    cin >> arr;
    b[arr] = 1;
  }
  for (i = 1; i <= 1000; i++)
    if (a[i] == b[i] && a[i] == 1) {
      cout << "YES" << endl << 1 << " " << i << endl;
      return;
    }
  cout << "NO" << endl;
}
int main() {
  int t;
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
