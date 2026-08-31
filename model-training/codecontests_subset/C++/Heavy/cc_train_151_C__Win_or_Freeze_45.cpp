#include <bits/stdc++.h>
using namespace std;
const int M = 3000 + 10;
int main() {
  long long int q;
  cin >> q;
  long long int div1 = 0;
  for (long long int div = 2; div * div <= q; div++) {
    if (q % div == 0) {
      div1 = div;
      break;
    }
  }
  if (div1 == 0) {
    cout << "1" << endl;
    cout << "0" << endl;
  } else {
    long long int div2 = q / div1;
    bool isprime = true;
    for (long long int i = 2; i * i <= div1; i++) {
      if (div1 % i == 0) {
        isprime = false;
        break;
      }
    }
    for (long long int i = 2; i * i <= div2; i++) {
      if (div2 % i == 0) {
        isprime = false;
        break;
      }
    }
    if (isprime == true) {
      cout << "2" << endl;
    } else {
      cout << "1" << endl;
      long long int p1, p2;
      long long int backq = q;
      for (long long int div = 2; div * div <= q; div++) {
        if (q % div == 0) {
          p1 = div;
          q = q / p1;
          break;
        }
      }
      for (long long int div = p1; div * div <= q; div++) {
        if (q % div == 0) {
          p2 = div;
          break;
        }
      }
      cout << p1 * p2 << endl;
    }
  }
  return 0;
}
