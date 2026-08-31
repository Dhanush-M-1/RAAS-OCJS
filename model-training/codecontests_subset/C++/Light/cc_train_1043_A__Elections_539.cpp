#include <bits/stdc++.h>
#pragma GCC optimize 03
using namespace std;
const int N = 101;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, a, j = 0, tot = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    j = max(a, j);
    tot += a;
  }
  for (int i = j; i < 202; i++)
    if (i * n > tot * 2) {
      cout << i << endl;
      return 0;
    }
}
