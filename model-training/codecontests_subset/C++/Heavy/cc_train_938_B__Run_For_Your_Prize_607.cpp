#include <bits/stdc++.h>
const long long INF = 1e18;
const long long MOD = 1000000007;
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  vector<int> v(n);
  for (int &i : v) cin >> i;
  int i = 0, j = n - 1;
  int vc = 1, amigo = 1e6;
  long long ans = 0;
  while (i <= j) {
    int dist1 = 0, dist2 = 0;
    if (abs(vc - v[i]) <= abs(amigo - v[i]) &&
        abs(amigo - v[j]) <= abs(vc - v[j])) {
      dist1 = abs(vc - v[i]);
      dist2 = abs(amigo - v[j]);
      if (dist2 > dist1) {
        ans += dist2;
        amigo = v[j--];
        while (abs(vc - v[i]) < dist2) {
          i++;
        }
        vc = vc + dist2;
      } else {
        ans += dist1;
        vc = v[i++];
        while (abs(amigo - v[j] < dist1)) {
          j--;
        }
        amigo = amigo - dist1;
      }
    } else if (abs(vc - v[j]) <= abs(amigo - v[j])) {
      ans += abs(vc - v[j]);
      break;
    } else if (abs(amigo - v[i]) <= abs(vc - v[i])) {
      ans += abs(amigo - v[i]);
      break;
    }
  }
  cout << ans;
}
