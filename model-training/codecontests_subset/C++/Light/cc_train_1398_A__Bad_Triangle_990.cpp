#include <bits/stdc++.h>
using namespace std;
int main(void) {
  long long int test, n, i;
  cin >> test;
  while (test--) {
    cin >> n;
    long long int arr[n];
    for (i = 0; i < n; i++) {
      cin >> arr[i];
    }
    if (arr[0] + arr[1] > arr[n - 1])
      cout << -1 << endl;
    else
      cout << 1 << " " << 2 << " " << n << endl;
  }
}
