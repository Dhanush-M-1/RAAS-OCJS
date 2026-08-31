#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:64000000")
#pragma warning(default : 4996)
const long MAXN = 100002;
using namespace std;
long long n, i, j, k, m, ans = 0, x;
long long a[101];
int main() {
  cin >> n >> m;
  for (i = 1; i <= n; i++) {
    cin >> k;
    for (j = 1; j <= k; j++) {
      cin >> x;
      if (a[x] == 0) {
        ans++;
        a[x] = 1;
      }
      if (ans == m) {
        cout << "YES";
        return 0;
      }
    }
  }
  cout << "NO";
}
