#include <bits/stdc++.h>
using namespace std;
const long long int INF = (long long int)2e18 + 77;
void solve() {
  int n;
  cin >> n;
  int a[n], i;
  for (i = 0; i < n; i++) cin >> a[i];
  map<int, int> N;
  int M[n][n];
  for (i = 0; i < n; i++) {
    N[a[i]]++;
    M[n - 1][i] = a[i];
  }
  for (i = n - 2; i >= 0; i--) {
    int mn = (*N.begin()).first;
    N[mn]--;
    if (N[mn] == 0) N.erase(mn);
    int j, k = i;
    for (j = i + 1; j >= 0; j--) {
      if (mn == M[i + 1][j])
        mn = -1;
      else
        M[i][k--] = M[i + 1][j];
    }
  }
  int m, len;
  cin >> m;
  while (m--) {
    cin >> len >> i;
    len--;
    i--;
    cout << M[len][i] << "\n";
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
