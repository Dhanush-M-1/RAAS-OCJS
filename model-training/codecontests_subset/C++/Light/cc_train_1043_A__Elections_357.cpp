#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long TESTS = 1;
  while (TESTS--) {
    long long n;
    cin >> n;
    long long a[n];
    for (long long int i = 0; i < n; i++) cin >> a[i];
    long long s = 0;
    sort(a, a + n);
    for (long long int i = 0; i < n; i++) s += a[i];
    cout << max(a[n - 1], (long long)floor((s * 2.0) / n + 1));
  }
  return 0;
}
