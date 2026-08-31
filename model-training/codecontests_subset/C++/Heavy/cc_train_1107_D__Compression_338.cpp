#include <bits/stdc++.h>
using namespace std;
inline unsigned long long int GCD(unsigned long long int a,
                                  unsigned long long int b) {
  while (b != 0) {
    unsigned long long int t = a % b;
    a = b;
    b = t;
  }
  return a;
}
inline unsigned long long int LCM(unsigned long long int a,
                                  unsigned long long int b) {
  return a * b / GCD(a, b);
}
int N;
char field[5555][5555];
bool solve2(int le) {
  int rcnt = N / le;
  for (int i = 0; i < rcnt * rcnt; i++) {
    int si = i / rcnt * le, sj = i % rcnt * le;
    char pos = field[si][sj];
    for (int ii = si; ii < si + le; ii++) {
      for (int jj = sj; jj < sj + le; jj++) {
        if (field[ii][jj] != pos) {
          return false;
        }
      }
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  ;
  cin >> (N);
  for (int i = 0; i < N; i++) {
    string x;
    cin >> x;
    for (int j = 0; j < N / 4; j++) {
      int k;
      if (x[j] >= '0' && x[j] <= '9') {
        k = x[j] - '0';
      } else {
        k = x[j] - 'A' + 10;
      }
      field[i][j * 4] = (k & 8) >> 3;
      field[i][j * 4 + 1] = (k & 4) >> 2;
      field[i][j * 4 + 2] = (k & 2) >> 1;
      field[i][j * 4 + 3] = k & 1;
    }
  }
  vector<int> divv;
  for (int i = 1; i <= N; i++) {
    if (N % i == 0) divv.push_back(i);
  }
  long long int asns = 1;
  for (int i = 0; i < divv.size(); i++) {
    if (solve2(divv[i])) {
      asns = divv[i];
    }
  }
  return cout << asns, 0;
}
