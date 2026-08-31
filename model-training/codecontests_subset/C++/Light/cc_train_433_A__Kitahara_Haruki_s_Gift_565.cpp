#include <bits/stdc++.h>
using namespace std;
void striker() {
  long long n;
  cin >> n;
  long long a1 = 0, a2 = 0;
  long long arr[n];
  for (long long i = 0; i < n; i++) cin >> arr[i];
  sort(arr, arr + n, greater<long long>());
  for (long long i = 0; i < n; i++) {
    if (a1 <= a2)
      a1 += arr[i];
    else
      a2 += arr[i];
  }
  cout << (a1 == a2 ? "YES" : "NO");
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  long long t = 1;
  for (long long i = 0; i < t; i++) {
    striker();
    cout << endl;
  }
  return 0;
}
