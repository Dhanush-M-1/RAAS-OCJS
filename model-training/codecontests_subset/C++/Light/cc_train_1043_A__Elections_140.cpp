#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 5;
long long n, k, sum2, sum1;
int main() {
  cin >> n;
  int arr[n];
  int maxi = INT_MIN;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    sum2 += arr[i];
    maxi = max(maxi, arr[i]);
  }
  k = maxi;
  while (true) {
    sum1 = 0;
    for (int i = 0; i < n; i++) sum1 += k - arr[i];
    if (sum1 > sum2)
      break;
    else
      k++;
  }
  cout << k << endl;
  return 0;
}
