#include <bits/stdc++.h>
using namespace std;
#pragma warning(disable : 4996)
const int N = 5201;
bool b[N][N];
char s[N];
int gcd(int a, int b) { return a ? gcd(b % a, a) : b; }
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf(" %s", s);
    for (int j = 0; j < n / 4; j++) {
      int x = isdigit(s[j]) ? s[j] - '0' : s[j] - 'A' + 10;
      for (int k = 0; k < 4; k++) b[i][j * 4 + k] = (x >> (3 - k)) & 1;
    }
  }
  int g = 0;
  for (int i = 0; i < n; i++) {
    int k = -1;
    for (int j = 0; j < n; j++) {
      if (j == n - 1 || b[i][j] != b[i][j + 1]) {
        g = gcd(g, j - k);
        k = j;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    int k = -1;
    for (int j = 0; j < n; j++) {
      if (j == n - 1 || b[j + 1][i] != b[j][i]) {
        g = gcd(g, j - k);
        k = j;
      }
    }
  }
  cout << g << "\n";
  return 0;
}
