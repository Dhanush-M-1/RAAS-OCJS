#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  long long printed = 0;
  long long num = 0;
  while (printed < l) {
    num++;
    printed += (2 * (n - num));
    if (num == n - 1) {
      break;
    }
  }
  printed -= 2 * (n - num);
  num--;
  vector<int> nums;
  while (nums.size() < r - printed) {
    for (int q = num + 2; q <= n; q++) {
      nums.push_back(num + 1);
      nums.push_back(q);
    }
    num++;
    if (num == n - 1) {
      nums.push_back(1);
    }
  }
  for (int q = l - printed - 1; q <= r - printed - 1; q++) {
    cout << nums[q] << " ";
  }
  cout << "\n";
}
int main() {
  int t;
  cin >> t;
  for (int q = 0; q < t; q++) {
    solve();
  }
  return 0;
}
