#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  if (n < 1 || k > 100) {
    return 0;
  }
  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] < 1 || a[i] > 100) {
      return 0;
    }
  }
  sort(a.begin(), a.end());
  for (int j = n - 1; j >= 0; j--) {
    if (k % a[j] == 0) {
      cout << k / a[j] << endl;
      break;
    }
  }
  return 0;
}
