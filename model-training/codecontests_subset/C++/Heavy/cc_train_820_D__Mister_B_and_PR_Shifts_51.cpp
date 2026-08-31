#include <bits/stdc++.h>
int main() {
  long long n;
  std::cin >> n;
  long long inversion = 0;
  std::vector<long long> a;
  a.reserve(n);
  std::vector<long long> chan(n, 0);
  long long total = 0;
  for (long long i = 0; i < n; ++i) {
    long long b;
    std::cin >> b;
    a.push_back(b);
    inversion += abs(b - i - 1);
    if (b > i + 1) {
      total++;
    }
    ++chan[(b - i - 1 + n) % n];
  }
  long long min = inversion;
  long long id = 0;
  for (long long i = n - 1; i > 0; --i) {
    inversion -= total;
    inversion += n - total;
    inversion -= n + 1 - a[i];
    inversion += a[i] - 1;
    total -= chan[n - i] - 1;
    if (min > inversion) {
      min = inversion;
      id = n - i;
    }
  }
  std::cout << min << " " << id << std::endl;
}
