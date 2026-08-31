#include <bits/stdc++.h>
const long long mxn = 1e5 + 7;
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s, d;
  long long n;
  cin >> s >> d;
  cin >> n;
  cout << s << ' ' << d << endl;
  ;
  for (int i = 0; i < n; i++) {
    string a, b;
    cin >> a >> b;
    if (a == s) {
      s = b;
    } else if (b != s) {
      d = b;
    }
    cout << s << ' ' << d << endl;
  }
  return 0;
}
