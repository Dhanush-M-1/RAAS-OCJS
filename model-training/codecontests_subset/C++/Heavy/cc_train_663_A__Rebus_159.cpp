#include <bits/stdc++.h>
using namespace std;
const int NMAX = 1007;
char s[NMAX];
int nrm, nrp;
int main() {
  gets(s + 2);
  s[0] = '+';
  s[1] = ' ';
  int n = strlen(s) - 1;
  for (int i = 0; i <= n; ++i) {
    if (s[i] == '-') {
      ++nrm;
    }
    if (s[i] == '+') {
      ++nrp;
    }
  }
  int sum = 0;
  for (int i = 1; i <= n; ++i) {
    if (s[i] >= '0' && s[i] <= '9') {
      sum = sum * 10 + s[i] - '0';
    }
  }
  int S = sum;
  sum += nrm;
  int ok = 0;
  if (sum % nrp > 0) {
    ok = 1;
  } else {
    ok = 0;
  }
  if (sum / nrp + ok > S || sum / nrp < 1) {
    sum -= nrm;
    swap(nrm, nrp);
    sum = nrm - sum;
    ok = 0;
    if (nrp == 0) {
      cout << "Impossible";
      return 0;
    }
    if (sum % nrp > 0) {
      ok = 1;
    } else {
      ok = 0;
    }
    if (sum / nrp + ok > S || sum / nrp < 1 || sum < 0) {
      cout << "Impossible";
    } else {
      cout << "Possible\n";
      int cat = sum / nrp;
      int rest = sum % nrp;
      for (int i = 2; i <= n; ++i) {
        if (s[i] == '?') {
          if (s[i - 2] == '-') {
            if (rest > 0) {
              cout << cat + 1;
              --rest;
            } else {
              cout << cat;
            }
          }
          if (s[i - 2] == '+') {
            cout << 1;
          }
        } else {
          cout << s[i];
        }
      }
    }
  } else {
    cout << "Possible\n";
    int cat = sum / nrp;
    int rest = sum % nrp;
    for (int i = 2; i <= n; ++i) {
      if (s[i] == '?') {
        if (s[i - 2] == '+') {
          if (rest > 0) {
            cout << cat + 1;
            --rest;
          } else {
            cout << cat;
          }
        }
        if (s[i - 2] == '-') {
          cout << 1;
        }
      } else {
        cout << s[i];
      }
    }
  }
  return 0;
}
