#include <bits/stdc++.h>
using namespace std;
signed long long tonum(string s) {
  stringstream in(s);
  signed long long x;
  in >> x;
  return x;
}
string tostr(signed long long n) {
  stringstream in;
  in << n;
  string x;
  in >> x;
  return x;
}
signed long long gcd(signed long long a, signed long long b) {
  while (1) {
    a = a % b;
    if (a == 0) return b;
    b = b % a;
    if (b == 0) return a;
  }
}
int main() {
  signed long long A, B, C;
  cin >> A >> B >> C;
  if (A == 0) {
    if (B == 0) {
      if (C == 0)
        printf("-1\n");
      else
        printf("0\n");
    } else {
      printf("1\n");
      printf("%.9lf\n", double(0 - C) / double(B));
    }
  } else if (B == 0) {
    if (C * A > 0)
      printf("0\n");
    else if (C == 0) {
      printf("1\n");
      printf("%.9lf\n", 0.0);
    } else {
      printf("2\n");
      printf("%.9lf\n", sqrt((0.0 - double(C)) / double(A)) * -1);
      printf("%.9lf\n", sqrt((0.0 - double(C)) / double(A)));
    }
  } else {
    signed long long D = B * B - 4 * A * C;
    if (D < 0)
      printf("0\n");
    else if (D == 0) {
      printf("1\n");
      printf("%.9lf\n", double(0.0 - double(B)) / (2.0 * double(A)));
    } else {
      printf("2\n");
      if (A >= 0) {
        printf("%.9lf\n",
               (double(0.0 - double(B)) - sqrt(double(D))) / (2.0 * double(A)));
        printf("%.9lf\n",
               (double(0.0 - double(B)) + sqrt(double(D))) / (2.0 * double(A)));
      } else {
        printf("%.9lf\n",
               (double(0.0 - double(B)) + sqrt(double(D))) / (2.0 * double(A)));
        printf("%.9lf\n",
               (double(0.0 - double(B)) - sqrt(double(D))) / (2.0 * double(A)));
      }
    }
  }
  return 0;
}
