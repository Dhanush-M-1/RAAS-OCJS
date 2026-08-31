#include <bits/stdc++.h>
using namespace std;
FILE *in, *out;
int N, M, K;
int ar[110];
int read() {
  int i, j, k;
  int x, y;
  cin >> N;
  x = 0;
  y = 0;
  for (i = 0, j = 0; i < N; i++) {
    cin >> ar[i];
    j = max(j, ar[i]);
    y += ar[i];
  }
  while (1) {
    x = 0;
    for (i = 0; i < N; i++) {
      x += j - ar[i];
    }
    if (x > y) {
      cout << j << "\n";
      return 0;
    }
    j++;
  }
  return 0;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  in = stdin;
  out = stdout;
  read();
  return 0;
}
