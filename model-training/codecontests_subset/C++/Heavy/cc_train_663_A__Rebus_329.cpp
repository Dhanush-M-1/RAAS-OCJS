#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s;
  int n, m, i, j, k, l, p = 1, q = 0, x;
  v.push_back(1);
  while (1) {
    cin >> s;
    if (s[0] == '=') break;
    if (s[0] == '?') continue;
    if (s[0] == '+') {
      v.push_back(1);
      p++;
    }
    if (s[i] == '-') {
      v.push_back(2);
      q++;
    }
  }
  cin >> n;
  m = n - p + q;
  if (m >= 0) {
    if (m > (n - 1) * p) {
      cout << "Impossible";
      return 0;
    } else {
      cout << "Possible\n";
      for (k = 0; k < v.size(); k++) {
        if (k != 0) {
          if (v[k] == 1)
            cout << "+ ";
          else
            cout << "- ";
        }
        if (v[k] == 1) {
          if (m >= (n - 1)) {
            m -= (n - 1);
            x = (n - 1);
          } else {
            x = m;
            m = 0;
          }
          cout << x + 1 << " ";
        } else {
          cout << "1 ";
        }
      }
    }
  } else {
    m = -m;
    if (m > (n - 1) * q) {
      cout << "Impossible";
      return 0;
    } else {
      cout << "Possible\n";
      for (k = 0; k < v.size(); k++) {
        if (k != 0) {
          if (v[k] == 1)
            cout << "+ ";
          else
            cout << "- ";
        }
        if (v[k] == 2) {
          if (m >= (n - 1)) {
            m -= (n - 1);
            x = (n - 1);
          } else {
            x = m;
            m = 0;
          }
          cout << x + 1 << " ";
        } else {
          cout << "1 ";
        }
      }
    }
  }
  cout << "= " << n;
  return 0;
}
