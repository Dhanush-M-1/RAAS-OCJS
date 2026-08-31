#include <bits/stdc++.h>
using namespace std;
int main(int argc, const char* argv[]) {
  int n, x, y;
  cin >> n >> x >> y;
  if (x * 100 >= y * n) {
    cout << 0;
  } else {
    cout << (y * n - x * 100 + 99) / 100;
  }
  return 0;
}
