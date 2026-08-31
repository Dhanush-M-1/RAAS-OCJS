#include <bits/stdc++.h>
using namespace std;
bool cmp(pair<int, int>& a, pair<int, int>& b) {
  if (a.first > b.first)
    return true;
  else if (a.first == b.first)
    return a.second < b.second;
  return false;
}
bool cmp2(pair<int, int>& a, pair<int, int>& b) { return a.second < b.second; }
void solve() {
  int n;
  cin >> n;
  pair<int, int> a[n];
  for (int i = 0; i < n; i++) cin >> a[i].first, a[i].second = i;
  sort(a, a + n, cmp);
  int q;
  cin >> q;
  int k, p;
  while (q--) {
    cin >> k >> p;
    pair<int, int> v[k];
    for (int i = 0; i < k; i++) v[i] = a[i];
    sort(v, v + k, cmp2);
    cout << v[p - 1].first << "\n";
  }
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  ;
  long long t = 1;
  for (int i = 0; i < t; i++) {
    solve();
  }
}
