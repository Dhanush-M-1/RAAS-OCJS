#include <bits/stdc++.h>
using namespace std;
long long modulo(long long base, long long exponent, long long modulus);
long long choose(long long n, long long k);
long long inverse(long long a, long long m);
void build() {}
vector<long long> visit(1000010);
vector<long long> freee(1000010);
int main() {
  build();
  long long n, m, k;
  scanf("%lld %lld %lld", &n, &m, &k);
  vector<long long> blocked(m);
  for (int i = 0; i < m; i++) {
    scanf("%lld", &blocked[i]);
    visit[blocked[i]] = 1;
  }
  vector<long long> price(k + 1);
  for (int i = 1; i <= k; i++) scanf("%lld", &price[i]);
  long long mini = 0;
  long long temp = 0;
  for (int i = 0; i < n; i++) {
    if (visit[i] == 1) {
      temp++;
    } else {
      temp = 0;
    }
    mini = max(mini, temp);
  }
  mini++;
  if (visit[0] == 1 || mini > k) {
    cout << -1 << endl;
    return 0;
  }
  long long lastfree = 0;
  for (int i = 0; i < n; i++) {
    if (visit[i] == 1) {
      freee[i] = lastfree;
    } else {
      lastfree = i;
    }
  }
  long long ans = LONG_LONG_MAX;
  for (int len = mini; len <= k; len++) {
    long long lans = 0;
    long long i = 0;
    long long power = len;
    long long cost = price[power];
    lans += cost;
    i += power;
    while (i < n) {
      if (visit[i] == 1) {
        i = freee[i];
      }
      if (i >= n) break;
      lans += cost;
      i += power;
    }
    ans = min(ans, lans);
  }
  cout << ans << endl;
  return 0;
}
long long modulo(long long base, long long exponent, long long modulus) {
  if (modulus == 1) return 0;
  long long result = 1;
  base = base % modulus;
  while (exponent > 0) {
    if (exponent % 2 == 1) {
      result = (result * base) % modulus;
    }
    exponent = exponent >> 1;
    base = (base * base) % modulus;
  }
  return result;
}
long long choose(long long n, long long k) {
  if (k == 0) return 1;
  return (n * choose(n - 1, k - 1)) / k;
}
void EE(long long a, long long b, long long &co1, long long &co2) {
  if (a % b == 0) {
    co1 = 0;
    co2 = 1;
    return;
  }
  EE(b, a % b, co1, co2);
  long long temp = co1;
  co1 = co2;
  co2 = temp - co2 * (a / b);
}
long long inverse(long long a, long long m) {
  long long x, y;
  EE(a, m, x, y);
  if (x < 0) x += m;
  return x;
}
