#include <bits/stdc++.h>
using namespace std;
static const double EPS = 1e-5;
int main() {
  long long q;
  cin >> q;
  int first = -1;
  int second = -1;
  int third = -1;
  for (long long i = 2; i * i <= q; i++) {
    if (q % i == 0) {
      if (first < 0)
        first = i;
      else if (second < 0) {
        if (i % first != 0) {
          second = i;
        } else {
        }
      } else if (third < 0) {
        third = i;
        break;
      }
    }
  }
  if (first < 0) {
    cout << "1" << endl << "0" << endl;
  } else if (second < 0) {
    if (first * (long long)first < q && q % (first * (long long)first) == 0) {
      cout << "1" << endl;
      cout << first * (long long)first << endl;
    } else {
      cout << "2" << endl;
    }
  } else {
    cout << "1" << endl;
    long long a = (long long)first;
    a *= second;
    cout << a << endl;
  }
  return 0;
}
