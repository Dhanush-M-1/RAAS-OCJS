#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> A(100);
bool f(int m) {
  int k1 = 0, k2 = 0;
  for (int i = 0; i < n; i++) {
    k1 += A[i];
    k2 += m - A[i];
  }
  if (k2 > k1)
    return true;
  else
    return false;
}
int main() {
  cin >> n;
  int MAX = -1;
  for (int i = 0; i < n; i++) {
    cin >> A[i];
    if (A[i] > MAX) MAX = A[i];
  }
  int l = MAX - 1, r = 201;
  while (r - l > 1) {
    int m = (l + r) / 2;
    if (f(m))
      r = m;
    else
      l = m;
  }
  cout << r;
  return 0;
}
