#include <bits/stdc++.h>
using namespace std;
vector<long long int> v, a1, b1;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, k;
  cin >> n >> k;
  pair<long long int, pair<long long int, long long int> > p[n];
  for (long long int i = 0; i < n; i++) {
    long long int t, a, b;
    cin >> t >> a >> b;
    p[i] = {t, {a, b}};
  }
  sort(p, p + n);
  long long int ans = 0;
  for (long long int i = 0; i < n; i++) {
    if (p[i].second.first == 1 && p[i].second.second == 1) {
      ans += p[i].first;
      v.push_back(p[i].first);
      k--;
    }
    if (k == 0) break;
  }
  long long int flaga = 0;
  long long int temp = 0;
  for (long long int i = 0; i < n; i++) {
    if (flaga == k) temp = 1;
    if (p[i].second.first == 1 && p[i].second.second == 0) {
      if (temp == 1)
        a1.push_back(p[i].first);
      else {
        ans += p[i].first;
        flaga++;
      }
    }
  }
  long long int flagb = 0;
  temp = 0;
  for (long long int i = 0; i < n; i++) {
    if (flagb == k) temp = 1;
    if (p[i].second.first == 0 && p[i].second.second == 1) {
      if (temp == 1)
        b1.push_back(p[i].first);
      else {
        ans += p[i].first;
        flagb++;
      }
    }
  }
  long long int q = v.size() - 1;
  if (v.size() == 0) q = -1;
  for (long long int i = 0; i < a1.size() && i < b1.size() && q >= 0; i++) {
    if (a1[i] + b1[i] < v[q]) {
      ans += (a1[i] + b1[i] - v[q--]);
    } else
      break;
  }
  if (flaga == k && flagb == k)
    cout << ans << "\n";
  else
    cout << -1 << "\n";
  return 0;
}
