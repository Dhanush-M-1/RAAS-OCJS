#include <bits/stdc++.h>
using namespace std;
long long q;
bool zhi(long long now) {
  if (now < 2) return false;
  if (now == 2) return true;
  for (long long a = 2; a * a <= now; a++)
    if (now % a == 0) return false;
  return true;
}
int main() {
  cin >> q;
  if (q == 1 || zhi(q)) {
    printf("1\n0\n");
    return 0;
  }
  for (long long a = 2; a * a <= q; a++) {
    if (q % a == 0) {
      long long half = q / a;
      if (zhi(half)) {
        printf("2\n");
      } else {
        printf("1\n");
        for (long long b = 2; b * b <= half; b++)
          if (half % b == 0) {
            cout << b * a << endl;
            break;
          }
      }
      return 0;
    }
  }
}
