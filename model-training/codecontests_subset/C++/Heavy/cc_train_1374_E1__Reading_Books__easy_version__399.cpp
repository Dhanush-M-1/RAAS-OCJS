#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
const long long INF = 1e9 + 9;
const int MAX = 100;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout.precision(10);
  cout << fixed;
  long long t = 1;
  while (t--) {
    long long n, k;
    cin >> n >> k;
    vector<pair<int, int> > vp1;
    vector<pair<int, int> > vp2;
    vector<int> v;
    for (int i = 0; i < n; i++) {
      int a, b, c;
      cin >> a >> b >> c;
      if (b && !c) vp1.push_back({a, b});
      if (c && !b) vp2.push_back({a, c});
      if (b && c) v.push_back(a);
    }
    sort(v.begin(), v.end());
    long long ans = 0;
    sort(vp1.begin(), vp1.end());
    sort(vp2.begin(), vp2.end());
    int i = 0, j = 0;
    while (k > 0) {
      if (i == vp1.size() || i == vp2.size()) {
        break;
      }
      if (j == v.size()) {
        break;
      }
      if (v[j] <= vp1[i].first + vp2[i].first) {
        ans += v[j];
        j++;
        k--;
      } else {
        ans += vp1[i].first + vp2[i].first;
        i++;
        k--;
      }
    }
    while (i < vp1.size() && k > 0 && i < vp2.size()) {
      ans += vp1[i].first + vp2[i].first;
      k--;
      i++;
    }
    while (j < v.size() && k > 0) {
      ans += v[j];
      k--;
      j++;
    }
    if (k > 0) {
      cout << "-1" << '\n';
      continue;
    }
    cout << ans << '\n';
  }
  return 0;
}
