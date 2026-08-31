#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> k >> n;
  vector<int> a(k);
  for (int i = 0; i < k; ++i) cin >> a[i];
  sort(a.begin(), a.end());
  for (int i = k - 1; i >= 0; --i) {
    if (n % a[i] == 0) {
      cout << n / a[i];
      return 0;
    }
  }
  return 0;
}
