#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200;
int N, L;
int a[MAXN], sgn[MAXN];
int main() {
  string s, t;
  cin >> s;
  sgn[L++] = 1;
  while (cin >> s) {
    cin >> t;
    if (s == "+")
      sgn[L++] = 1;
    else if (s == "-")
      sgn[L++] = -1;
    else {
      N = atoi(t.c_str());
    }
  }
  int sum = 0;
  for (int i = 0; i < L; i++) {
    sum += sgn[i];
    a[i] = 1;
  }
  for (int i = 0; i < L; i++) {
    if (sum < N && sgn[i] == 1) {
      while (a[i] < N && sum < N) {
        a[i]++;
        sum++;
      }
    } else if (sum > N && sgn[i] == -1) {
      while (a[i] < N && sum > N) {
        a[i]++;
        sum--;
      }
    }
  }
  if (sum != N)
    puts("Impossible");
  else {
    puts("Possible");
    printf("%d ", a[0]);
    for (int i = 1; i < L; i++) printf("%c %d ", sgn[i] == 1 ? '+' : '-', a[i]);
    printf("= %d\n", N);
  }
}
