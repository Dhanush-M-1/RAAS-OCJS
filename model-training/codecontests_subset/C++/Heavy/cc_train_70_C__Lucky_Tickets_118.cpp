#include <bits/stdc++.h>
using namespace std;
template <class T>
void pv(T a, T b) {
  for (T i = a; i != b; ++i) cerr << *i << ' ';
  cout << endl;
}
long long rev(long long x) {
  long long res = 0;
  for (; x; x /= 10) res = res * 10 + (x % 10);
  return res;
}
long long gcd(long long a, long long b) { return b != 0 ? gcd(b, a % b) : a; }
pair<long long, long long> gen(long long x, int s) {
  long long r = rev(x);
  long long g = gcd(x, r);
  x /= g;
  r /= g;
  if (s == 0)
    return make_pair(x, r);
  else
    return make_pair(r, x);
}
int main() {
  long long maxX, maxY, W;
  while (cin >> maxX >> maxY >> W) {
    map<pair<long long, long long>, int> countX, countY;
    for (int x = 1; x <= maxX; x++) {
      ++countX[gen(x, 0)];
    }
    long long best = maxX * maxY + 10;
    vector<int> res(2, -1);
    int curW = 0;
    long long y = 0;
    for (int x = maxX; x >= 1 && y <= maxY;) {
      if (curW >= W) {
        if (best > x * y) {
          best = x * y;
          res[0] = x;
          res[1] = y;
        }
      }
      if (curW < W) {
        y++;
        ++countY[gen(y, 1)];
        curW += countX[gen(y, 1)];
      } else {
        --countX[gen(x, 0)];
        curW -= countY[gen(x, 0)];
        x--;
      }
    }
    if (res[0] == -1)
      cout << res[0] << endl;
    else
      cout << res[0] << ' ' << res[1] << endl;
  }
  return 0;
}
