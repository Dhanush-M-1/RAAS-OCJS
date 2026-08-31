#include <bits/stdc++.h>
using namespace std;
int solve(double a, double b, double c) {
  int b2 = b;
  a = a * c;
  b = b * c;
  double x = a - b;
  return ceil(x / b2);
}
int main() {
  long long bs[1000000 + 1];
  for (int i = 0; i < 1000001; i++) {
    bs[i] = i;
  }
  double a, b, c;
  cin >> a >> b >> c;
  int End = 1000000, start = 0;
  while (End > start) {
    int mid = (End - start) / 2 + (start);
    if (bs[mid] < solve(a, b, c))
      start = mid + 1;
    else if (bs[mid] > solve(a, b, c))
      End = mid - 1;
    else
      End = mid;
  }
  cout << start << endl;
}
