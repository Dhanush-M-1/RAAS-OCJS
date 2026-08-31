#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k;
  cin >> n >> k;
  int arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  int maxi = INT_MIN;
  for (int i = 0; i < n; i++) {
    if (k % arr[i] == 0) {
      if (arr[i] > maxi) maxi = arr[i];
    }
  }
  cout << k / maxi << endl;
  return 0;
}
