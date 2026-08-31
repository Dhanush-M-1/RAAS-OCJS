#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, k, l = 0;
  vector<long long> a;
  cin >> n >> k;
  a.resize(n);
  for (long long i = 0; i < n; i++) cin >> a[i];
  sort(a.begin(), a.end());
  for (long long i = n; i > -1; i--) {
    if (k % a[i] == 0) {
      cout << k / a[i];
      return 0;
    }
  }
}
