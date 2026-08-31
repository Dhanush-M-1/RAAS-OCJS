#include <bits/stdc++.h>
using namespace std;
int n;
char arth[100] = {'+'};
int main() {
  char c = 'h';
  int cindex = 0;
  int addN = 1;
  int subN = 0;
  while (c != '=') {
    cin >> c;
    if (c == '?' || c == '=') continue;
    if (c == '+') {
      arth[cindex] = '+';
      cindex++;
      addN++;
    } else {
      arth[cindex] = '-';
      cindex++;
      subN++;
    }
  }
  cin >> n;
  int lFactor = 1;
  for (; lFactor <= n; lFactor++) {
    int total = n + lFactor * subN;
    int quotient = total / addN;
    int remainder = total % addN;
    if (quotient <= 0) continue;
    if (quotient > n || (quotient == n && remainder > 0)) {
      cout << "Impossible";
    } else if (remainder == 0) {
      cout << "Possible" << endl;
      cout << quotient << " ";
      for (int i = 0; i < cindex; i++) {
        cout << arth[i] << " ";
        if (arth[i] == '+')
          cout << quotient << " ";
        else
          cout << lFactor << " ";
      }
      cout << "= " << n;
    } else {
      int numN = 1;
      for (; numN <= addN; numN++) {
        int mod = remainder % numN;
        int firsts = quotient + remainder / numN;
        int lastAdd = firsts + mod;
        if (lastAdd > n) continue;
        cout << "Possible" << endl;
        int k = numN;
        cout << quotient << " ";
        for (int i = 0; i < cindex; i++) {
          cout << arth[i] << " ";
          if (arth[i] == '+') {
            if (k == 1) {
              cout << lastAdd << " ";
              k--;
            } else if (k > 0) {
              cout << firsts << " ";
              k--;
            } else {
              cout << quotient << " ";
            }
          } else
            cout << lFactor << " ";
        }
        cout << "= " << n;
        break;
      }
      if (numN > addN) {
        cout << "Impossible";
      }
    }
    break;
  }
  if (lFactor > n) cout << "Impossible";
  return 0;
}
