#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int arr[1000];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int diff = INT_MIN;
  int curr_i;
  for (int i = 0; i < n - 1; i++) {
    if (diff < arr[i] - arr[i + 1] - k) {
      diff = arr[i] - arr[i + 1] - k;
    }
  }
  if (diff > 0)
    cout << diff << endl;
  else
    cout << "0";
  return 0;
}
