#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, d, t = 0, o = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> d;
    if (d == 200)
      t++;
    else
      o++;
  }
  if (o % 2 == 0 && o > 0)
    cout << "YES";
  else if (o == 0 && t % 2 == 0)
    cout << "YES";
  else
    cout << "NO";
}
