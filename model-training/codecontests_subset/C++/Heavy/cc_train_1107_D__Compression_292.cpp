#include <bits/stdc++.h>
using namespace std;
long long matrix[5205][5205];
long long hti(char h) {
  if (isdigit(h)) {
    return h - '0';
  }
  return (h - 'A') + 10;
}
long long func(long long x, long long y, long long d) {
  long long v = matrix[x][y];
  if (x - d >= 0) {
    v -= matrix[x - d][y];
  }
  if (y - d >= 0) {
    v -= matrix[x][y - d];
  }
  if (x - d >= 0 && y - d >= 0) {
    v += matrix[x - d][y - d];
  }
  return v;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    string s;
    cin >> s;
    reverse(s.begin(), s.end());
    for (long long j = 0; j < n; j++) {
      matrix[i][j] = (hti(s[j / 4]) >> j % 4) & 1;
    }
  }
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < n; j++) {
      if (i == 0) {
        if (j > 0) {
          matrix[i][j] += matrix[i][j - 1];
        }
      } else if (j == 0) {
        matrix[i][j] += matrix[i - 1][j];
      } else {
        matrix[i][j] +=
            matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1];
      }
    }
  }
  for (long long x = n; x >= 1; x--) {
    if (n % x == 0) {
      bool f = true;
      for (long long i = x - 1; i < n && f; i += x) {
        for (long long j = x - 1; j < n && f; j += x) {
          long long sum = func(i, j, x);
          if (sum != (x * x) && sum != 0) {
            f = false;
          }
        }
      }
      if (f) {
        cout << x << "\n";
        break;
      }
    }
  }
  return 0;
}
