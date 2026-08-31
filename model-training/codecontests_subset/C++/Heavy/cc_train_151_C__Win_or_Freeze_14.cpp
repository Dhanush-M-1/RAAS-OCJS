#include <bits/stdc++.h>
const long long MOD = (1e9) + 7;
const double EPS = (1e-7);
int dcmp(double x, double y) { return abs(x - y) <= EPS ? 0 : x < y ? -1 : 1; }
inline void fast() {
  std::ios_base::sync_with_stdio(0);
  std::cin.tie(NULL);
  std::cout.tie(NULL);
  std::cerr.tie(NULL);
}
using namespace std;
bitset<3162278> vis;
long long x;
int main() {
  vis = 0;
  cin >> x;
  long long ans = 1;
  int con = 0;
  while (x != 1 && x % 2 == 0) {
    if (con < 2) {
      ans *= 2;
      con++;
    } else {
      cout << "1\n" << ans;
      return 0;
    }
    x /= 2;
  }
  for (int i = 3; i < 3162278; i += 2)
    if (vis[i] == 0) {
      while (x != 1 && x % i == 0) {
        if (con < 2) {
          ans *= i;
          con++;
        } else {
          cout << "1\n" << ans;
          return 0;
        }
        x /= i;
      }
      if (x == 1) break;
      for (int j = i; j < 3162278; j += i) vis[i] = 1;
    }
  if (con == 2 && x != 1)
    cout << "1\n" << ans;
  else if (con == 2 || (con == 1 && x != 1))
    cout << "2";
  else
    cout << "1\n0";
}
