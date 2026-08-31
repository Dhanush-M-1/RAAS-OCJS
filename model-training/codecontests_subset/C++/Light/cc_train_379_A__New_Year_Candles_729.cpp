#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int A, B;
  cin >> A >> B;
  long long int total = A;
  while (true) {
    long long int div = A / B;
    total += div;
    A = div + (A % B);
    if (A < B) break;
  }
  cout << total << endl;
  return 0;
}
