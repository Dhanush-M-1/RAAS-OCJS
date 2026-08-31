#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 5;
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  string s;
  long long n;
  cin >> n >> s;
  long long c = count(s.begin(), s.end(), '8');
  cout << (c < (n / 11) ? c : (n / 11));
  return 0;
}
