#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k;
  cin >> n >> k;
  int ans = INT_MIN;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    if (k % temp == 0) {
      ans = max(ans, temp);
    }
  }
  cout << k / ans << endl;
}
