#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  bool flag = false;
  long long sqr = sqrt((double)n) + 1;
  vector<long long> del;
  del.reserve(100);
  while (n % 2 == 0) {
    del.push_back(2);
    n /= 2;
  }
  for (long long i = 3; i <= sqr; i += 2) {
    while (n % i == 0) {
      del.push_back(i);
      n /= i;
    }
  }
  if (n > 1) del.push_back(n);
  if (del.size() <= 1) {
    cout << 1 << "\n0";
  }
  if (del.size() == 2) {
    cout << 2;
  }
  if (del.size() > 2) {
    long long res = del[0] * del[1];
    cout << 1 << "\n" << res;
  }
}
