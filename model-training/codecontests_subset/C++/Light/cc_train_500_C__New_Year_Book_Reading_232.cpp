#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> w(n), b(m);
  for (int i = 0; i < n; i++) cin >> w[i];
  for (int i = 0; i < m; i++) {
    cin >> b[i];
    b[i]--;
  }
  long long int otv = 0;
  for (int i = 0; i < m; i++) {
    vector<bool> was(n, false);
    for (int j = i - 1; j >= 0 && b[j] != b[i]; j--)
      if (!was[b[j]]) {
        was[b[j]] = true;
        otv += w[b[j]];
      }
  }
  cout << otv;
  return 0;
}
