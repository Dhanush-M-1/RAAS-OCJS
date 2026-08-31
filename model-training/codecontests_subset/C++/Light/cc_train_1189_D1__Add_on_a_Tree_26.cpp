#include <bits/stdc++.h>
using namespace std;
const long long N = 100005;
long long degree[N];
int main() {
  long long n, i, v, u;
  cin >> n;
  for (i = 0; i < n - 1; i++) {
    cin >> v >> u;
    degree[v]++;
    degree[u]++;
  }
  for (i = 1; i <= n; i++) {
    if (degree[i] == 2) {
      cout << "NO\n";
      ;
      return 0;
    }
  }
  cout << "YES\n";
  return 0;
}
