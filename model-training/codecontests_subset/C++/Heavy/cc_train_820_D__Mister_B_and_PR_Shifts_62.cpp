#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int maxn = 1e6 + 10;
int p[maxn];
int cnt[maxn];
int main() {
  int n;
  scanf("%d", &n);
  int a = 0, b = 0;
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &p[i]);
    if (p[i] > i)
      a++;
    else
      b++;
    ans += abs(p[i] - i);
    cnt[(p[i] - i + n) % n]++;
  }
  long long ANS = ans, x = 0;
  for (int i = 1; i <= n; i++) {
    int j = n - i + 1;
    ans -= abs(p[j] - (j + i - 1));
    ans += abs(p[j] - 1);
    b--;
    ans += b - a;
    if (ANS > ans) ANS = ans, x = i;
    ++a;
    a -= cnt[i % n];
    b += cnt[i % n];
  }
  cout << ANS << ' ' << x << endl;
  return 0;
}
