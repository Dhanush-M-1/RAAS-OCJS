#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int inf = (int)1e9;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ;
  long long q;
  cin >> q;
  if (q == 1) {
    cout << "1\n0";
    return 0;
  }
  map<long long, int> fac;
  vector<long long> ff;
  long long mul = q;
  for (long long i = 2; i * i <= q; ++i) {
    if (q % i == 0) {
      int c = 0;
      while (q % i == 0) {
        q /= i;
        ++c;
      }
      fac[i] = c;
      ff.push_back(i);
    }
  }
  if (q > 1) {
    fac[q] = 1;
    ff.push_back(q);
  }
  if (ff.size() > 2) {
    cout << "1\n";
    cout << (ff[0] * ff[1]);
  } else if (ff.size() == 2) {
    if (fac[ff[0]] > 1 || fac[ff[1]] > 1) {
      cout << 1 << endl;
      cout << (ff[0] * ff[1]);
    } else
      cout << 2;
  } else if (ff.size() == 1) {
    if (fac[ff[0]] > 2) {
      cout << "1\n";
      cout << ff[0] * ff[0];
    } else if (fac[ff[0]] == 1) {
      cout << "1\n";
      cout << 0;
    } else {
      cout << 2;
    }
  } else {
    cout << 2;
  }
  return 0;
}
