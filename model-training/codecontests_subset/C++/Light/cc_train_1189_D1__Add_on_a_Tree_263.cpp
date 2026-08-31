#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, i, flag = 0, x, y;
  cin >> n;
  long long int a[200005];
  for (i = 1; i <= n; i++) {
    a[i] = 0;
  }
  for (i = 1; i < n; i++) {
    cin >> x >> y;
    a[x]++;
    a[y]++;
  }
  for (i = 1; i <= n; i++) {
    if (a[i] == 2) {
      flag = 1;
    }
  }
  if (flag == 0) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}
