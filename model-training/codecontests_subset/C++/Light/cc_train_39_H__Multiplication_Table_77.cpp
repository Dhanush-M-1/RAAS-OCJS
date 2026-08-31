#include <bits/stdc++.h>
using namespace std;
const int N = 105;
int k;
void out(int n, int k) {
  if (n == 0) return;
  out(n / k, k);
  cout << n % k;
}
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      int num = i * j;
      out(num, k);
      cout << (j == k - 1 ? "\n" : " ");
    }
  }
  return 0;
}
