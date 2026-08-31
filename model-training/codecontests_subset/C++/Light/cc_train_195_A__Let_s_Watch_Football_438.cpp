#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int l = 1, h = a * c, mid, ans;
  while (l <= h) {
    mid = l + (h - l) / 2;
    int temp = mid / b;
    if (temp * b + (b * c) < a * c)
      l = mid + 1;
    else {
      ans = temp;
      h = mid - 1;
    }
  }
  cout << ans;
}
