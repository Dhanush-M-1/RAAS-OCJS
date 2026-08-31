#include <bits/stdc++.h>
using namespace std;
int main() {
  int A, B;
  cin >> A >> B;
  int Temp = A;
  for (int i = 1; i <= A; ++i) {
    if (i % B == 0) {
      A++;
    }
  }
  cout << A << endl;
  return 0;
}
