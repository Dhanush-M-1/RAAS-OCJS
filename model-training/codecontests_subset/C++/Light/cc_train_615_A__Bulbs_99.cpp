#include <bits/stdc++.h>
using namespace std;
int xx[4] = {0, 0, 1, -1};
int yy[4] = {-1, 1, 0, 0};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int n, m;
  cin >> n >> m;
  vector<long long int> v(m, 0);
  while (n--) {
    int x;
    cin >> x;
    while (x--) {
      int k;
      cin >> k;
      v[k - 1]++;
    }
  }
  bool flag = true;
  for (long long int i = 0; i < m; i++) {
    if (v[i] <= 0) {
      flag = false;
      break;
    }
  }
  if (flag)
    cout << "YES"
         << "\n";
  else
    cout << "NO"
         << "\n";
  return 0;
}
