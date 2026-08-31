#include <bits/stdc++.h>
using namespace std;
long long n;
vector<long long> d;
int main() {
  cin >> n;
  for (int i = 2; i < 10000000; i++) {
    while (n % i == 0) {
      d.push_back(i);
      n /= i;
    }
  }
  if (n != 1) {
    d.push_back(n);
  }
  if (d.size() <= 1) {
    cout << 1 << endl << 0;
  } else if (d.size() == 2) {
    cout << 2;
  } else {
    cout << 1 << endl << d[0] * d[1];
  }
  return 0;
}
