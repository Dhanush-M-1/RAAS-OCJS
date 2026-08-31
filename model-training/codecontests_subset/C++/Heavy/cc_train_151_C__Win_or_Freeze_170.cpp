#include <bits/stdc++.h>
using namespace std;
int mark[3200000];
int prime[3200000];
int cnt = 0;
bool mm[3200000];
void Init() {
  int i, j, q, n;
  memset(mark, 0, sizeof(mark));
  n = 3200000;
  for (i = 2; i <= n; i++) {
    if (mark[i] == 0) {
      prime[cnt++] = i;
    }
    for (j = 0; j < cnt; j++) {
      if (prime[j] * i > n) break;
      mark[prime[j] * i] = prime[j];
      if (mark[i] == prime[j]) break;
    }
  }
}
int main() {
  Init();
  long long n;
  int i;
  while (cin >> n) {
    int ans = 0;
    long long res = 1;
    int n1 = n;
    for (i = 0; i < cnt && prime[i] <= n; i++) {
      while (n % prime[i] == 0) {
        ans++;
        if (ans <= 2) res *= prime[i];
        n /= prime[i];
      }
    }
    if (n != 1) {
      ans++;
      if (ans <= 2) res *= prime[i];
    }
    if (ans < 2) {
      puts("1\n0");
    } else if (ans >= 3) {
      cout << "1\n" << res << endl;
    } else
      puts("2");
  }
  return 0;
}
