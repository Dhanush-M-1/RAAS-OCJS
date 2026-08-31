#include <bits/stdc++.h>
using namespace std;
int t, n, A[1000000];
int main() {
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> A[i];
    if (A[1] + A[2] <= A[n])
      cout << 1 << " " << 2 << " " << n << endl;
    else
      cout << -1 << endl;
  }
}
