#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  vector<long long int> arr(n);
  long long int minval = INT_MIN;
  for (int i = 0; i < n; ++i) {
    cin >> arr[i];
    minval = max(minval, min(abs(arr[i] - 1), abs(1000000 - arr[i])));
  }
  cout << minval << endl;
  return 0;
}
