#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, pstart, pend;
  int t;
  cin >> t;
  for (int testcases = 1; testcases <= t; testcases++) {
    cin >> n >> pstart >> pend;
    bool completestart = true;
    bool completeend = true;
    bool flag = false;
    bool paranoidcheck = false;
    if (pstart == pend) {
      paranoidcheck = true;
    }
    if (pend == n * (n - 1) + 1) {
      if (pstart == pend) {
        cout << 1 << endl;
        continue;
      } else {
        flag = true;
        pend -= 1;
      }
    }
    if (pstart % 2 == 0) {
      completestart = false;
    } else {
      pstart += 1;
    }
    pstart /= 2;
    if (pend % 2 == 1) {
      completeend = false;
      pend += 1;
    }
    pend /= 2;
    long long iter = pend - pstart;
    if (paranoidcheck) {
      iter -= 1;
    }
    long long a = 1;
    long long b = 1;
    while (pstart - (n - a) > 0) {
      pstart -= (n - a);
      a += 1;
    }
    b = a + pstart;
    if (!completestart) {
      cout << b << " ";
      if (b < n) {
        b += 1;
      } else {
        a += 1;
        b = a + 1;
      }
      iter -= 1;
    }
    if (!completeend) {
      iter -= 1;
    }
    for (int k = 0; k <= iter; k++) {
      cout << a << " " << b << " ";
      if (b < n) {
        b += 1;
      } else {
        a += 1;
        b = a + 1;
      }
    }
    if (!completeend) {
      cout << a << " ";
    }
    if (flag) {
      cout << 1;
    }
    cout << endl;
  }
  return 0;
}
