#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  cin >> a >> b;
  long long n;
  scanf("%lli", &n);
  cout << a << " " << b << endl;
  for (long long i = 0; i < n; i++) {
    string c, d;
    cin >> c >> d;
    if (c == a)
      a = d;
    else if (c == b)
      b = d;
    cout << a << " " << b << endl;
  }
  return 0;
}
