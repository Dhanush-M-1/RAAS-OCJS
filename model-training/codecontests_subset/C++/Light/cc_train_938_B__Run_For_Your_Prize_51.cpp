#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long arr[n];
  for (long long i = 0; i < n; i++) cin >> arr[i];
  sort(arr, arr + n);
  long long pos = -1;
  long long mx = 1000000;
  for (long long i = 0; i < n; i++) {
    if (arr[i] - 1 > mx - arr[i]) {
      if (i > 0)
        cout << max(arr[i - 1] - 1, mx - arr[i]) << endl;
      else
        cout << mx - arr[i] << endl;
      return 0;
    }
  }
  cout << arr[n - 1] - 1 << endl;
}
