#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, max = 0;
  int arr[100];
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    if (i == 1) {
      max = arr[0] - arr[1] - c;
    }
    if (arr[i - 1] - arr[i] - c > max) {
      max = arr[i - 1] - arr[i] - c;
    }
  }
  if (max <= 0)
    cout << 0;
  else
    cout << max;
  return 0;
}
