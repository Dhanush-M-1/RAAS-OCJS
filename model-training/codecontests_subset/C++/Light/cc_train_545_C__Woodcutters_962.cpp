#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, w = 2;
  cin >> n;
  if (n == 1) return cout << 1, 0;
  long long coor[2][n];
  long long hight[n];
  for (long long i = 0; i < n; i++) {
    cin >> coor[0][i] >> hight[i];
    coor[1][i] = coor[0][i];
  }
  for (long long i = 1; i < n - 1; i++) {
    if (coor[0][i] - hight[i] > coor[1][i - 1]) {
      coor[0][i] -= hight[i];
      w++;
    } else if (coor[1][i] + hight[i] < coor[0][i + 1]) {
      coor[1][i] += hight[i];
      w++;
    }
  }
  cout << w;
  return 0;
}
