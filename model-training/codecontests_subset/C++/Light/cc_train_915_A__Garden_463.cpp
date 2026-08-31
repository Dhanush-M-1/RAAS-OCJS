#include <bits/stdc++.h>
using namespace std;
bool used[11111];
int main() {
  cin.tie(0);
  cin.sync_with_stdio(0);
  long long n, k, ans = 0;
  cin >> n >> k;
  long long a[111111];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (k % a[i] == 0 && a[i] > ans) {
      ans = a[i];
    }
  }
  cout << k / ans;
  return 0;
}
