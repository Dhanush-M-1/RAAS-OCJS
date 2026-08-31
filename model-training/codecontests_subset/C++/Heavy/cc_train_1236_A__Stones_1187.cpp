#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int arr[101][101][101];
int fboii(int a, int b, int c) {
  if (arr[a][b][c] != -1) {
    return arr[a][b][c];
  }
  int ans1 = 0, ans2 = 0;
  if (a >= 1 && b >= 2) {
    ans1 = 3 + fboii(a - 1, b - 2, c);
  }
  if (b >= 1 && c >= 2) {
    ans2 = 3 + fboii(a, b - 1, c - 2);
  }
  arr[a][b][c] = max(ans1, ans2);
  return max(ans1, ans2);
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    for (int i = 0; i < 101; i++) {
      for (int j = 0; j < 101; j++) {
        for (int k = 0; k < 101; k++) {
          arr[i][j][k] = -1;
        }
      }
    }
    cout << fboii(a, b, c) << endl;
  }
}
