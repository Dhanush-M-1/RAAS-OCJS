#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    long long int arr[n];
    for (int j = 0; j < n; j++) {
      cin >> arr[j];
    }
    if (arr[0] + arr[1] <= arr[n - 1]) {
      cout << 1 << " " << 2 << " " << n << endl;
    } else {
      cout << -1 << endl;
    }
  }
  return 0;
}
