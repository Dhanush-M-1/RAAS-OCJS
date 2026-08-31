#include <bits/stdc++.h>
using namespace std;
int a[1000006];
int main() {
  int n;
  string a, b, c, d;
  cin >> a >> b;
  scanf("%d", &n);
  cout << a << " " << b << "\n";
  while (n--) {
    cin >> c >> d;
    if (c.compare(a) == 0)
      a = d;
    else if (c.compare(b) == 0)
      b = d;
    else if (d.compare(a) == 0)
      a = c;
    else
      b = c;
    cout << a << " " << b << "\n";
  }
  return 0;
}
