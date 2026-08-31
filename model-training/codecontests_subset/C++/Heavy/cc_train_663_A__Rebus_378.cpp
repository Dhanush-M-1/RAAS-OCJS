#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  vector<char> vec;
  char c;
  int n, nM = 0, nP = 0, d;
  while (cin >> c && c != '=')
    if (c == '+' || c == '-') {
      vec.push_back(c);
      if (c == '+') nP++;
      if (c == '-') nM++;
    }
  d = nP - nM;
  cin >> n;
  if (n < nP + 1 - n * nM || n > n * (nP + 1) - nM) {
    cout << "Impossible"
         << "\n";
    return 0;
  }
  cout << "Possible"
       << "\n";
  if (d == 0) {
    cout << n << " ";
    for (char c : vec) cout << c << " " << 1 << " ";
    cout << "= " << n << "\n";
    return 0;
  }
  if (d > 0) {
    if (n - d <= 0) {
      int reduce = d - n + 2;
      cout << 1 << " ";
      for (char c : vec) {
        if (c == '+' || reduce <= 0)
          cout << c << " " << 1 << " ";
        else {
          cout << c << " " << min(n, reduce) << " ";
          reduce -= min(n, reduce) - 1;
        }
      }
    } else {
      cout << n - d << " ";
      for (char c : vec) cout << c << " " << 1 << " ";
    }
    cout << "= " << n << "\n";
  } else {
    d *= -1;
    if (n - d <= 0) {
      int add = d + 1;
      cout << n << " ";
      for (char c : vec) {
        if (c == '-' || add <= 0)
          cout << c << " " << 1 << " ";
        else {
          cout << c << " " << min(n, add) << " ";
          add -= min(n, add) - 1;
        }
      }
    } else {
      cout << n << " ";
      bool sw = true;
      for (char c : vec) {
        if (c == '+' && sw) {
          cout << c << " " << d + 1 << " ";
          sw = false;
        } else
          cout << c << " " << 1 << " ";
      }
    }
    cout << "= " << n << "\n";
  }
}
