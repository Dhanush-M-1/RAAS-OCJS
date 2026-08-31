#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  vector<int> A(n);
  for (int i = 0; i < n; ++i) cin >> A[i];
  for (int k = *max_element(A.begin(), A.end());; ++k) {
    int getv = 0;
    for (int i = 0; i < n; ++i) {
      getv += k - A[i];
    }
    if (getv > accumulate(A.begin(), A.end(), 0)) cout << k << '\n', exit(0);
  }
}
