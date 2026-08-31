#include <bits/stdc++.h>
using namespace std;
float PHI = 1.6180339;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout << fixed << setprecision(9);
  long long n;
  cin >> n;
  long long arr[n + 10];
  for (long long i = 0; i < n; i++) {
    cin >> arr[i];
  }
  long long tot = 0;
  long long first = 1;
  long long last = 1000000;
  long long j = n - 1;
  long long ans = INT_MIN;
  for (long long i = 0; i <= n - 1; i++) {
    long long diff1 = abs(arr[i] - first);
    long long diff2 = abs(arr[i] - last);
    long long diff3 = abs(arr[j] - first);
    long long diff4 = abs(arr[j] - last);
    ans = max(ans, min((arr[i] - 1), last - arr[i]));
  }
  cout << ans << "\n";
}
