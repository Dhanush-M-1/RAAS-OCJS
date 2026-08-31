#include <bits/stdc++.h>
using namespace std;
long long int mod = 1e9 + 7;
void cases() {
  long long int n;
  cin >> n;
  string s;
  cin >> s;
  long long int c = 0;
  for (long long int i = 0; i < n; i++) c += (s[i] == '8');
  cout << min(c, n / 11);
}
int32_t main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int tc = 1;
  while (tc--) {
    cases();
  }
}
