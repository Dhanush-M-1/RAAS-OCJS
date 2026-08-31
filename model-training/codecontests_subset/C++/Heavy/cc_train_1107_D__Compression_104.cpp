#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<int> divisors;
  bool matrix[n][n];
  for (int i = 1; i <= n; ++i) {
    if (n % i == 0) {
      divisors.push_back(i);
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n / 4; ++j) {
      char c;
      cin >> c;
      int num;
      if (c >= 'A') {
        num = c - 'A' + 10;
      } else {
        num = c - '0';
      }
      matrix[i][j * 4 + 0] = (num >> 3) == 1;
      matrix[i][j * 4 + 1] = ((num >> 2) & 1) == 1;
      matrix[i][j * 4 + 2] = ((num >> 1) & 1) == 1;
      matrix[i][j * 4 + 3] = (num & 1) == 1;
    }
  }
  int currpos = ceil(divisors.size() / 2.0);
  int increment = ceil(currpos / 2.0);
  int currguess = divisors[currpos];
  bool wasok = false;
  bool firsttime = true;
  int largest = 1;
  for (int i = 0; i < divisors.size(); ++i) {
    currguess = divisors[i];
    bool isok = true;
    for (int i = 0; i < n / currguess; ++i) {
      for (int j = 0; j < n / currguess; ++j) {
        bool currbol = matrix[i * currguess][j * currguess];
        for (int k = 0; k < currguess; ++k) {
          for (int l = 0; l < currguess; ++l) {
            if (matrix[i * currguess + k][j * currguess + l] != currbol) {
              isok = false;
            }
          }
        }
      }
    }
    if (isok) {
      if (currguess > largest) {
        largest = currguess;
      }
    }
  }
  cout << largest << "\n";
}
