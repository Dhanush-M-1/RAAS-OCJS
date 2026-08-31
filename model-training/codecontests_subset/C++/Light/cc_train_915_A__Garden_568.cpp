#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int j, n, i, a = 0, b = 0, c = 0;
  cin >> n >> a;
  long long int arr[n];
  for (i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + n);
  for (i = 0; i < n; i++) {
    if (a % arr[i] == 0) {
      c = (a / arr[i]);
    }
  }
  cout << c << endl;
}
