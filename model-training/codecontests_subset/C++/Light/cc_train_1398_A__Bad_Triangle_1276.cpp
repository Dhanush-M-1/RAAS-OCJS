#include <bits/stdc++.h>
using namespace std;
void think() {
  long long n;
  cin >> n;
  vector<long long> a(n, 0);
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
  }
  if (a[0] + a[1] <= a[n - 1]) {
    cout << 1 << " " << 2 << " " << n << "\n";
  } else {
    cout << -1 << "\n";
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  long long testcase = 1;
  cin >> testcase;
  while (testcase--) {
    think();
  }
  return 0;
}
