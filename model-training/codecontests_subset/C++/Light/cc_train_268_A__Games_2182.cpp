#include <bits/stdc++.h>
using namespace std;
int n;
int h[2][30];
int check() {
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (h[0][i] == h[1][j] && j != i) {
        cnt++;
      }
    }
  }
  return cnt;
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> h[0][i] >> h[1][i];
  }
  cout << check();
}
