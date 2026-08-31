#include <bits/stdc++.h>
using namespace std;
long long xA, yA, xB, yB, xC, yC, temp;
int main() {
  cin >> xA >> yA >> xB >> yB >> xC >> yC;
  for (int i = 0; i < 4; ++i) {
    long long xD = xB - xA, yD = yB - yA;
    if (xD == 0 && yD == 0) {
      cout << "YES" << endl;
      return 0;
    }
    long long n1 = xC * xD + yC * yD;
    long long n2 = -yC * xD + xC * yD;
    long long n3 = xC * xC + yC * yC;
    if (n3 > 0 && n1 % n3 == 0 && n2 % n3 == 0) {
      cout << "YES" << endl;
      return 0;
    }
    temp = xA;
    xA = -yA;
    yA = temp;
  }
  cout << "NO" << endl;
}
