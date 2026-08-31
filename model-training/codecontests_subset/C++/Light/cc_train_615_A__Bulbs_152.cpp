#include <bits/stdc++.h>
using namespace std;
int const N = 105;
int n, m, mrk[N];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    int num;
    cin >> num;
    for (int j = 1; j <= num; j++) {
      int v;
      cin >> v;
      mrk[v] = 1;
    }
  }
  for (int i = 1; i <= m; i++)
    if (!mrk[i]) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
}
