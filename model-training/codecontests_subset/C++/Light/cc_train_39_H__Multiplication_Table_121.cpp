#include <bits/stdc++.h>
using namespace std;
void Cout(int x, int y) {
  int res = 0, y2 = 0, num[1005];
  memset(num, 0, sizeof(num));
  while (y) {
    num[y2++] = y % x;
    y /= x;
  }
  for (int i = y2 - 1; i >= 0; i--) cout << num[i];
}
int n;
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      Cout(n, i * j);
      cout << ' ';
    }
    cout << endl;
  }
}
