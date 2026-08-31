#include <bits/stdc++.h>
using namespace std;
void setMyPrecision(int n) { cout << fixed << setprecision(n); }
bool test = 0;
void solve() {
  string pass;
  cin >> pass;
  int n;
  set<char> f, l;
  cin >> n;
  bool flag = false;
  for (int i = 0; i < n; i++) {
    char o, t;
    cin >> o >> t;
    if (pass[0] == o && pass[1] == t) flag = true;
    f.insert(o);
    l.insert(t);
  }
  if (flag) {
    cout << "YES";
    return;
  }
  if ((f.find(pass[1]) != f.end()) && (l.find(pass[0]) != l.end()))
    cout << "YES";
  else
    cout << "NO";
}
int main() {
  ios::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  if (test) {
    int t;
    cin >> t;
    while (t--) solve();
  } else
    solve();
  return 0;
}
