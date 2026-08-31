#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, arr[50005];
  cin >> t;
  for (int i = 0; i < t; i++) {
    int x = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    if (arr[0] + arr[1] <= arr[n - 1]) {
      cout << "1"
           << " "
           << "2"
           << " " << n << "\n";
    } else
      cout << "-1"
           << "\n";
  }
}
