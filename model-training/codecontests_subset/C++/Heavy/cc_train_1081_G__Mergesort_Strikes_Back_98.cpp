#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int inv[N], n, k, mo, ans;
map<int, int> mp;
void get(int n, int k) {
  if (k == 1 || n == 1)
    mp[n]++;
  else
    get(n / 2, k - 1), get(n - n / 2, k - 1);
}
int calc(int x, int y) {
  int ans = 1ll * x * y % mo * (mo + 1) / 2 % mo;
  for (int i = (int)(1); i <= (int)(y); i++)
    ans = (ans + mo + 1ll * inv[i] - inv[i + x]) % mo;
  return ans;
}
int main() {
  scanf("%d%d%d", &n, &k, &mo);
  inv[0] = inv[1] = 1;
  for (int i = (int)(2); i <= (int)(n); i++)
    inv[i] = 1ll * inv[mo % i] * (mo - mo / i) % mo;
  for (int i = (int)(1); i <= (int)(n); i++)
    inv[i] = (inv[i] + inv[i - 1]) % mo;
  get(n, k);
  for (auto a : mp) {
    ans = (ans + 1ll * a.first * (a.first - 1) / 2 % mo * (mo + 1) / 2 % mo *
                     a.second) %
          mo;
    if (a.second >= 2)
      ans = (ans + 1ll * a.second * (a.second - 1) / 2 % mo *
                       calc(a.first, a.first)) %
            mo;
    for (auto b : mp)
      if (a.first < b.first)
        ans = (ans + 1ll * calc(a.first, b.first) * a.second % mo * b.second) %
              mo;
  }
  printf("%d", ans);
}
