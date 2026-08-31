#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("unroll-loops")
using namespace std;
bool sortbysec(const pair<int, int> &a, const pair<int, int> &b) {
  return (a.first - a.second) > (b.first - b.second);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int cnt1 = 0, cnt2 = 0;
    int t1 = 2 * a;
    t1 = min(t1, b - b % 2);
    cnt1 += (t1 * 3) / 2;
    int t2 = b - t1;
    int t3 = min(2 * t2, c - c % 2);
    cnt1 += (t3 * 3) / 2;
    t1 = 2 * b;
    t1 = min(t1, c - c % 2);
    cnt2 += (t1 * 3) / 2;
    b = b - t1 / 2;
    t3 = min(2 * a, b - b % 2);
    cnt2 += (t3 * 3) / 2;
    cout << max(cnt1, cnt2) << endl;
  }
  return 0;
}
