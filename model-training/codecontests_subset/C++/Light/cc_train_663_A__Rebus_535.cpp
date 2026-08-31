#include <bits/stdc++.h>
using namespace std;
const long long inf = (long long)1000000000000;
const double eps = (double)1e-8;
const int mod = (int)1000000007;
const int maxn = (int)1e5 + 5;
int n, o, x, kp, km, t, mn, mx;
vector<int> a;
string st;
int dzen(string st) {
  int x;
  x = 0;
  for (int i = (0); i < (st.size()); i++) {
    x = x * 10 + (st[i] - '0');
  }
  return x;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> st;
  km = kp = 0;
  t = 1;
  while (st != "=") {
    if (st == "+")
      t = 1;
    else if (st == "-")
      t = 0;
    else {
      if (t) {
        kp++;
        a.push_back(1);
      } else {
        km++;
        a.push_back(0);
      }
    }
    cin >> st;
  }
  cin >> st;
  o = dzen(st);
  mn = -o * km + 1 * kp;
  mx = -1 * km + o * kp;
  if (o < mn || o > mx) {
    cout << "Impossible"
         << "\n";
    return 0;
  }
  cout << "Possible"
       << "\n";
  n = o;
  for (int i = (0); i < (a.size()); i++) {
    if (a[i]) {
      kp--;
      mn = -o * km + 1 * kp;
      mx = -1 * km + o * kp;
      x = max(1, n - mx);
      n -= x;
      if (i != 0) cout << "+ ";
      cout << x << " ";
    } else {
      km--;
      mn = -o * km + 1 * kp;
      mx = -1 * km + o * kp;
      x = max(1, mn - n);
      n += x;
      if (i != 0) cout << "- ";
      cout << x << " ";
    }
  }
  cout << "= " << o << "\n";
  return 0;
}
