#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int I = count(s.begin(), s.end(), 'I');
  if (I > 0) {
    if (I == 1)
      cout << I << endl;
    else
      cout << 0 << endl;
  } else {
    cout << count(s.begin(), s.end(), 'A') << endl;
    ;
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  { solve(); }
  return 0;
}
