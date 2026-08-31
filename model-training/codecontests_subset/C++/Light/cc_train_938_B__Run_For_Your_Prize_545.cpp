#include <bits/stdc++.h>
using namespace std;
int search(int arr[], int n) {
  for (int i = 0; i < n; ++i) {
    if (arr[i] > 500000) return i;
  }
  return -1;
}
int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  int t = search(a, n);
  int ans;
  if (t >= 0) {
    if (t == 0)
      ans = (1000000 - a[t]);
    else
      ans = max(1000000 - a[t], a[t - 1] - 1);
  } else
    ans = a[n - 1] - 1;
  cout << ans;
  return 0;
}
