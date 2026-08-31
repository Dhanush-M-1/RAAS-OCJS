#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int arr[n];
  int sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    sum = sum + arr[i];
  }
  int max = 0;
  for (int i = 0; i < n; i++) {
    if (arr[i] > max) max = arr[i];
  }
  int ans = max;
  while (n * ans <= 2 * sum) {
    ans++;
  }
  cout << ans << endl;
  return 0;
}
