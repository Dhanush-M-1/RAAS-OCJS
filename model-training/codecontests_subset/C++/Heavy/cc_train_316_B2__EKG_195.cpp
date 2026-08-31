#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:255000000")
bool firstout = 1;
template <class T>
T &minn(T &a, T b) {
  if (b < a) a = b;
  return a;
}
template <class T>
T &maxx(T &a, T b) {
  if (a < b) a = b;
  return a;
}
int &madd(int &a, int b) {
  a += b;
  if (a >= 1000000007) a -= 1000000007;
  return a;
}
int &msub(int &a, int b) {
  a -= b;
  if (a < 0) a += 1000000007;
  return a;
}
int &mmult(int &a, int b) { return a = (long long)a * b % 1000000007; }
int mdiv(long long a, long long b, long long m) {
  a = (a % m + m) % m;
  b = (b % m + m) % m;
  if (a % b == 0) return a / b;
  return (a + m * mdiv(-a, m, b)) / b;
}
int n, m, q;
int A[1012];
int AA[1012];
int R[1012];
int main() {
  int i, j, k;
  char c;
  int a, d;
  int ts;
  for (ts = 1; scanf("%"
                     "d",
                     &(n)) > 0;
       ++ts) {
    scanf(
        "%"
        "d",
        &(k));
    --k;
    for (i = (0); i < (n); ++i) A[i] = AA[i] = -1;
    for (i = (0); i < (n); ++i) {
      scanf(
          "%"
          "d",
          &(a));
      --a;
      A[i] = a;
      if (a >= 0) AA[a] = i;
    }
    for (i = (0); i < (n); ++i) R[i] = 0;
    int res = 0;
    for (; A[k] >= 0; k = A[k]) ++res;
    R[res] = 1;
    for (i = (0); i < (n); ++i)
      if (i != k && A[i] < 0) {
        for (a = 1, j = i; AA[j] >= 0; j = AA[j]) ++a;
        for (j = (n)-1; j >= (0); --j)
          if (R[j]) R[j + a] = 1;
      }
    for (i = (0); i < (n); ++i)
      if (R[i])
        printf(
            "%"
            "d",
            (i + 1)),
            printf("\n"), firstout = 1;
  }
  return 0;
}
