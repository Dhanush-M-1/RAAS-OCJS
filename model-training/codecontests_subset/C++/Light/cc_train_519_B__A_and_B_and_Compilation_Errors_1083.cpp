#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  long long sA = 0, sB = 0, sC = 0;
  cin >> n;
  std::vector<long long> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sA += a[i];
  }
  std::vector<long long> b(n - 1);
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    sB += b[i];
  }
  std::vector<long long> c(n - 2);
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    sC += c[i];
  }
  cout << sA - sB << "\n" << sB - sC << "\n";
  return 0;
}
