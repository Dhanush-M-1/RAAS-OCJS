#include <bits/stdc++.h>
using namespace std;
bool mycomp1(pair<int, int> a, pair<int, int> b) {
  if (a.first != b.first) {
    return (a.first < b.first);
  } else {
    return (a.second > b.second);
  }
}
bool mycomp2(pair<int, int> a, pair<int, int> b) {
  return (a.second < b.second);
}
void solve() {
  int n, m;
  cin >> n;
  pair<int, int> a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
    a[i].second = i;
  }
  sort(a, a + n, mycomp1);
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    pair<int, int> b[k];
    for (int i = 0; i < k; i++) {
      b[i] = a[n - k + i];
    }
    sort(b, b + k, mycomp2);
    cout << b[pos - 1].first << endl;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1;
  while (t--) {
    solve();
  }
}
