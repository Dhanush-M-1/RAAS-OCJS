#include <bits/stdc++.h>
const double eps = 1e-9;
const double pi = acos(-1);
const int oo = 1000000000;
const int mod = 1000000007;
const double E = 2.7182818284590452353602874713527;
using namespace std;
string a;
int main() {
  int b;
  cin >> a >> b;
  for (int i = 0; i < a.size(); i++) {
    if (a[i] >= 'A' && a[i] <= 'Z') a[i] += 'a' - 'A';
    if (a[i] - 'a' < b) a[i] -= 'a' - 'A';
  }
  cout << a << endl;
  return 0;
}
