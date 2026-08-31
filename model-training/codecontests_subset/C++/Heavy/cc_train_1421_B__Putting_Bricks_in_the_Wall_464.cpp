#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)1e6 + 9;
const int INF = (int)1e9 + 7;
int mod = (int)1e9 + 7;
string tab[209];
void solve() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> tab[i];
  char a0 = tab[0][1], a1 = tab[1][0];
  char b0 = tab[n - 1][n - 2], b1 = tab[n - 2][n - 1];
  if (0)
    cout << "a0"
         << " = " << a0 << " "
         << "a1"
         << " = " << a1 << " "
         << "b0"
         << " = " << b0 << " "
         << "b1"
         << " = " << b1 << " " << endl;
  if (a0 == a1) {
    if (b0 == b1) {
      if (b0 == a0)
        cout << "2\n1 2\n2 1\n";
      else
        cout << "0\n";
    } else {
      if (b0 == a0)
        cout << "1\n" << n << " " << n - 1 << "\n";
      else
        cout << "1\n" << n - 1 << " " << n << "\n";
    }
  } else {
    if (b0 != b1) {
      if (a0 == b0)
        cout << "2\n1 2\n" << n - 1 << " " << n << "\n";
      else
        cout << "2\n1 2\n" << n << " " << n - 1 << "\n";
    } else {
      if (a0 == b0)
        cout << "1\n1 2\n";
      else
        cout << "1\n2 1\n";
    }
  }
}
int main(int argc, char* argv[]) {
  ios::sync_with_stdio(false);
  if (0)
    ;
  else
    cin.tie(NULL), cout.tie(NULL);
  int cases;
  cin >> cases;
  while (cases--) solve();
  return 0;
}
