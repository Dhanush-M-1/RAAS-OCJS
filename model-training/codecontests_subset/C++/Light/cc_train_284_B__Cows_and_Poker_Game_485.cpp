#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T abs(T x) {
  if (x < 0) return -x;
  return x;
}
int n, res, nI, nA, nF;
string str;
int main() {
  cin >> n;
  cin >> str;
  nI = 0;
  nA = 0;
  nF = 0;
  for (int i = 0; i < n; i++) {
    if (str[i] == 'A') {
      nA++;
    } else if (str[i] == 'F') {
      nF++;
    } else {
      nI++;
    }
  }
  res = 0;
  for (int i = 0; i < n; i++)
    if (str[i] == 'A') {
      if (nI == 0) res++;
    } else if (str[i] == 'I') {
      if (nI == 1) res++;
    }
  cout << res << endl;
  return 0;
}
