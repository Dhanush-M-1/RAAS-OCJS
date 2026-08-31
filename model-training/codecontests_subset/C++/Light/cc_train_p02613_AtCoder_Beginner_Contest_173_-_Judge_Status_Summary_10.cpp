#include <iostream>
using namespace std;
int main() {
  int N, C[4]{};
  cin >> N;
  string S;
  while (cin >> S)
    ++(S == "AC" ? C[0] : S == "WA" ? C[1] : S == "TLE" ? C[2] : C[3]);
  cout << "AC x " << C[0] << endl
       << "WA x " << C[1] << endl
       << "TLE x " << C[2] << endl
       << "RE x " << C[3] << endl;
}
