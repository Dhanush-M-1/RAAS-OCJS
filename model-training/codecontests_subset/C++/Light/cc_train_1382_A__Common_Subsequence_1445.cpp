#include <bits/stdc++.h>
using namespace std;
void solve();
int main() {
  long long int testcases;
  cin >> testcases;
  while (testcases--) {
    solve();
  }
  return 0;
}
void solve() {
  int n, m;
  cin >> n >> m;
  int match;
  int flag = 0;
  int a[n];
  int b[m];
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  for (int i = 0; i < m; ++i) {
    cin >> b[i];
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (a[i] == b[j]) {
        flag = 1;
        match = a[i];
      }
    }
  }
  if (flag == 0)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    cout << "1 " << match << endl;
  }
}
