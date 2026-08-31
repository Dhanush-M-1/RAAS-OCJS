#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
const int modpro = 988244353;
const int di[8] = {-1, 0, 1, 0, -1, 1, 1, -1},
          dj[8] = {0, 1, 0, -1, 1, 1, -1, -1};
void solve() {
  int n;
  cin >> n;
  vector<long long int> x(n), h(n);
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  if (n == 1) {
    cout << 1;
    return;
  }
  int count = 2;
  long long int left = x[0];
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > left)
      count++, left = x[i];
    else if (x[i] + h[i] < x[i + 1])
      count++, left = x[i] + h[i];
    else
      left = x[i];
  }
  cout << count;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  cerr << "\n" << 1000 * ((double)clock()) / (double)CLOCKS_PER_SEC << " ms\n";
}
