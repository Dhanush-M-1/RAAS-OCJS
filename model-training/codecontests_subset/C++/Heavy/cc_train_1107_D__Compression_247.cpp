#include <bits/stdc++.h>
using namespace std;
int f(char c) { return c > '9' ? c - 'A' + 10 : c - '0'; }
bool ok(vector<vector<int>> &matrix, int x) {
  for (int i = 0; i < matrix.size(); i += x) {
    for (int j = 0; j < matrix.size(); j += x) {
      for (int k = 0; k < x; ++k) {
        for (int l = 0; l < x; ++l) {
          if (matrix[i + k][j + l] != matrix[i][j]) {
            return false;
          }
        }
      }
    }
  }
  return true;
}
vector<vector<int>> compress(vector<vector<int>> &matrix, int x) {
  vector<vector<int>> compressedMatrix(matrix.size() / x,
                                       vector<int>(matrix.size() / x));
  for (int i = 0; i < matrix.size(); i += x) {
    for (int j = 0; j < matrix.size(); j += x) {
      compressedMatrix[i / x][j / x] = matrix[i][j];
    }
  }
  return compressedMatrix;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<vector<int>> matrix(n, vector<int>(n));
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; j += 4) {
      char c;
      cin >> c;
      int mask = f(c);
      for (int k = 0; k < 4; ++k) {
        if (mask & (1 << k)) {
          matrix[i][j + (3 - k)] = 1;
        }
      }
    }
  }
  int ansX = 1;
  for (int x = 2; x <= matrix.size(); ++x) {
    while (matrix.size() % x == 0 && ok(matrix, x)) {
      matrix = compress(matrix, x);
      ansX *= x;
    }
  }
  cout << ansX << endl;
  return 0;
}
