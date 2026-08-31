#include <bits/stdc++.h>
using namespace std;
int POS[101], NEG[101];
int main() {
  int n = 0, i = 0, P = 1, N = 0;
  string x;
  getline(cin, x);
  for (i = 0; x[i] != '='; i++)
    if (x[i] == '+')
      P++;
    else if (x[i] == '-')
      N++;
  for (int j = x.size() - 1, T = 1; j > i + 1; j--, T *= 10)
    n += T * (x[j] - '0');
  if (n > n * P - N || n < P - n * N)
    cout << "Impossible" << endl;
  else {
    cout << "Possible" << endl;
    if (n > P - N)
      for (int i = 0, a, m = n - (P - N); i < P; i++)
        a = min(m, n - 1), m -= a, POS[i] = a;
    else if (n < P - N)
      for (int i = 0, a, m = (P - N) - n; i < N; i++)
        a = min(m, n - 1), m -= a, NEG[i] = a;
    char c = '+';
    for (int i = 0, j = 0, k = 0; i < x.size(); i++) {
      if (x[i] == '?')
        if (c == '+')
          cout << POS[j] + 1, j++;
        else
          cout << NEG[k] + 1, k++;
      else if (x[i] == '+')
        c = '+', cout << x[i];
      else if (x[i] == '-')
        c = '-', cout << x[i];
      else
        cout << x[i];
    }
  }
}
