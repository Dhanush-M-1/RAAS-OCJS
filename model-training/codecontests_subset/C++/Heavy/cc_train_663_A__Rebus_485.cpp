#include <bits/stdc++.h>
using namespace std;
const int oo = 1000000009;
const double eps = 1e-9;
const int mod = 1000000007;
string s;
vector<int> pans, nans, fin;
int main() {
  int p = 1, n = 0, num = 0;
  fin.push_back(1);
  while (cin >> s) {
    if (s[0] == '=') break;
    if (s[0] == '+') ++p, fin.push_back(1);
    if (s[0] == '-') ++n, fin.push_back(2);
  }
  cin >> s;
  num = stoi(s);
  if (num + n > num * p || p > num + num * n)
    cout << "Impossible"
         << "\n";
  else {
    cout << "Possible"
         << "\n";
    if (p >= num + n) {
      for (int i = 0; i < p; ++i) pans.push_back(1);
      if (n) {
        int l = (p - num) / n, k = (p - num) % n;
        for (int i = 0; i < n; ++i) {
          if (k)
            nans.push_back(l + 1), --k;
          else
            nans.push_back(l);
        }
      }
    } else {
      for (int i = 0; i < n; ++i) nans.push_back(1);
      int l = (num + n) / p, k = (num + n) % p;
      for (int i = 0; i < p; ++i) {
        if (k)
          pans.push_back(l + 1), --k;
        else
          pans.push_back(l);
      }
    }
    int x = 0, y = 0;
    for (int i = 0; i < fin.size(); ++i) {
      if (i == 0)
        cout << pans[x], ++x;
      else if (fin[i] == 1)
        cout << " + " << pans[x], ++x;
      else
        cout << " - " << nans[y], ++y;
    }
    cout << " = " << num << "\n";
  }
}
