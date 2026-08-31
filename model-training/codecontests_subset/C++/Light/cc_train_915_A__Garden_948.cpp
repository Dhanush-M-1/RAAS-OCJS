#include <bits/stdc++.h>
using namespace std;
const int N = 110;
int q[N];
int n, k;
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) cin >> q[i];
  sort(q + 1, q + n + 1);
  for (int i = n; i >= 1; i--)
    if (k % q[i] == 0) {
      cout << k / q[i] << "\n";
      return 0;
    }
}
