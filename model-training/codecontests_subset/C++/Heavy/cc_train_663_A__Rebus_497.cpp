#include <bits/stdc++.h>
using namespace std;
int main() {
  string s = "?";
  string result[201];
  int n_p = 1, n_m = 0, i = 0;
  while (s[0] != '=') {
    cin >> s;
    result[i++] = s;
    if (s[0] == '+') {
      n_p++;
    }
    if (s[0] == '-') {
      n_m++;
    }
  }
  cin >> s;
  int n = stoi(s, NULL);
  int min = n_p - n_m * n, max = n_p * n - n_m;
  if (n < min || n > max) {
    cout << "Impossible\n";
  } else {
    cout << "Possible\n";
    int gap = n - n_p + n_m;
    int p = 0, p_o = 0, m = 0, m_o = 0;
    if (gap < 0) {
      gap = 0 - gap;
      m = gap / (n - 1);
      m_o = gap % (n - 1);
    } else if (gap > 0) {
      p = gap / (n - 1);
      p_o = gap % (n - 1);
    }
    string last = "+";
    for (int k = 0; k < i; k += 2) {
      if (last[0] == '+') {
        if (p > 0) {
          cout << n << " ";
          p--;
        } else if (p_o) {
          cout << p_o + 1 << " ";
          p_o = 0;
        } else {
          cout << "1 ";
        }
      }
      if (last[0] == '-') {
        if (m > 0) {
          cout << n << " ";
          m--;
        } else if (m_o) {
          cout << m_o + 1 << " ";
          m_o = 0;
        } else {
          cout << "1 ";
        }
      }
      last = result[k + 1];
      cout << last << " ";
    }
    cout << n << endl;
  }
  return 0;
}
