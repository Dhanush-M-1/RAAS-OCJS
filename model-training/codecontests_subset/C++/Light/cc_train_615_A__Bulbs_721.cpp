#include <bits/stdc++.h>
using namespace std;
const int N = 110;
int main() {
  int n, m;
  cin >> n >> m;
  int a[N] = {0};
  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;
    for (int j = 0; j < num; j++) {
      int k;
      cin >> k;
      a[k]++;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (a[i] == 0) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
