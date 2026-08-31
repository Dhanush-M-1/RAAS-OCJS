#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
pair<int, int> temp[100005];
int gcd(int a, int b) {
  int c;
  if (a < b) swap(a, b);
  while (b > 0) {
    c = b;
    b = a % b;
    a = c;
  }
  return a;
}
map<pair<long long, long long>, int> M1, M2;
int main() {
  int x, y;
  long long w;
  scanf("%d %d %lld", &x, &y, &w);
  pair<long long, long long> m = make_pair(-1, -1);
  long long l = 1e15;
  for (int i = 1; i < 100005; ++i) {
    int p = 0, q = i;
    while (q > 0) {
      p = p * 10 + q % 10;
      q /= 10;
    }
    q = gcd(i, p);
    temp[i] = make_pair(i / q, p / q);
  }
  for (int i = 1; i < y + 1; ++i) {
    M1[temp[i]]++;
  }
  long long h = y;
  long long ans = 0;
  for (int i = 1; i < x + 1; ++i) {
    pair<int, int> c = make_pair(temp[i].second, temp[i].first);
    ans += M1[c];
    M2[c]++;
    while (ans >= w && h > 0) {
      if ((h * i) < l) {
        l = h * i;
        m = make_pair(i, h);
      }
      M1[temp[h]]--;
      ans -= M2[temp[h]];
      h--;
    }
    if (h == 0) break;
  }
  if (l == 1e15)
    printf("-1\n");
  else
    printf("%lld %lld\n", m.first, m.second);
  return 0;
}
