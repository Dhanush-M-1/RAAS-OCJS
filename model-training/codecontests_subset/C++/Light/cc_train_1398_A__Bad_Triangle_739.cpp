#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int n;
  cin >> n;
  vector<long long int> arr;
  set<long long int> s;
  for (int i = 0; i < n; i++) {
    long long int val;
    cin >> val;
    arr.push_back(val);
  }
  bool temp = false;
  long long int sum = arr[0] + arr[1];
  for (int i = 2; i < n; i++) {
    if (sum <= arr[i]) {
      temp = true;
      cout << 1 << " " << 2 << " " << i + 1 << '\n';
      break;
    }
  }
  if (!temp) {
    cout << -1 << '\n';
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
