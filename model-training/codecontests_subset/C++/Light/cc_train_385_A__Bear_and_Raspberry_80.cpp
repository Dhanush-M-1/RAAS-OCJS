#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int v[n];
  for (int i = 0; i < n; i++) cin >> v[i];
  int sol = 0;
  for (int i = 0; i < n - 1; i++) {
    sol = max(sol, v[i] - v[i + 1] - c);
  }
  cout << sol << endl;
  return 0;
}
