#include <bits/stdc++.h>
using namespace std;
int main() {
  long long i;
  long long q;
  vector<long long> v;
  while (cin >> q) {
    v.clear();
    for (i = 2; i * i <= q; i++)
      while (q % i == 0) {
        v.push_back(i);
        q /= i;
      }
    if (q > 1) v.push_back(q);
    if (v.size() < 2)
      printf("1\n0\n");
    else if (v.size() == 2)
      printf("2\n");
    else
      printf("1\n%d\n", v[0] * v[1]);
  }
  return 0;
}
