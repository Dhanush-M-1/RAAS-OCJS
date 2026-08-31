#include <bits/stdc++.h>
using namespace std;
long long p[100005], pn[100005];
long long n, m;
int main() {
  cin >> n;
  if (n == 1) {
    cout << 1 << endl << 0 << endl;
    return 0;
  }
  m = n;
  int k = 0;
  long long i;
  int cnt = 0;
  int sum = 0;
  for (i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      int cnt = 0;
      while (n % i == 0) {
        n /= i;
        cnt++;
        sum++;
      }
      pn[k] = cnt;
      p[k++] = i;
    }
  }
  if (n != 1) {
    p[k] = n;
    pn[k++] = 1;
    sum++;
  }
  if (k == 1 && pn[0] == 1) {
    cout << 1 << endl << 0 << endl;
  } else {
    if (sum > 2) {
      cout << 1 << endl;
      if (k == 1)
        cout << p[0] * p[0] << endl;
      else
        cout << p[0] * p[1] << endl;
    } else
      cout << 2 << endl;
  }
}
