#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
int main() {
  long long n, x, y;
  cin >> n >> x >> y;
  long long X = y * n - x * 100;
  X = max((long long)0, (X + 99) / 100);
  cout << X << endl;
  return 0;
}
