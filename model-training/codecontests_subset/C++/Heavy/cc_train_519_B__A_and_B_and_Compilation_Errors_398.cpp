#include <bits/stdc++.h>
using namespace std;
long long n;
map<long long, long long> cnt;
map<long long, long long>::iterator it;
long long a[100005];
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long t;
    cin >> t;
    cnt[t]++;
  }
  for (long long i = 1; i <= n - 1; i++) {
    long long t;
    cin >> t;
    cnt[t]--;
    a[i] = t;
  }
  for (it = cnt.begin(); it != cnt.end(); it++)
    if (it->second) cout << it->first << '\n';
  cnt.clear();
  for (long long i = 1; i <= n - 1; i++) cnt[a[i]]++;
  for (long long i = 1; i <= n - 2; i++) {
    long long t;
    cin >> t;
    cnt[t]--;
  }
  for (it = cnt.begin(); it != cnt.end(); it++)
    if (it->second) cout << it->first << '\n';
}
