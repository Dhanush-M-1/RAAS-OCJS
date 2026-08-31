#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  vector<int> vedra(n);
  for (int i = 0; i < n; i++) cin >> vedra[i];
  sort(vedra.begin(), vedra.end());
  for (int i = n - 1; i >= 0; i--) {
    if (k % vedra[i] == 0) {
      cout << k / vedra[i];
      break;
    }
  }
  return 0;
}
