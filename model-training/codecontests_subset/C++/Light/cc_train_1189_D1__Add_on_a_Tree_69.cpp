#include <bits/stdc++.h>
using namespace std;
int n, u, v, z = 0, f[100001];
int main() {
  for (int i = 1; i <= 10000; i++) z++;
  for (int i = 1; i <= 100; i++) z--;
  cin >> n;
  for (int i = 1; i < n; i++) {
    cin >> u >> v;
    f[u]++;
    f[v]++;
  }
  for (int i = 1; i <= n; i++)
    if (f[i] != 1 && f[i] <= 2) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
  return 0;
}
