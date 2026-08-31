#include <bits/stdc++.h>
using namespace std;
bool check(long long a, long long b, long long c) {
  int f = 0;
  if ((a + b) > c) f = 1;
  if ((b + c) > a) f++;
  if ((c + a) > b) f++;
  if (f == 3)
    return false;
  else
    return true;
}
void solve() {
  int n;
  cin >> n;
  int i;
  long long arr[n];
  for (i = 0; i < n; i++) {
    cin >> arr[i];
  }
  if (check(arr[0], arr[1], arr[n - 1])) {
    cout << 1 << " " << 2 << " " << n << endl;
    return;
  }
  cout << "-1\n";
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
