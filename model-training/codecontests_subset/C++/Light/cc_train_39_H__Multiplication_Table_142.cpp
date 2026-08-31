#include <bits/stdc++.h>
using namespace std;
int x[11][11];
int wei[100];
int get(int a, int k) {
  int ans = 0;
  int cnt = 0;
  while (a) {
    wei[cnt++] = (a % k);
    a /= k;
  }
  for (int i = cnt - 1; i >= 0; i--) {
    ans = ans * 10 + wei[i];
  }
  return ans;
}
int main() {
  for (int i = 1; i < 10; i++)
    for (int j = 1; j < 10; j++) {
      x[i][j] = i * j;
    }
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) cout << get(x[i][j], k) << " ";
    cout << endl;
  }
  return 0;
}
