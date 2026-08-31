#include <bits/stdc++.h>
using namespace std;
int a[1000], n;
int calc(int num) {
  int cnt = 0;
  while (num != 0) {
    a[++cnt] = num % n;
    num /= n;
  }
  int res = 0;
  for (int k = cnt; k >= 1; k--) res = res * 10 + a[k];
  return res;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      cout << calc(i * j) << " ";
    }
    cout << endl;
  }
  return 0;
}
