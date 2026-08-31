#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0), cout.tie(0), cin.tie(0);
  long long int n, m, k, i, j, a[101];
  cin >> n;
  vector<long long int> pr;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    pr.push_back(a[i]);
  }
  sort(pr.rbegin(), pr.rend());
  cin >> m;
  while (m--) {
    long long int k, pos, last = -1;
    cin >> k >> pos;
    pos--;
    for (i = k - 1; i >= 0; i--) {
      if (pr[i] == pr[i - 1])
        ;
      else
        break;
    }
    int y = k - i, z = -1;
    for (i = 0; i < n; i++) {
      if (a[i] > pr[k - 1]) {
        z++;
      } else if (a[i] == pr[k - 1] && y) {
        z++, y--;
      }
      if (z == pos) break;
    }
    cout << a[i] << endl;
  }
}
