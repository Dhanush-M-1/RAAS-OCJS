#include <bits/stdc++.h>
using namespace std;
const long long maxn = 3162280;
int comp[maxn];
int main() {
  ios::sync_with_stdio(false);
  long long q;
  cin >> q;
  long long cpy = q;
  vector<long long> pr;
  if (q % 2 == 0) {
    pr.push_back(2);
    while (q % 2 == 0) {
      q /= 2;
    }
  }
  if (q % 3 == 0) {
    pr.push_back(3);
    while (q % 3 == 0) {
      q /= 3;
    }
  }
  for (long long i = 6; (i - 1) * (i - 1) <= q; i += 6) {
    if (q % (i - 1) == 0) {
      pr.push_back(i - 1);
      while (q % (i - 1) == 0) {
        q /= i - 1;
      }
    }
    if (q % (i + 1) == 0) {
      pr.push_back(i + 1);
      while (q % (i + 1) == 0) {
        q /= i + 1;
      }
    }
    if (pr.size() >= 2) {
      break;
    }
  }
  if (q != 1) {
    pr.push_back(q);
  }
  if (pr.empty() or pr[0] == cpy) {
    cout << 1 << endl << 0;
  } else {
    if (pr.size() > 2 or (pr.size() == 2 and pr[0] * pr[1] < cpy)) {
      cout << 1 << endl << pr[0] * pr[1] << endl;
      return 0;
    } else if (pr.size() == 1 and pr[0] * pr[0] < cpy) {
      cout << 1 << endl << pr[0] * pr[0] << endl;
      return 0;
    }
    cout << 2;
  }
  return 0;
}
