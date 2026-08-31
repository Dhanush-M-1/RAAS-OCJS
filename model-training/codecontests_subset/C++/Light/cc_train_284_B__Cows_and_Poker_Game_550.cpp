#include <bits/stdc++.h>
using namespace std;
const int inf = 1 << 29;
const double dinf = 1e30;
const long long linf = 1LL << 55;
int n;
string str;
int main() {
  while (cin >> n >> str) {
    int cntI = 0;
    int cntA = 0;
    for (int i = 0; i < str.length(); i++) {
      cntI += str[i] == 'I';
      cntA += str[i] == 'A';
    }
    if (cntI >= 2) {
      cout << 0 << endl;
    } else if (cntI == 1) {
      cout << 1 << endl;
    } else
      cout << cntA << endl;
  }
  return 0;
}
