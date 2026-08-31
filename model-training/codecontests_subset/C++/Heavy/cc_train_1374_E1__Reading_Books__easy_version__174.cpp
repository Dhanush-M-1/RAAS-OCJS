#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  vector<int> v0, v1, v2;
  for (int i = 0; i < n; i += 1) {
    int x, y, z;
    cin >> x >> y >> z;
    if (y == 1 && z == 1)
      v0.push_back(x);
    else if (y != 1 && z == 1)
      v2.push_back(x);
    else if (y == 1 && z != 1)
      v1.push_back(x);
  }
  sort(v0.begin(), v0.end());
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  int k1 = 0, k2 = 0, x = 0, y = 0, z = 0, sum = 0, done = 0, n0 = v0.size(),
      n1 = v1.size(), n2 = v2.size();
  while (k1 != k) {
    if (x >= n0) {
      if (y >= n1 || z >= n2) {
        done = 1;
        cout << -1 << "\n";
        break;
      } else {
        sum += v1[y] + v2[z];
        y++;
        z++;
        k1++;
        k2++;
      }
    } else {
      if (y >= n1 || z >= n2) {
        sum += v0[x];
        x++;
        k1++;
        k2++;
      } else {
        if (v0[x] > v1[y] + v2[z]) {
          sum += v1[y] + v2[z];
          y++;
          z++;
          k1++;
          k2++;
        } else {
          sum += v0[x];
          x++;
          k1++;
          k2++;
        }
      }
    }
  }
  if (!done) {
    cout << sum << "\n";
  }
  return 0;
}
