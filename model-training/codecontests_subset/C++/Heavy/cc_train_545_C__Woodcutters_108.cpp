#include <bits/stdc++.h>
using namespace std;
long long fun(vector<pair<long long, long long> > &v) {
  long long i, j, k, n = v.size();
  if (n == 1) return 1;
  long long ans = 2;
  long long ptr = v[0].first;
  for (i = 1; i < n - 1; i++) {
    if (v[i].first - v[i].second > v[i - 1].first) {
      ptr = v[i].first;
      ans++;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      ptr = v[i].first + v[i].second;
      v[i].first += v[i].second;
      ans++;
    }
  }
  return ans;
}
void input(vector<pair<long long, long long> > &v) {
  long long i, j, n = v.size();
  for (i = 0; i < n; i++) cin >> v[i].first >> v[i].second;
}
int main() {
  int t;
  t = 1;
  while (t--) {
    long long i, j, k, n;
    cin >> n;
    vector<pair<long long, long long> > vp(n);
    input(vp);
    sort(vp.begin(), vp.end());
    cout << fun(vp) << endl;
  }
  return 0;
}
