#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a[110] = {};
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    for (int j = 0; j < k; j++) {
      int x;
      cin >> x;
      a[x - 1] = 1;
    }
  }
  cout << (count(a, a + m, 1) == m ? "YES" : "NO");
}
