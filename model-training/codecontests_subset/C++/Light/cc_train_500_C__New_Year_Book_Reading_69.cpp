#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(NULL);
  ios::sync_with_stdio(false);
  long long int n, m, i, j, k, ans = 0;
  cin >> n >> m;
  long long int A[n], B[m];
  string str(500, '0');
  for (i = 0; i < n; i++) cin >> A[i];
  for (i = 0; i < m; i++) {
    cin >> k;
    k--;
    B[i] = k;
  }
  for (i = 0; i < m; i++) {
    j = i - 1;
    str = string(500, '0');
    while (j >= 0 && B[j] != B[i]) {
      if (str[B[j]] != '1') {
        ans += A[B[j]];
        str[B[j]] = '1';
      }
      j--;
    }
  }
  cout << ans << endl;
  return 0;
}
