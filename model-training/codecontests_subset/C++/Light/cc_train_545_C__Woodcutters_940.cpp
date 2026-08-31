#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int C[N], H[N], n;
int main() {
  cin >> n;
  if (n <= 2) return cout << n << endl, 0;
  int ans = 2;
  for (int i = 0; i < n; ++i) cin >> C[i] >> H[i];
  double lst = C[0];
  for (int i = 1; i < n - 1; ++i) {
    if (C[i] - H[i] > lst)
      ans++, lst = C[i];
    else if (C[i] + H[i] < C[i + 1])
      ans++, lst = C[i] + H[i];
    else
      lst = C[i];
  }
  cout << ans << endl;
  return 0;
}
