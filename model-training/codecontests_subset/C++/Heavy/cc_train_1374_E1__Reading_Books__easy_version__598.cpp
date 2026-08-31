#include <bits/stdc++.h>
using namespace std;
void printVector(vector<string> &v) {
  for (auto x : v) cout << x << "\n";
}
void printVector(vector<int> &v) {
  for (auto x : v) cout << x << " ";
  cout << "\n";
}
int main() {
  cin.tie(0);
  cout.tie(0);
  ios::sync_with_stdio(0);
  int t;
  t = 1;
  while (t--) {
    int n, k;
    cin >> n >> k;
    vector<int> v1, v2, v3;
    int ca = 0, cb = 0;
    for (int i = 0; i < n; i++) {
      int tm, a, b;
      cin >> tm >> a >> b;
      if (a == 1) {
        ca++;
        if (b == 1) {
          v3.push_back(tm);
          cb++;
        } else {
          v1.push_back(tm);
        }
      } else if (b == 1) {
        v2.push_back(tm);
        cb++;
      }
    }
    if (ca < k || cb < k) {
      cout << -1 << "\n";
      continue;
    }
    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end());
    sort(v3.begin(), v3.end());
    int i1 = 0, i2 = 0, i3 = 0;
    int c1 = 0, c2 = 0;
    int ans = 0;
    while (c1 < k || c2 < k) {
      if (c1 < k && c2 < k) {
        int t1 = 2e4 + 1;
        if (i1 < v1.size()) t1 = v1[i1];
        int t2 = 2e4 + 1;
        if (i2 < v2.size()) t2 = v2[i2];
        int t3 = 2e4 + 1;
        if (i3 < v3.size()) t3 = v3[i3];
        if (t3 <= (t1 + t2)) {
          ans += t3;
          c1++;
          c2++;
          i3++;
        } else {
          ans += t1;
          ans += t2;
          c1++;
          c2++;
          i1++;
          i2++;
        }
      } else if (c1 < k) {
        int t1 = 2e4 + 1;
        if (i1 < v1.size()) t1 = v1[i1];
        int t3 = 2e4 + 1;
        if (i3 < v3.size()) t3 = v3[i3];
        if (t3 <= t1) {
          ans += t3;
          c1++;
          c2++;
          i3++;
        } else {
          ans += t1;
          c1++;
          i1++;
        }
      } else {
        int t2 = 2e4 + 1;
        if (i2 < v2.size()) t2 = v2[i2];
        int t3 = 2e4 + 1;
        if (i3 < v3.size()) t3 = v3[i3];
        if (t3 <= t2) {
          ans += t3;
          c1++;
          c2++;
          i3++;
        } else {
          ans += t2;
          c2++;
          i2++;
        }
      }
    }
    cout << ans << "\n";
  }
}
