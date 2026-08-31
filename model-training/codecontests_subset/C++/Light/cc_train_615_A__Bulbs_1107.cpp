#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a[n], res[m], b[m];
  int xx;
  for (int i = 0; i < m; i++) {
    res[i] = 0;
  }
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    for (int j = 0; j < a[i]; j++) {
      cin >> xx;
      res[--xx] = 1;
    }
  }
  for (int i = 0; i < m; i++) {
    if (res[i] == 0) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
