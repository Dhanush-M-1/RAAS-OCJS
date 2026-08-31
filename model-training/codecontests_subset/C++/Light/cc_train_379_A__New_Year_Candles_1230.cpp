#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:60777216")
using namespace std;
int res, du, a, b, i;
int main() {
  cin >> a >> b;
  res = du = 0;
  for (i = 1; i <= a; i++) {
    res++;
    du++;
    if (du == b) {
      a++;
      du = 0;
    }
  }
  cout << res;
}
