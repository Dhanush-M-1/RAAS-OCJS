#include <bits/stdc++.h>
using namespace std;
long long div(long long a) {
  int B = min((long long)sqrt(a) + 1, a - 1);
  for (int i = 2; i <= B; ++i) {
    if (a % i == 0) return i;
  }
  return -1;
}
int main() {
  long long a;
  cin >> a;
  vector<long long> f;
  while (true) {
    long long x = div(a);
    if (x == -1) break;
    a /= x;
    f.push_back(x);
  }
  f.push_back(a);
  if (f.size() == 1) cout << "1\n0\n";
  if (f.size() == 2) cout << "2\n";
  if (f.size() > 2) cout << "1\n" << f[0] * f[1] << '\n';
  return 0;
}
