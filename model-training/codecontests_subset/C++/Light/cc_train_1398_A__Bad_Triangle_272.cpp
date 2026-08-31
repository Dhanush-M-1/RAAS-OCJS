#include <bits/stdc++.h>
using namespace std;
void solve(bool& flag) {
  int n;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  if (n < 3) {
    return;
  } else {
    if (a[0] + a[1] <= a[n - 1]) {
      cout << 1 << " " << 2 << " " << n << endl;
      flag = true;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int test;
  cin >> test;
  while (test--) {
    bool flag = false;
    solve(flag);
    if (not flag) {
      cout << -1 << endl;
    }
  }
}
