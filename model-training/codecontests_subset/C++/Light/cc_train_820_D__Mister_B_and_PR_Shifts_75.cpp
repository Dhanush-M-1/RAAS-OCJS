#include <bits/stdc++.h>
using namespace std;
map<int, int> b;
int sib = 0;
long long ansb = 0;
int k[1000005];
int main() {
  int n, ansk = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", k + i);
    if (k[i] > i) {
      ++b[k[i] - i];
      ansb += k[i] - i;
      ++sib;
    }
  }
  long long mi = ansb;
  int co = 0;
  for (int i = n; i > 1; --i) {
    ++co;
    ansb -= sib;
    sib -= b[co];
    if (k[i] > n + 1) {
      --b[k[i] - n - 1 + co];
      ansb -= k[i] - n - 1;
      --sib;
    }
    if (k[i] > 1) {
      ++b[k[i] - 1 + co];
      ansb += k[i] - 1;
      ++sib;
    }
    if (mi > ansb) {
      mi = ansb;
      ansk = co;
    }
  }
  cout << mi * 2 << ' ' << ansk << endl;
  return 0;
}
