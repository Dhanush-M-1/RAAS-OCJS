#include <bits/stdc++.h>
using namespace std;
template <typename T>
string toString(T x) {
  if (x == 0) return "0";
  bool negative = x < 0;
  string res;
  while (x) {
    res.push_back('0' + x % 10);
    x /= 10;
  }
  if (negative) res.push_back('-');
  reverse(res.begin(), res.end());
  return res;
}
void ioFromFile(string inputFileName, string outputFileName) {
  ifstream fin(inputFileName);
  ofstream fout(outputFileName);
  cin.rdbuf(fin.rdbuf());
  cout.rdbuf(fout.rdbuf());
}
int read() {
  int res;
  scanf("%d", &res);
  return res;
}
template <typename T>
T gcd(T a, T b) {
  return a == 0 ? b : gcd(b % a, a);
}
template <typename T>
T lcm(T a, T b) {
  return a / gcd(a, b) * b;
}
int main() {
  int r0, r1, c0, c1, d0, d1;
  cin >> r0 >> r1 >> c0 >> c1 >> d0 >> d1;
  int res[2][2];
  res[0][0] = r0 + c0 - d1;
  if (res[0][0] % 2 == 1) {
    cout << -1;
    return 0;
  }
  res[0][0] /= 2;
  res[0][1] = r0 - res[0][0];
  res[1][0] = c0 - res[0][0];
  res[1][1] = r1 - res[1][0];
  if (res[0][0] + res[0][1] != r0 || res[1][0] + res[1][1] != r1 ||
      res[0][0] + res[1][0] != c0 || res[0][1] + res[1][1] != c1 ||
      res[0][0] + res[1][1] != d0 || res[1][0] + res[0][1] != d1) {
    cout << -1;
    return 0;
  }
  for (int i = 0; i < 4; i++) {
    int x = res[i / 2][i % 2];
    if (x < 1 || x > 9) {
      cout << -1;
      return 0;
    }
    for (int j = 0; j < 4; j++) {
      if (i == j) continue;
      int y = res[j / 2][j % 2];
      if (x == y) {
        cout << -1;
        return 0;
      }
    }
  }
  for (int y = 0; y < 2; y++) {
    for (int x = 0; x < 2; x++) {
      cout << res[y][x] << " ";
    }
    cout << endl;
  }
  return 0;
}
