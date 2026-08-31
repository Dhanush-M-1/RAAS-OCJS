#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, a, b, c, Res, download;
  while (cin >> a >> b >> c) {
    download = a * c;
    Res = download / b;
    if (download % b != 0) Res++;
    cout << Res - c << "\n";
  }
  return 0;
  return 0;
}
