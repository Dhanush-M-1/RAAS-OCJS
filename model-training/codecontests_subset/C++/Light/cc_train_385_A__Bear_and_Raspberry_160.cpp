#include <bits/stdc++.h>
using namespace std;
int countSetBits(int n) {
  int count = 0;
  while (n) {
    count += n & 1;
    n >>= 1;
  }
  return count;
}
void swap(char &c2, char &c1) {
  char temp = c2;
  c2 = c1;
  c1 = temp;
}
int main() {
  int n, a[100], b[100], k, sum = 0, ma = 0;
  cin >> n >> k;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) b[i] = a[i] - a[i + 1];
  for (int i = 0; i < n - 1; i++) {
    ma = max(ma, b[i]);
  }
  cout << max(ma - k, 0);
}
