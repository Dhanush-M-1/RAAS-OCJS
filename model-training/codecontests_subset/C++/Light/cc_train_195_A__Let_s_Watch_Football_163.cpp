#include <bits/stdc++.h>
using namespace std;
const long long int N = 1e5;
long long int i, j, k;
int main() {
  long long int p, k, a, b, c;
  cin >> a >> b >> c;
  k = (a - b) * c;
  p = ceil((float)k / b);
  cout << p;
}
