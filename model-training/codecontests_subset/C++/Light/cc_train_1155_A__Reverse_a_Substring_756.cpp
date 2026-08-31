#include <bits/stdc++.h>
using namespace std;
long long n, m, i, j, l, r;
string s;
int main() {
  cin.tie(NULL);
  cout.tie(NULL);
  ios_base::sync_with_stdio(0);
  cin >> n;
  cin >> s;
  for (i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
