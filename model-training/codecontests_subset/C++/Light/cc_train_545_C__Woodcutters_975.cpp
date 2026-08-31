#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> arr(n);
  vector<int> indices(n);
  for (int i = 0; i < n; i++) {
    int ind, height;
    cin >> ind >> height;
    arr[i] = ind;
    indices[i] = height;
  }
  int past = 0;
  int ans = 0;
  int edge;
  for (int i = 0; i < n; i++) {
    if (i == 0 || i == n - 1) {
      ans++;
    } else {
      if (arr[i] - indices[i] > arr[i - 1]) {
        ans++;
      } else {
        if (arr[i] + indices[i] < arr[i + 1]) {
          ans++;
          arr[i] = arr[i] + indices[i];
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
