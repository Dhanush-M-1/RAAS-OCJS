#include <bits/stdc++.h>
using namespace std;
template <class T>
T toDec(string s) {
  stringstream is(s);
  T res;
  is >> res;
  return res;
}
template <class T>
string toStr(T n) {
  string s;
  stringstream is;
  is << n;
  is >> s;
  return s;
}
template <class T>
bool isPrime(T x) {
  if (x <= 1) return false;
  T i;
  for (i = 2; i * i <= x; i++)
    if (x % i == 0) return false;
  return true;
}
template <class T>
double dist(T x1, T y1, T x2, T y2) {
  return sqrt(1. * (x2 - x1) * (x2 - x1) + 1. * (y2 - y1) * (y2 - y1));
}
template <class T>
class Prime {
 public:
  vector<T> z;
  Prime() {
    z.resize(1e5 + 7);
    for (int i = (0); i < (((int)z.size())); i++) z[i] = 1;
    z[0] = 0;
    z[1] = 0;
    T j;
    for (int i = (2); i < (((int)z.size())); i++) {
      if (z[i]) {
        j = i + i;
        while (j < ((int)z.size())) {
          z[j] = 0;
          j += i;
        }
      }
    }
  }
};
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  double x1, x2, d;
  if (a != 0) {
    if ((b * b) - 4 * a * c == 0)
      printf("1\n%.6f", 1. * -b / ((double)2 * a));
    else {
      if ((b * b) - 4 * a * c < 0)
        printf("0\n");
      else {
        d = sqrt(1. * ((b * b) - 4 * a * c));
        x1 = (1. * -b - d) / (1. * 2 * a);
        x2 = (1. * -b + d) / (1. * 2 * a);
        if (x1 < x2 + 1e-9)
          printf("2\n%.6lf\n%.6lf", x1, x2);
        else
          printf("2\n%.6lf\n%.6lf", x2, x1);
      }
    }
  } else {
    if (b == 0 && c == 0)
      printf("-1\n");
    else {
      if (b == 0)
        printf("0\n");
      else
        printf("1\n%.6lf\n", 1. * -c / b);
    }
  }
  return 0;
}
