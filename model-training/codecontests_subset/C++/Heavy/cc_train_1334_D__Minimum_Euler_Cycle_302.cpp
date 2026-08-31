#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long size = (r - l) + 1;
    l--;
    r--;
    long long curr = 0;
    long long startVer = 1;
    while (curr - 1 < l) {
      if (startVer == n)
        curr++;
      else
        curr += (n - startVer) * 2;
      startVer++;
    }
    startVer--;
    long long start = startVer - 1;
    long long sub = 0;
    for (int i = 0; i < start; i++) {
      sub += (n - (i + 1)) * 2;
    }
    vector<long long> v;
    long long ver = startVer;
    long long con = ver + 1;
    for (int i = 0; i <= r - sub + 1; i++) {
      if (ver == n) {
        v.push_back(1);
        break;
      }
      if (i % 2 == 0) {
        v.push_back(ver);
      } else {
        v.push_back(con);
        con++;
        if (con == n + 1) {
          ver++;
          con = ver + 1;
        }
      }
    }
    l -= sub;
    r -= sub;
    for (int i = 0; i < v.size(); i++) {
      if (i >= l && i <= r) cout << v[i] << " ";
    }
    cout << endl;
  }
  return 0;
}
