#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  while (cin >> n) {
    vector<long long> vec;
    for (long long i = 2; i * i <= n; i++) {
      while (n % i == 0) {
        vec.push_back(i);
        n /= i;
      }
    }
    if (n > 1) {
      vec.push_back(n);
    }
    if (vec.size() < 2) {
      printf("1\n0\n");
    } else if (vec.size() == 2) {
      printf("2\n");
    } else {
      printf("1\n%lld\n", vec[0] * vec[1]);
    }
  }
  return 0;
}
