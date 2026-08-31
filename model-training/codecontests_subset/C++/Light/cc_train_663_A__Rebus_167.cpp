#include <bits/stdc++.h>
using namespace std;
int main() {
  string inp, ans;
  int plscnt = 0, mnscnt = 0, n = 0;
  getline(cin, inp);
  int i = 0;
  while (i < inp.size()) {
    if (inp[i] == '=') {
      i += 2;
      while (i < inp.size()) n = 10 * n + inp[i++] - '0';
      break;
    } else if (inp[i] == '+')
      plscnt++;
    else if (inp[i] == '-')
      mnscnt++;
    i++;
  }
  plscnt++;
  int mn = plscnt - n * mnscnt;
  int mx = n * (plscnt)-mnscnt;
  if (n > mx || n < mn) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  i = 0;
  int currsm = 0, sgn = 1;
  while (inp[i] != '=') {
    if (inp[i] == ' ') {
      i++;
      continue;
    }
    if (inp[i] == '+') {
      sgn = 1;
      cout << "+ ";
      i++;
      continue;
    } else if (inp[i] == '-') {
      sgn = -1;
      cout << "- ";
      i++;
      continue;
    }
    sgn == 1 ? plscnt-- : mnscnt--;
    for (int nxtnum = 1; nxtnum <= n; nxtnum++) {
      if ((currsm + nxtnum * sgn + plscnt * n - mnscnt >= n) &&
          (currsm + nxtnum * sgn + plscnt - n * mnscnt <= n)) {
        cout << nxtnum << " ";
        currsm += nxtnum * sgn;
        break;
      }
    }
    i++;
  }
  cout << "= " << n;
  return 0;
}
