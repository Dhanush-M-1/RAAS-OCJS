#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
void solve() {
  int n;
  cin >> n;
  vector<int> arr(n);
  for (int i = 0; i < n; i++) cin >> arr[i];
  if (n >= 3 && arr[0] + arr[1] <= arr[n - 1])
    cout << "1 2 " << n << endl;
  else
    cout << "-1" << endl;
}
int main() {
  int T = 1;
  cin >> T;
  while (T--) {
    solve();
  }
  return 0;
}
