#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000 * 100 * 2 + 10;
long long int ans[MAXN];
long long int mark[MAXN];
long long int s = 1000 * 1000;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  int ind = 0, x = 0;
  int mx = 0;
  for (int i = 0; i < n; i++) {
    int m;
    cin >> m;
    if (m > s / 2) {
      m = s - m;
    } else {
      m--;
    }
    if (m > mx) {
      mx = m;
    }
  }
  cout << mx << endl;
  return 0;
}
