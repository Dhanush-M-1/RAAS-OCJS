#include <bits/stdc++.h>
using namespace std;
const long double eps = 1e-6;
const long long int MOD = 1e9 + 7;
const long long int MAX = 1 << 16;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n, k, min1 = INT_MAX;
  cin >> n >> k;
  for (long long int i = 0; i != n; ++i) {
    long long int temp;
    cin >> temp;
    if (temp <= k && k % temp == 0) {
      min1 = min(min1, k / temp);
    }
  }
  cout << min1 << "\n";
  return 0;
}
