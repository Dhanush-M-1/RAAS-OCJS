#include <bits/stdc++.h>
using namespace std;
long long int mint(long long int a, long long int b) {
  if (a < b)
    return a;
  else
    return b;
}
int main() {
  long long int n, m;
  cin >> n >> m;
  int arr[n];
  long long int i;
  for (i = 0; i < n; ++i) {
    cin >> arr[i];
  }
  bool check[n];
  memset(check, 0, sizeof(check));
  int mm[m];
  for (i = 0; i < m; ++i) {
    cin >> mm[i];
  }
  long long int ans = 0;
  long long int j;
  for (i = 0; i < m; ++i) {
    for (j = i - 1; j >= 0; j--) {
      if (mm[j] == mm[i])
        break;
      else if (check[mm[j] - 1] == 0) {
        ans += arr[mm[j] - 1];
        check[mm[j] - 1] = 1;
      }
    }
    memset(check, 0, sizeof(check));
  }
  cout << ans << "\n";
  return 0;
}
