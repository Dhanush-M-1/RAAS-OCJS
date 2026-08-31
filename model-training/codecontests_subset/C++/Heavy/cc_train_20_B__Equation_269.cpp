#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  long long iA, iB, iC, iDelta;
  double iX1, iX2;
  cin >> iA >> iB >> iC;
  if (iA == 0) {
    if (iB == 0 && iC == 0) {
      cout << -1;
      goto endapp;
    } else if (iB == 0 && iC != 0) {
      cout << 0;
      goto endapp;
    } else {
      iX1 = double(-iC) / double(iB);
      cout.setf(ios::fixed);
      cout << 1 << setprecision(10) << endl << iX1;
      goto endapp;
    }
  }
  iDelta = iB * iB - 4 * iA * iC;
  if (iDelta < 0) {
    cout << 0;
    goto endapp;
  }
  iX1 = (double(-iB) - sqrt(iDelta)) / (2 * double(iA));
  iX2 = (double(-iB) + sqrt(iDelta)) / (2 * double(iA));
  if (iX1 > iX2) {
    swap(iX1, iX2);
  }
  if (iDelta != 0) {
    cout.setf(ios::fixed);
    cout << 2 << '\n' << setprecision(10) << iX1 << '\n' << iX2;
  } else {
    cout.setf(ios::fixed);
    cout << 1 << '\n' << setprecision(10) << iX1;
  }
endapp:
  return 0;
}
