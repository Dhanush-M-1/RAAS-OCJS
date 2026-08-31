#include <bits/stdc++.h>
using namespace std;
long long l, r, a, x, y, z, b, i, j, k, n, m, num, ans, t;
long long arr[200005], arr2[200005];
string s;
char str[10][10];
bool cmp(long long a, long long b) { return a > b; }
int main() {
  cin >> t;
  for (k = 0; k < t; k++) {
    memset(arr, 0, sizeof(arr));
    cin >> n >> m;
    for (i = 0; i < n; i++) {
      cin >> a;
      arr[a] = 1;
    }
    b = -1;
    for (i = 0; i < m; i++) {
      cin >> a;
      if (arr[a] == 1) {
        b = a;
      }
    }
    if (b == -1)
      cout << "NO\n";
    else {
      cout << "YES" << '\n' << "1 " << b << '\n';
    }
  }
  return 0;
}
