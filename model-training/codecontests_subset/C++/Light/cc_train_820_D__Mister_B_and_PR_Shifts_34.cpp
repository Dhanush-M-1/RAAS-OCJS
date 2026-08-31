#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int maxn = 1e6 + 10;
int p[maxn];
int cnt[maxn];
int w[maxn];
void nex(int *a, int n) {
  int t = a[n];
  for (int i = n; i >= 2; i--) a[i] = a[i - 1];
  a[1] = t;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &p[i]), w[i] = p[i];
  int a = 0, b = 0;
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    if (p[i] > i)
      a++;
    else if (p[i] < i)
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
    b += cnt[i - 1];
    ans += b - a;
    if (ANS > ans) ANS = ans, x = i;
    a++;
    a -= cnt[i];
  }
  cout << ANS << ' ' << x << endl;
  return 0;
}
