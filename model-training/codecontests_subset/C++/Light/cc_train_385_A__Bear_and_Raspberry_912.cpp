#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, arr[100], max, i, c;
  cin >> n;
  cin >> c;
  for (i = 0; i < n; i++) {
    cin >> arr[i];
  }
  max = arr[0] - arr[1];
  for (i = 0; i < (n - 1); i++) {
    if ((arr[i] - arr[i + 1]) > max) {
      max = arr[i] - arr[i + 1];
    }
  }
  if (max >= c) {
    cout << (max - c);
  } else
    cout << "0";
  return 0;
}
