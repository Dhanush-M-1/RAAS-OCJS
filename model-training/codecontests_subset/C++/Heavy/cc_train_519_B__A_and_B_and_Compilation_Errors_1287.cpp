#include <bits/stdc++.h>
using namespace std;
map<int, int> cnta;
map<int, int> cntb;
int a[100000 + 10];
int main() {
  int n, b, first = 0, second = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    ++cnta[a[i]];
  }
  for (int i = 1; i <= n - 1; i++) {
    cin >> b;
    ++cntb[b];
  }
  for (int i = 1; i <= n; i++) {
    if (cnta[a[i]] == cntb[a[i]] + 1) {
      first = a[i];
      break;
    }
  }
  cntb.clear();
  for (int i = 1; i <= n - 2; i++) {
    cin >> b;
    ++cntb[b];
  }
  for (int i = 1; i <= n; i++) {
    if (cnta[a[i]] == cntb[a[i]] + 1 && first != a[i]) {
      second = a[i];
      break;
    } else if (cnta[a[i]] == cntb[a[i]] + 2) {
      second = first;
      break;
    }
  }
  cout << first << endl << second << endl;
  return 0;
}
