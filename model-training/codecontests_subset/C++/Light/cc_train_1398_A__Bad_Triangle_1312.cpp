#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  int t, n;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n;
    unsigned long long int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    if (arr[0] + arr[1] <= arr[n - 1]) {
      cout << 1 << " " << 2 << " " << n << "\n";
    } else {
      cout << "-1\n";
    }
  }
  return 0;
}
