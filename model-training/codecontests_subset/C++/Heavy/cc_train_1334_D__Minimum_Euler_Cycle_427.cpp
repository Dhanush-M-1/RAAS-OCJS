#include <bits/stdc++.h>
using namespace std;
void print_pattern(long long row, long long col, long long count,
                   long long elements) {
  if (elements == 0) {
    cout << 1 << " ";
    return;
  }
  long long x = row;
  long long next_x = row + 1;
  long long j = 0;
  bool flag = 1;
  while (j < elements && count > 0) {
    if (j >= col) {
      cout << x << " ";
      count--;
    }
    if (flag) {
      x = next_x;
      next_x++;
    } else {
      x = row;
    }
    flag = !flag;
    j++;
  }
  if (count > 0) {
    print_pattern(row + 1, 0, count, elements - 2);
  }
}
void solve() {
  long long n, l, r, count;
  cin >> n >> l >> r;
  count = r - l + 1;
  bool zero_flag = 0;
  long long i, j, row;
  long long to_subtract = 2 * (n - 1);
  row = 1;
  while (l - to_subtract > 0) {
    l -= to_subtract;
    to_subtract -= 2;
    row++;
    if (to_subtract == 0) {
      zero_flag = 1;
      break;
    }
  }
  if (zero_flag) {
    cout << 1 << endl;
    return;
  }
  if (l == 0) {
    row++;
  } else {
    l--;
  }
  print_pattern(row, l, count, to_subtract);
  cout << endl;
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
