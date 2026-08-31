#include <bits/stdc++.h>
#pragma GCC optimizer("O3")
#pragma GCC target("sse4")
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long int n;
    cin >> n;
    vector<long long int> a(n);
    for (long long int i = 0; i < n; i++) cin >> a[i];
    if ((a[0] + a[1]) <= a[n - 1]) {
      cout << 1 << " " << 2 << " " << n << endl;
    } else
      cout << "-1\n";
  }
}
