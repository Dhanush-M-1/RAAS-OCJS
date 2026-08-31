#include <bits/stdc++.h>
using namespace std;
bool prost(long long a) {
  for (register int i = 2; i <= sqrt(a); ++i) {
    if (!(a % i)) {
      return false;
    }
  }
  return true;
}
long long del(long long q) {
  long long a = 1, max = -5, b;
  for (register long long i = 2; i <= sqrt(q); ++i) {
    if (!(q % i)) {
      if (prost(i)) {
        if (i != q / i && i * a != q) {
          if (a == 1) {
            a = i;
          } else {
            return a * i;
          }
        } else {
          return -5;
        }
      } else if (sqrt(i) * sqrt(i) == i) {
        return i;
      }
      b = sqrt(q / i);
      if (b * b == q / i) {
        if (max < 0) {
          max = q / i;
        } else {
          if (max > q / i) {
            max = q / i;
          }
        }
      }
    }
  }
  if (a == 1) {
    return 0;
  }
  return max;
}
int main(int argc, char *argv[]) {
  long long q;
  cin >> q;
  long long a = del(q);
  if (a >= 0) {
    cout << 1 << endl;
    cout << a;
  } else {
    cout << 2;
  }
  return 0;
}
