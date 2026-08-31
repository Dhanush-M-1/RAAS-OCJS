#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void maz(T &a, T b) {
  if (a < b) a = b;
}
template <class T>
inline void miz(T &a, T b) {
  if (a > b) a = b;
}
template <class T>
inline T abs(T a) {
  return a > 0 ? a : -a;
}
const int N = 300100, INF = 1e9;
const double EPS = 1e-6, MAGIC = 381401241.01201;
int n, m;
int A[N], B[N];
void output(int x, int t) {
  printf(
      "("
      "%d*("
      "((abs(((t-%d)+1))+abs(((t-%d)-1)))-abs((t-%d)))-abs((t-%d))"
      ")"
      ")",
      x / 2, t, t, t, t);
}
void make(int A[]) {
  for (int i = 0; i < n; i++)
    if (A[i] & 1) A[i]++;
  for (int i = 0; i < n - 1; i++) putchar('(');
  for (int i = 0; i < n; i++) {
    if (i != 0) putchar('+');
    output(A[i], i);
    if (i != 0) putchar(')');
  }
  puts("");
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int c;
    scanf("%d%d%d", &A[i], &B[i], &c);
  }
  make(A);
  make(B);
}
