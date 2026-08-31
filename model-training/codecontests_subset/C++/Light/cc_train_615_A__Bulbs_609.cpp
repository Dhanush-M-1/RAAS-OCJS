#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, m, x, a, c;
  cin >> n >> m;
  c = m;
  bool arr[m + 1];
  for (long long int i = 0; i <= m; i++) arr[i] = 0;
  for (long long int i = 1; i <= n; i++) {
    cin >> x;
    for (long long int j = 1; j <= x; j++) {
      cin >> a;
      if (arr[a] == 0) {
        c--;
        arr[a] = 1;
      }
    }
  }
  if (c == 0)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
