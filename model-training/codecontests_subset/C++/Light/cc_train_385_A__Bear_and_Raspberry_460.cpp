#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, counter = 0, profit1, profit2 = 0;
  cin >> n >> c;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i < n; i++) {
    if (arr[i] > arr[i + 1] && (arr[i] - arr[i + 1] - c > 0)) {
      profit1 = (arr[i] - arr[i + 1] - c);
      if (profit1 > profit2) {
        profit2 = profit1;
      }
    }
  }
  cout << profit2 << endl;
  return 0;
}
