#include <bits/stdc++.h>
using namespace std;
bool ok[5206], book[5206];
int P[5206][5206], n;
int qwq(char x) {
  if (x >= 'A')
    return 10 + x - 'A';
  else
    return x - '0';
}
int p[5206], num;
void Analyze(int x) {
  num = 0;
  for (int i = 2; i * i <= x; ++i)
    while (x % i == 0) x /= i, p[num++] = i;
  if (x > 1) p[num++] = x;
}
bool work(int x) {
  if (book[x]) return ok[x];
  book[x] = true;
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < n / x; ++j)
      for (int k = 1; k < x; ++k)
        if (P[i][j * x + k] != P[i][j * x + k - 1]) return ok[x] = false;
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < n / x; ++j)
      for (int k = 1; k < x; ++k)
        if (P[j * x + k][i] != P[j * x + k - 1][i]) return ok[x] = false;
  return ok[x] = true;
}
int main() {
  cin >> n;
  getchar();
  char ch;
  for (int i = 0, q; i < n; ++i) {
    for (int j = 0; j < n / 4; ++j) {
      ch = getchar();
      q = qwq(ch);
      for (int k = 1; k <= 4; ++k) P[i][(j + 1) * 4 - k] = (q & 1), q >>= 1;
    }
    getchar();
  }
  Analyze(n);
  int ans = 1;
  for (int i = 0; i < num; ++i) {
    if (work(p[i] * ans)) ans *= p[i];
  }
  cout << ans;
}
