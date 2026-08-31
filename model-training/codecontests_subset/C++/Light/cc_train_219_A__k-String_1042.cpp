#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, a[27] = {0}, c = 0;
  string s, r;
  cin >> n >> s;
  for (int i = 0; i < s.size(); i++) a[s[i] - 'a'] += 1;
  for (int i = 0; i < 27; i++)
    if (a[i] % n && a[i] != 0) c++;
  if (c)
    cout << -1;
  else {
    c = 0;
    for (int i = 0; i < 27; i++)
      if (a[i]) {
        c = a[i] / n;
        while (c--) r += i + 'a';
      }
    while (n--) cout << r;
  }
  return 0;
}
