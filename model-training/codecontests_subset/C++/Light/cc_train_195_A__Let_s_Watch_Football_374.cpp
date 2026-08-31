#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  double data = a * c;
  double all = a * c / b;
  int wait = int(all) - int(c);
  if (all > int(all)) wait++;
  cout << wait << endl;
}
