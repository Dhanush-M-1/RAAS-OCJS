#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
long long i, j;
long long temp;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  long long a[n];
  long long h = 0, t = 0;
  for (i = 0; i < n; i++) {
    cin >> temp;
    if (temp == 100)
      h++;
    else
      t++;
  }
  if (t % 2 == 0 && h % 2 == 0)
    cout << "YES";
  else if (t % 2 == 1 && h % 2 == 0 && h > 0)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
