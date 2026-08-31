#include <bits/stdc++.h>
using namespace std;
long long min(long long a, long long b) {
  if (a > b)
    return b;
  else
    return a;
}
bool possible(long long t, long long a, long long b, long long c) {
  long long down, need = 0;
  down = t * b;
  for (int i = 0; i <= c; i++) {
    if (need > down)
      return false;
    else {
      need += a;
      down += b;
    }
  }
  return true;
}
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long ans = 10000000;
  long long start = 1, end = 1000000, mid;
  while (start <= end) {
    mid = (start + end) / 2;
    if (possible(mid, a, b, c)) {
      ans = min(ans, mid);
      end = mid - 1;
    } else
      start = mid + 1;
    if (start == mid) {
      ans = min(ans, mid);
      break;
    }
  }
  cout << ans;
}
