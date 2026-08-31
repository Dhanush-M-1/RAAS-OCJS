#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1);
const double eps = 1e-10;
int read() {
  char ch = getchar();
  int data = 0;
  while (ch < '0' || ch > '9') ch = getchar();
  do {
    data = data * 10 + ch - '0';
    ch = getchar();
  } while (ch >= '0' && ch <= '9');
  return data;
}
int main() {
  int x[100], y[100], i, j, k, n, m;
  cin >> n;
  for (i = 1; i <= n; i++) cin >> x[i] >> y[i] >> m;
  for (i = 1; i < n; i++) {
    if (i == 1)
      for (j = 1; j < n; j++) cout << "(";
    if (i == 1)
      cout << "(" << x[i] / 2 << "*((1-abs((" << i << "-t)))+abs((abs((" << i
           << "-t))-1))))+";
    else
      cout << "(" << x[i] / 2 << "*((1-abs((" << i << "-t)))+abs((abs((" << i
           << "-t))-1)))))+";
  }
  if (n > 1)
    cout << "(" << x[n] / 2 << "*((1-abs((" << n << "-t)))+abs((abs((" << n
         << "-t))-1)))))" << endl;
  else
    cout << "(" << x[n] / 2 << "*((1-abs((" << n << "-t)))+abs((abs((" << n
         << "-t))-1))))" << endl;
  for (i = 1; i < n; i++) {
    if (i == 1)
      for (j = 1; j < n; j++) cout << "(";
    if (i == 1)
      cout << "(" << y[i] / 2 << "*((1-abs((" << i << "-t)))+abs((abs((" << i
           << "-t))-1))))+";
    else
      cout << "(" << y[i] / 2 << "*((1-abs((" << i << "-t)))+abs((abs((" << i
           << "-t))-1)))))+";
  }
  if (n > 1)
    cout << "(" << y[n] / 2 << "*((1-abs((" << n << "-t)))+abs((abs((" << n
         << "-t))-1)))))" << endl;
  else
    cout << "(" << y[n] / 2 << "*((1-abs((" << n << "-t)))+abs((abs((" << n
         << "-t))-1))))" << endl;
}
