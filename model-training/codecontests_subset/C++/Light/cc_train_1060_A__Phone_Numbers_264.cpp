#include <bits/stdc++.h>
using namespace std;
vector<long long> v;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int cnt = 0;
  for (auto i : s) {
    if (i == '8') cnt++;
  }
  int ans = 0;
  while (cnt--) {
    if (n < 11) break;
    ans++;
    n -= 11;
  }
  cout << ans << endl;
  return 0;
}
