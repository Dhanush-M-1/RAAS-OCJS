#include <bits/stdc++.h>
using namespace std;
char f[3200001];
int p[1000000];
int main() {
  int m, i, np = 0, k;
  long long n, j;
  for (i = 2; i <= 3200000; i++)
    if (!f[i]) {
      p[np++] = i;
      for (j = i * (long long)i; j <= 3200000; j += i) f[j] = 1;
    }
  scanf("%I64d", &n);
  vector<pair<long long, int> > fa;
  int t = 0;
  for (i = 0; (long long)p[i] * p[i] <= n; i++) {
    int c = 0;
    while (n % p[i] == 0) {
      n /= p[i];
      c++;
    }
    if (c) fa.push_back(make_pair(p[i], c));
    t += c;
  }
  if (n > 1) {
    fa.push_back(make_pair(n, 1));
    t++;
  }
  if (t <= 1)
    printf("1\n0\n");
  else if (t == 2) {
    printf("2\n");
  } else if (fa.size() == 1) {
    printf("1\n%d\n", fa[0].first * fa[0].first);
  } else {
    printf("1\n%I64d\n", fa[0].first * fa[1].first);
  }
  return 0;
}
