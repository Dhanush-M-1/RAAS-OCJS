#include <bits/stdc++.h>
using namespace std;
const int N = int(2e6), mod = int(1e9) + 7;
int n;
string second;
int x[N], y[N];
int main() {
  getline(cin, second);
  int k = second.size();
  int a = 0, b = 0;
  bool ok = 0;
  a = 1;
  for (int i = 0; i < k; i++) {
    if (second[i] == '=') ok = 1;
    if (ok && second[i] >= '0' && second[i] <= '9')
      n = n * 10 + second[i] - '0';
    if (second[i] == '+') a++;
    if (second[i] == '-') b++;
  }
  int s1 = -1, s2 = -1;
  for (int i = 1; i < N; i++) {
    if (a <= i && n * a >= i && b <= i - n && n * b >= i - n) {
      s1 = i;
      s2 = i - n;
      break;
    }
  }
  if (s1 == -1) {
    puts("Impossible");
    return 0;
  }
  puts("Possible");
  for (int i = 1; i <= a; i++) {
    int v = min(s1 - a + i, n);
    s1 -= v;
    x[i] = v;
  }
  for (int i = 1; i <= b; i++) {
    int v = min(s2 - b + i, n);
    s2 -= v;
    y[i] = v;
  }
  a = b = 0;
  for (int i = 0; i < k; i++) {
    if (second[i] == '?') {
      if (i == 0 || second[i - 2] == '+') {
        printf("%d", x[++a]);
      } else
        printf("%d", y[++b]);
    } else
      printf("%c", second[i]);
  }
  return 0;
}
