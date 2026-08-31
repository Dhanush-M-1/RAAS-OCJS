#include <bits/stdc++.h>
using namespace std;
int main(void) {
  long long n, x, y;
  cin >> n >> x >> y;
  cout << max(0LL, ((n * y + 99) / 100 - x));
}
