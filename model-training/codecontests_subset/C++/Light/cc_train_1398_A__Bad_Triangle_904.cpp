#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t, n;
  cin >> t;
  while (t--) {
    cin >> n;
    vector<long long> arr(n);
    for (int i = 0; i < n; i++) cin >> arr[i];
    int i = 0, j = i + 1, k = j + 1;
    bool flag = false;
    while (k < n) {
      if (arr[i] + arr[j] <= arr[k]) {
        cout << i + 1 << " " << j + 1 << " " << k + 1 << "\n";
        flag = true;
        break;
      }
      k++;
    }
    if (flag == false) {
      cout << "-1"
           << "\n";
    }
  }
  return 0;
}
