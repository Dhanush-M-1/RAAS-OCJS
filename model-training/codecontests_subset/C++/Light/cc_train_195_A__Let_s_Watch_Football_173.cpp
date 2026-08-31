#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c;
  cin >> a >> b >> c;
  int x = (a * c) - (b * c);
  int rem = 0;
  rem = ceil((float)x / b);
  cout << rem;
}
