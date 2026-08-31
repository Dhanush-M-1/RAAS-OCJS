#include <bits/stdc++.h>
using namespace std;
const string YESNO[2] = {"NO", "YES"};
const string YesNo[2] = {"No", "Yes"};
const string yesno[2] = {"no", "yes"};
void YES(bool t = 1) { cout << YESNO[t] << "\n"; }
void Yes(bool t = 1) { cout << YesNo[t] << "\n"; }
void yes(bool t = 1) { cout << yesno[t] << "\n"; }
const int mod = 1e9 + 7;
const int mxN = 2e5 + 5;
int n, m, x, y, t, p, q;
array<int, 3> a[mxN];
void code() {
  cin >> n >> m;
  vector<int> v1, v2, v3;
  for (int i = 0; i < n; i++) {
    cin >> t >> p >> q;
    if (p == 1 && q == 1) {
      v1.push_back(t);
    }
    if (p == 1 && q == 0) {
      v2.push_back(t);
    }
    if (p == 0 && q == 1) {
      v3.push_back(t);
    }
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  int ans = 0;
  int k = 0;
  int i = 0, j = 0;
  int x = (int)v1.size(), y = (int)v2.size(), z = (int)v3.size();
  while (k < m && i < x && j < min(y, z)) {
    k++;
    if (v1[i] <= (v2[j] + v3[j])) {
      ans += v1[i];
      i++;
    } else {
      ans += (v2[j] + v3[j]);
      j++;
    }
  }
  while (k < m && i < x) {
    ans += v1[i];
    i++;
    k++;
  }
  while (k < m && j < min(y, z)) {
    ans += (v2[j] + v3[j]);
    k++;
    j++;
  }
  if (k < m)
    cout << -1 << "\n";
  else
    cout << ans << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) code();
}
