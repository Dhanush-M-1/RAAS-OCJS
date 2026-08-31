#include <bits/stdc++.h>
using namespace std;
template <typename T>
T Abs(T first) {
  return (first < 0 ? -first : first);
}
template <typename T>
T Sqr(T first) {
  return (first * first);
}
string plural(string s) {
  return (int((s).size()) && s[int((s).size()) - 1] == 'x' ? s + "en"
                                                           : s + "s");
}
const int INF = (int)1e9;
const long double EPS = 1e-9;
const long double PI = acos(-1.0);
bool Read(int &first) {
  char c, r = 0, n = 0;
  first = 0;
  for (;;) {
    c = getchar();
    if ((c < 0) && (!r)) return (0);
    if ((c == '-') && (!r))
      n = 1;
    else if ((c >= '0') && (c <= '9'))
      first = first * 10 + c - '0', r = 1;
    else if (r)
      break;
  }
  if (n) first = -first;
  return (1);
}
int main() {
  if (0) freopen("in.txt", "r", stdin);
  int N, M;
  int i, j, v, m, np = 0;
  int V[5000];
  int A[5000], B[5000], C[5000], D[5000], good[5000] = {0};
  Read(N), Read(M);
  for (i = 0; i < M; i++) {
    Read(A[i]), Read(B[i]), Read(C[i]), Read(D[i]);
    if (A[i] == 1) good[i] = 1;
  }
  for (i = 1; i <= N; i++) {
    v = 0;
    m = INF;
    for (j = 0; j < M; j++)
      if (A[j] == 1) {
        if ((B[j] <= i) && (i <= C[j])) v -= D[j];
      } else if ((B[j] <= i) && (i <= C[j]))
        m = min(m, v + D[j]);
    V[i - 1] = v = m;
    for (j = 0; j < M; j++)
      if (A[j] == 1) {
        if ((B[j] <= i) && (i <= C[j])) v += D[j];
      } else if ((B[j] <= i) && (i <= C[j]))
        if (v == D[j]) good[j] = 1;
  }
  for (j = 0; j < M; j++)
    if (!good[j]) goto No;
  printf("YES\n");
  for (i = 0; i < N; i++) printf("%d%c", V[i], i == N - 1 ? '\n' : ' ');
  return (0);
No:;
  printf("NO\n");
  return (0);
}
