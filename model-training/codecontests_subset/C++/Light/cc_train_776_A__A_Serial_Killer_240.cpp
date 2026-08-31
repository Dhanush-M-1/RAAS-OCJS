#include <bits/stdc++.h>
using namespace std;
long long i, j, m, n, p, q, r;
map<string, string> mp;
vector<pair<string, string> > v;
string x, y, a, b, d, s;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  cin >> x >> y;
  cin >> n;
  cout << x << " " << y << "\n";
  mp[x] = x, mp[y] = y;
  for (i = 0; i < n; i++) {
    cin >> a >> b;
    mp[a] = b;
    mp[b] = b;
    cout << mp[x] << " " << mp[y] << "\n";
    x = mp[x], y = mp[y];
  }
}
