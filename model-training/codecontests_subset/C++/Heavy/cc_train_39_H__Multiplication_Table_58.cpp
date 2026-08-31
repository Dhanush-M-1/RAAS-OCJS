#include <bits/stdc++.h>
using namespace std;
int multi(int i, int j, int n) {
  int x = i * j;
  int y;
  int p = 1;
  int sum = 0;
  while (x != 0) {
    sum = sum + (x % n) * p;
    x = x / n;
    p = p * 10;
  }
  return sum;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  int arr[n - 1][n - 1];
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1; j++) {
      arr[i][j] = multi(i + 1, j + 1, n);
    }
  }
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1; j++) {
      cout << arr[i][j];
      if (arr[i][j] < 10) {
        cout << "  ";
      } else {
        cout << " ";
      }
    }
    cout << '\n';
  }
  return 0;
}
