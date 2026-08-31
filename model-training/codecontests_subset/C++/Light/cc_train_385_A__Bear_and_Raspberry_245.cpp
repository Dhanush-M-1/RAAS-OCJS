#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int arr[n], maxdiff = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int j = 0; j < n - 1; j++) {
    if (arr[j] - arr[j + 1] > maxdiff) {
      maxdiff = arr[j] - arr[j + 1];
    }
  }
  if (maxdiff - m > 0)
    cout << maxdiff - m;
  else
    cout << 0;
  return 0;
}
