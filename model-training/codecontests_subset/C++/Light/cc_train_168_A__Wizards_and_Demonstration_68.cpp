#include <bits/stdc++.h>
using namespace std;
long long arr[51];
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  ceil(n * y / 100.0) < x ? cout << 0 : cout << ceil(n * y / 100.0) - x;
}
