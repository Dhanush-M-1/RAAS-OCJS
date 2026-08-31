#include <bits/stdc++.h>
using namespace std;
const long long max_n = 1000000000;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    sort(arr, arr + n);
    int a = arr[0];
    int b = arr[1];
    int c = arr[n - 1];
    if (arr[0] + arr[1] <= arr[n - 1]) {
      cout << 1 << " " << 2 << " " << n << endl;
    } else {
      cout << -1 << endl;
    }
  }
}
