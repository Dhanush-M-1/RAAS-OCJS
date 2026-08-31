#include <bits/stdc++.h>
using namespace std;
int prim(long long x) {
  long long r = sqrt(x);
  for (long long i = 2; i <= r; ++i)
    if (x % i == 0) return 0;
  return 1;
}
int main() {
  long long q;
  long long i = 2;
  int nr = 0;
  cin >> q;
  if (q == 1) {
    cout << 1 << "\n" << 0 << '\n';
    return 0;
  }
  int fst = 2;
  if (prim(q)) {
    cout << 1 << "\n" << 0 << '\n';
    return 0;
  }
  vector<long long> sol;
  long long x = q;
  long long last = q;
  while (q > 1 && nr < 2) {
    while (q % i == 0 && nr < 2) {
      ++nr;
      sol.push_back(i);
      q /= i;
    }
    if (last != q && nr < 2 && prim(q)) {
      ++nr;
      sol.push_back(q);
      q = 1;
    }
    last = q;
    ++i;
  }
  long long p = sol[0] * sol[1];
  if (q == 1)
    cout << 2 << "\n";
  else
    cout << 1 << '\n' << p << '\n';
  return 0;
}
