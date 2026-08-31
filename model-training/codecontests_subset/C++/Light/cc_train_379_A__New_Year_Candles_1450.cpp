#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6;
const int N = 81;
const int delta = 10453;
long long n, a[maxn], c, p;
int main() {
  cin >> n >> p;
  for (int i = 1; i <= n; i++) {
    if (i % p == 0) n++;
  }
  cout << n;
}
