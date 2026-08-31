#include <bits/stdc++.h>
using namespace std;
int main() {
  float n, k, y, s, per;
  cin >> n >> k >> y;
  per = (n * y) / 100;
  s = per - (int)per;
  if (s != 0) per = (int)per + 1;
  if ((per - k) > 0) {
    cout << per - k;
  } else {
    cout << "0";
  }
}
