#include <bits/stdc++.h>
using namespace std;
const long long int inf = LLONG_MAX;
const long long int mod = 1e9 + 7;
const long double pi = acos(-1);
void solution() {
  long long int n;
  cin >> n;
  long long int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  long long int ans = a[0] + a[1];
  for (int i = 2; i < n; i++) {
    if (a[i] >= ans) {
      cout << 1 << " " << 2 << " " << i + 1;
      return;
    }
  }
  cout << "-1";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long int t;
  t = 1;
  cin >> t;
  while (t--) {
    solution();
    cout << "\n";
  }
  return 0;
}
