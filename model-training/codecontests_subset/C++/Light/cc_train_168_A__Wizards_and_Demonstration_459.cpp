#include <bits/stdc++.h>
using namespace std;
clock_t _start_clock = clock();
inline void _time() {}
inline int log(const char* format, ...) { return 0; }
const double EPS = 10e-6;
const int MAX = 100;
const int INF = 1 << 30;
int main(int argc, char* argv[]) {
  double n, x, y, p, c;
  cin >> n >> x >> y;
  c = x;
  while (true) {
    p = 100 * c / n;
    if (p >= y) break;
    c += 1;
  }
  cout << c - x << endl;
  _time();
  return EXIT_SUCCESS;
}
