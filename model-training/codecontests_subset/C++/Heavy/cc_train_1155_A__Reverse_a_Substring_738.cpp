#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  string s;
  cin >> s;
  map<long long, long long> m;
  set<long long> set;
  set.insert(s[0] - 'a');
  m[s[0] - 'a'] = 1;
  long long flag = 0, l, r;
  for (long long i = 1; i < s.length(); i++) {
    long long x = s[i] - 'a';
    auto it = set.end();
    it--;
    if (*it > x) {
      flag = 1;
      l = m[*it];
      r = i + 1;
      break;
    } else {
      set.insert(x);
      m[x] = i + 1;
    }
  }
  if (flag) {
    cout << "YES\n";
    cout << l << " " << r << "\n";
  } else
    cout << "NO\n";
  return 0;
}
