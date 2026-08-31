#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, x;
  string f, s;
  cin >> f >> s;
  cin.ignore();
  cin >> n;
  cout << f << " " << s << "\n";
  for (i = 0; i < n; i++) {
    string a, b;
    cin >> a >> b;
    if (a == f)
      f = b;
    else if (a == s)
      s = b;
    cout << f << " " << s << "\n";
  }
}
