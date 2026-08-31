#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x1, x2, s = 0;
  cin >> n;
  pair<long long, long long> b[n];
  for (long long i = 0; i < n; i++) {
    cin >> b[i].first >> b[i].second;
  }
  if (n == 1) {
    return cout << 1, 0;
  } else if (n == 2) {
    return cout << 2, 0;
  }
  sort(b, b + n);
  x1 = b[0].first;
  for (long long i = 1; i < n - 1; i++) {
    x2 = b[i + 1].first;
    if (b[i].first - b[i].second > x1) {
      x1 = b[i].first;
      s++;
    } else if (b[i].first + b[i].second < x2) {
      x1 = b[i].first + b[i].second;
      s++;
    } else {
      x1 = b[i].first;
    }
  }
  cout << s + 2;
}
