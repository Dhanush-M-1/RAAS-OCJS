#include <bits/stdc++.h>
using namespace std;
const int inf(1010101010);
int n, a, b, c;
long long s(0);
int main() {
  cin >> n >> a >> b >> c;
  n *= 2;
  for (int nA(0); nA <= a; nA++)
    for (int nB(0); nB <= b; nB++) {
      int tot(nA + nB * 2);
      if (tot % 4 != n % 4) continue;
      int nC((n - tot) / 4);
      if (0 <= nC && nC <= c) s += 1;
    }
  cout << s << endl;
}
