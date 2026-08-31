#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, i;
  cin >> n >> k;
  int arr[n];
  for (i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + n);
  for (i = n - 1; i >= 0; i--) {
    if (k % arr[i] == 0) {
      cout << k / arr[i] << endl;
      goto end;
    }
  }
end:
  return 0;
}
