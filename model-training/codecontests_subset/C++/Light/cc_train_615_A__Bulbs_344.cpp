#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a;
  int index[200];
  for (int i = 1; i <= m; i++) index[i] = 0;
  for (int i = 0; i < n; i++) {
    cin >> a;
    int b;
    for (int j = 0; j < a; j++) {
      cin >> b;
      index[b] = index[b] + 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (index[i] == 0) {
      cout << "NO";
      exit(0);
    }
  }
  cout << "YES";
  return 0;
}
