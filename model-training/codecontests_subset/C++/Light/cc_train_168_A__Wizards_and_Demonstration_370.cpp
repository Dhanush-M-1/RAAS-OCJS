#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  long long n, x, y;
  cin >> n >> x >> y;
  long long t = ceil(n * y / 100.0);
  long long m = 0;
  cout << max(m, t - x) << endl;
  return 0;
}
