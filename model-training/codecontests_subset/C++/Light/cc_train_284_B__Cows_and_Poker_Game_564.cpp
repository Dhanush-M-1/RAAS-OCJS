#include <bits/stdc++.h>
using namespace std;
int n, k, k1, h, t, i, j, a, b, c, l, sum, num;
char s;
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  k = 0;
  a = 0;
  while (n--) {
    cin >> s;
    if (s == 'I')
      k++;
    else if (s == 'A')
      a++;
  }
  if (k == 0)
    cout << a << endl;
  else if (k == 1)
    cout << '1' << endl;
  else
    cout << '0' << endl;
}
