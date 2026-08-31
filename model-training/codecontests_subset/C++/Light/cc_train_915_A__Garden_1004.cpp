#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, a;
  cin >> n >> k;
  vector<int> V;
  for (int i = 0; i < n; i++) {
    cin >> a;
    V.push_back(a);
  }
  sort(V.begin(), V.end());
  reverse(V.begin(), V.end());
  for (int i = 0; i < n; i++) {
    if (k % V[i] == 0) {
      cout << k / V[i];
      return 0;
    }
  }
  cout << V[0];
  return 0;
}
