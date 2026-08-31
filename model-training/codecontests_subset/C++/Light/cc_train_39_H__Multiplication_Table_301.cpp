#include <bits/stdc++.h>
using namespace std;
string a[10][10];
string change(int x, int base) {
  string ret, s;
  while (x) {
    ret += (x % base) + '0';
    x /= base;
  }
  for (string ::reverse_iterator rit = ret.rbegin(); rit != ret.rend(); ++rit)
    s += *rit;
  return s;
}
int main() {
  int N, i, j;
  while (scanf("%d", &N) != EOF) {
    for (i = 1; i < N; ++i)
      for (j = i; j < N; ++j) a[i][j] = a[j][i] = change(i * j, N);
    for (i = 1; i < N; ++i) {
      printf("%s ", a[i][1].c_str());
      for (j = 2; j < N; ++j) printf("%2s ", a[i][j].c_str());
      printf("\n");
    }
  }
}
