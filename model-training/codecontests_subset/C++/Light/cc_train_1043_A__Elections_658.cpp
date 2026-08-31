#include <bits/stdc++.h>
using namespace std;
const int NMAX = 105;
int N;
int a;
int amax;
int s1;
int k;
int main() {
  cin >> N;
  s1 = 0;
  amax = 0;
  for (int i = 0; i < N; ++i) {
    cin >> a;
    amax = max(a, amax);
    s1 += a;
  }
  k = (2 * s1) / N + 1;
  k = max(k, amax);
  cout << k << '\n';
  return 0;
}
