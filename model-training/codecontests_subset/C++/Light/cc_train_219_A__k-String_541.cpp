#include <bits/stdc++.h>
using namespace std;
void CyBerForCe() {
  long long k;
  cin >> k;
  string s;
  cin >> s;
  map<char, long long> mp;
  long long l = s.length();
  for (long long i = 0; i < l; i++) mp[s[i]]++;
  for (auto i : mp) {
    if (i.second % k != 0) {
      cout << "-1\n";
      return;
    }
  }
  string t = "";
  for (auto i : mp) {
    for (long long j = 0; j < (i.second / k); j++) t += i.first;
  }
  for (long long i = 0; i < k; i++) cout << t;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  CyBerForCe();
  return 0;
}
