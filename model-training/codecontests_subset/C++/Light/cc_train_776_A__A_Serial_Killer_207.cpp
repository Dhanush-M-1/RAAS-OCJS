#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007ll;
const int infty = numeric_limits<int>::max();
struct _ {
  _() {
    ios_base::Init i;
    ios_base::sync_with_stdio(0);
    cin.tie(0);
  }
} _;
int main() {
  string s, t;
  cin >> s >> t;
  int n;
  cin >> n;
  string a, b;
  for (int i = 0; i < n; ++i) {
    cout << t << ' ' << s << endl;
    cin >> a >> b;
    if (t == a)
      t = b;
    else
      s = b;
  }
  cout << t << ' ' << s << endl;
  return 0;
}
