#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    long long arr[n];
    for (long long i = 0; i < n; i++) {
      cin >> arr[i];
    }
    vector<long long> ans;
    long long temp = arr[n - 1] - arr[0];
    long long i = 0;
    for (i = 1; i < n; i++) {
      if (arr[i] <= temp) {
        cout << "1 " << i + 1 << " " << n << "\n";
        break;
      }
    }
    if (i == n) {
      cout << "-1\n";
    }
  }
}
