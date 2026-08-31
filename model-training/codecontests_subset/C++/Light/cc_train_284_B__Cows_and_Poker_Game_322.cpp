#include <bits/stdc++.h>
const long long INF = 2009000999;
const float cp = 2 * acos(0.0);
const float eps = 1e-18;
using namespace std;
int main() {
  char x;
  long long n, a = 0, b = 0, c = 0;
  cin >> n;
  for (int(i) = 0; (i) < (n); i++) {
    cin >> x;
    if (x == 'A') a++;
    if (x == 'F') b++;
    if (x == 'I') c++;
  }
  if (c > 1)
    cout << "0";
  else if (c == 1)
    cout << "1";
  else
    cout << a;
}
