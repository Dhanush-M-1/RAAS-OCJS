#include <bits/stdc++.h>
using namespace std;
int n, cnt1, cnt0, arr[110];
char c, op[110];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int i = 1;
  while (c != '=') {
    cin >> c;
    if (c == '+') {
      cnt1++;
      op[i++] = c;
    }
    if (c == '-') {
      cnt0++;
      op[i++] = c;
    }
  }
  op[0] = '+';
  cnt1++;
  cin >> n;
  int x = cnt1 - cnt0;
  for (int j = 0; j < i; j++) {
    arr[j] = 1;
    if (op[j] == '+') {
      while (x < n && arr[j] < n) {
        arr[j]++;
        x++;
      }
    } else {
      while (x > n && arr[j] < n) {
        arr[j]++;
        x--;
      }
    }
  }
  int y;
  y++;
  if (x != n)
    cout << "Impossible\n";
  else {
    cout << "Possible\n" << arr[0] << ' ';
    for (int j = 1; j < i; j++) cout << op[j] << ' ' << arr[j] << ' ';
    cout << "= " << n << endl;
  }
  return 0;
}
