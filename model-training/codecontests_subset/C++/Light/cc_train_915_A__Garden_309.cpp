#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int n, len;
  cin >> n >> len;
  int res = INT_MAX;
  while (n--) {
    int a;
    cin >> a;
    if (len % a == 0) res = min(res, len / a);
  }
  cout << res;
}
