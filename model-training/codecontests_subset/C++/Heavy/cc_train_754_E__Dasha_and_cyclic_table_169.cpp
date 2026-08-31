#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long INFF = 0x3f3f3f3f3f3f3f3fll;
const long long M = 1e9 + 7;
const long long maxn = 1e6 + 7;
const double pi = acos(-1.0);
const double eps = 0.00000001;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
template <typename T>
inline T abs(T a) {
  return a > 0 ? a : -a;
}
template <typename T>
inline T powMM(T a, T b) {
  T ret = 1;
  for (; b; b >>= 1ll, a = (long long)a * a % M)
    if (b & 1) ret = (long long)ret * a % M;
  return ret;
}
bitset<807> A[27][407], B[407];
char S[807];
int TaskA() {
  int n, m, i, j, k, t, r, c;
  scanf("%d%d", &n, &m);
  for (i = 0; i < n; i++) B[i].set();
  for (i = 0; i < n; i++) {
    scanf("%s", S);
    for (j = m; j < 800; j++) S[j] = S[j - m];
    for (j = 0; j < 800; j++) A[S[j] - 'a'][i].set(j);
  }
  scanf("%d%d", &r, &c);
  for (i = 0; i < r; i++) {
    scanf("%s", S);
    for (j = 0; j < c; j++)
      if (S[j] != '?') {
        for (k = 0; k < n; k++) {
          B[k] &= A[S[j] - 'a'][(i + k) % n] >> j;
        }
      }
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++)
      if (B[i][j] == 1)
        putchar('1');
      else
        putchar('0');
    puts("");
  }
  return 0;
}
void initialize() {}
int main() {
  int startTime = clock();
  initialize();
  fprintf(stderr, "/--- initializeTime: %ld milliseconds ---/\n",
          clock() - startTime);
  int T = 1;
  startTime = clock();
  while (T--) TaskA();
  fprintf(stderr, "/--- computeTime: %ld milliseconds ---/\n",
          clock() - startTime);
}
