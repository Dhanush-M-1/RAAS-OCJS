#include <bits/stdc++.h>
using namespace std;
long long a, b, c;
bool check(long long n) { return ((a * c + b - 1) / b - n <= c); }
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(0);
  cin >> a >> b >> c;
  long long l = -1;
  long long r = 1e9;
  while (l < r - 1) {
    long long m = (l + r) / 2;
    if (check(m))
      r = m;
    else
      l = m;
  }
  cout << r;
  return 0;
}
