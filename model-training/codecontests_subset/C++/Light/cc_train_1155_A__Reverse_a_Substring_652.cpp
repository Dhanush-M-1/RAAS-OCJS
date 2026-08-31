#include <bits/stdc++.h>
using namespace std;
long long i, j, k, l, n, m, flag;
long long a[200009];
string s;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n >> s;
  for (i = 1; i < s.length(); i++) {
    if (s[i] < s[i - 1]) {
      swap(s[i], s[i - 1]);
      cout << "YES" << '\n' << i << ' ' << i + 1 << '\n';
      exit(0);
    }
  }
  cout << "NO" << '\n';
  exit(0);
}
