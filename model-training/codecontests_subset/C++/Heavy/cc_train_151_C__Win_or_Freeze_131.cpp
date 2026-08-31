#include <bits/stdc++.h>
using namespace std;
bool flag[3500000 + 5];
vector<long long> vec, divisor;
void seive() {
  for (int i = 3; i * i <= 3500000; i += 2) {
    if (!flag[i]) {
      for (int j = i * i; j <= 3500000; j += 2 * i) {
        flag[j] = 1;
      }
    }
  }
  vec.push_back(2);
  for (long long i = 3; i <= 3500000; i += 2) {
    if (!flag[i]) {
      vec.push_back(i);
    }
  }
}
long long factorize(long long n) {
  bool expo = 0;
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      expo = 1;
      while (n % i == 0) {
        n /= i;
        divisor.push_back(i);
      }
    }
  }
  if (n > 1) {
    divisor.push_back(n);
  }
  if (!expo)
    return 0;
  else
    return 1;
}
int main() {
  long long q, tmp, cnt = 0, f = 0;
  cin >> q;
  if (q <= 3) {
    cout << "1" << endl << f << endl;
    return 0;
  }
  tmp = q;
  if (!factorize(q)) {
    cout << "1" << endl << f << endl;
    return 0;
  } else if (divisor.size() > 2) {
    cout << "1" << endl << divisor[0] * divisor[1] << endl;
    return 0;
  } else {
    cout << "2" << endl;
    return 0;
  }
  return 0;
}
