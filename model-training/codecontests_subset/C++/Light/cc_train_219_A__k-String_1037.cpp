#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
const int MX = 1e7 + 123;
ll arr[MX];
int brr[MX];
int crr[MX];
void inout() {}
void solve() {
  int x;
  int n;
  cin >> n;
  string s, b, c;
  cin >> s;
  sort(s.begin(), s.end());
  for (int i = 0; i < s.size(); i += n) {
    b += s[i];
  }
  for (int i = 0; i < n; i++) {
    c += b;
  }
  b = c;
  sort(b.begin(), b.end());
  if (b != s)
    cout << "-1" << '\n';
  else
    cout << c << '\n';
}
int main() {
  inout();
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  solve();
  return 0;
}
