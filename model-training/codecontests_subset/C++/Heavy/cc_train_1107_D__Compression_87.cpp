#include <bits/stdc++.h>
#pragma warning(disable : 6031)
using namespace std;
const int maxn = 2e5 + 10;
const long long mode = 1e9 + 7;
const int inf = 0x3f3f3f3f;
const double pi = 3.14159265358979323846264338327950;
template <class T>
inline T min(T a, T b, T c) {
  return min(min(a, b), c);
}
template <class T>
inline T max(T a, T b, T c) {
  return max(max(a, b), c);
}
template <class T>
inline T min(T a, T b, T c, T d) {
  return min(min(a, b), min(c, d));
}
template <class T>
inline T max(T a, T b, T c, T d) {
  return max(max(a, b), max(c, d));
}
int n;
bool a[5211][5211];
int gcd(int a, int b) { return a == 0 ? b : gcd(b % a, a); }
void parse_char(int x, int y, char c) {
  int num = -1;
  if (isdigit(c))
    num = c - '0';
  else
    num = c - 'A' + 10;
  for (int i = 0; i < 4; ++i) {
    a[x][y + 3 - i] = num & 1;
    num >>= 1;
  }
}
int main() {
  scanf("%d", &n);
  char buf[5211];
  for (int i = 0; i < n; i++) {
    scanf("%s", buf);
    for (int j = 0; j < n / 4; ++j) parse_char(i, j * 4, buf[j]);
  }
  int g = n;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) {
      int k = j;
      while (k < n && a[i][k] == a[i][j]) ++k;
      g = gcd(g, k - j);
      j = k - 1;
    }
  for (int j = 0; j < n; j++)
    for (int i = 0; i < n; i++) {
      int k = i;
      while (k < n && a[k][j] == a[i][j]) ++k;
      g = gcd(g, k - i);
      i = k - 1;
    }
  cout << g << endl;
  return 0;
}
