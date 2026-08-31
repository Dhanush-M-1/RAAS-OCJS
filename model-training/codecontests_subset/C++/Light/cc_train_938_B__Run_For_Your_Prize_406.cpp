#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
int n, res = 1e6 - 1;
int arr[N];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> arr[i];
  }
  arr[n] = 1e6;
  res = 1000000 - arr[0];
  for (int i = 0; i < n; ++i) {
    res = min(res, max(arr[i] - 1, 1000000 - arr[i + 1]));
  }
  cout << res << "\n";
  return 0;
}
