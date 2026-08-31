#include <bits/stdc++.h>
using namespace std;
long long last[1002];
void solve() {
  long long n, m, i, j;
  cin >> n >> m;
  long long w[n + 1];
  for (i = 1; i < n + 1; ++i) {
    cin >> w[i];
  }
  long long arr[m + 1];
  set<long long> s;
  vector<long long> v;
  for (i = 1; i < m + 1; ++i) {
    cin >> arr[i];
    if (s.find(arr[i]) == s.end()) v.push_back(arr[i]);
    s.insert(arr[i]);
  }
  long long sum = 0;
  long long prefix[(long long)v.size()];
  prefix[0] = 0;
  for (i = 1; i < (long long)v.size(); ++i) {
    prefix[i] = prefix[i - 1] + w[v[i - 1]];
  }
  for (i = 0; i < (long long)v.size(); ++i) sum += prefix[i];
  for (i = 1; i < m + 1; ++i) {
    if (!last[arr[i]]) {
      last[arr[i]] = i;
    } else {
      set<long long> temp;
      for (j = last[arr[i]] + 1; j < i; ++j) {
        if (temp.find(arr[j]) == temp.end()) sum += w[arr[j]];
        temp.insert(arr[j]);
      }
      last[arr[i]] = i;
    }
  }
  cout << sum << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
