#include <bits/stdc++.h>
using namespace std;
int main() {
  long long Q, q;
  cin >> Q;
  q = Q;
  bool isPrime = true;
  int primeNumber = 2;
  int sNo = sqrtl(q);
  long long pOne = -1, pTwo = -1;
  int countOne = 0, countTwo = 0;
  while (primeNumber <= sNo && q > 1) {
    while (q > 1 && q % primeNumber == 0) {
      if (pOne == -1)
        pOne = primeNumber;
      else if (pOne != primeNumber)
        pTwo = primeNumber;
      if (primeNumber == pOne)
        countOne++;
      else
        countTwo++;
      q /= primeNumber;
    }
    primeNumber++;
  }
  if (pOne == -1 && pTwo == -1)
    cout << "1\n0";
  else if (pOne != -1 && pTwo == -1) {
    if (countOne > 2) {
      cout << "1\n";
      cout << pOne * pOne;
    } else if (countOne < 2)
      cout << '2';
    else {
      if (pOne * pOne == Q)
        cout << '2';
      else {
        cout << "1\n";
        cout << pOne * pOne;
      }
    }
  } else {
    cout << "1\n";
    cout << pOne * pTwo;
  }
  cout << '\n';
}
