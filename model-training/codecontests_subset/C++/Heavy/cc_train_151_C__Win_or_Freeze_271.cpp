#include <bits/stdc++.h>
using namespace std;
bool num[4000000];
long long primes[4000000];
void siv() {
  long long d = 0;
  primes[d++] = 2;
  for (long long i = 3; i < 4000000; i += 2) {
    if (!num[i]) {
      primes[d++] = i;
      for (long long j = i * i; j < 4000000; j += (2 * i)) num[j] = 1;
    }
  }
}
vector<long long> s;
void prime_fact(long long x) {
  long long lim = sqrt(x);
  for (long long i = 0; primes[i] <= lim; i++) {
    if (x % primes[i] == 0) {
      long long j = 0;
      while (x % primes[i] == 0) {
        x /= primes[i];
        j++;
      }
      s.push_back(primes[i]);
      s.push_back(j);
      lim = sqrt(x);
    }
  }
  if (x > 1) {
    s.push_back(x);
    s.push_back(1);
  }
}
int main() {
  siv();
  long long q;
  scanf("%I64d", &q);
  prime_fact(q);
  if (q == 1)
    printf("1\n0\n");
  else {
    if (s.size() == 2) {
      if (s[1] == 1) {
        printf("1\n0\n");
      } else if (s[1] == 2) {
        printf("2\n");
      } else {
        printf("1\n");
        printf("%I64d\n", s[0] * s[0]);
      }
    } else if (s.size() == 4) {
      if (s[1] == 1 && s[3] == 1)
        printf("2\n");
      else {
        printf("1\n");
        printf("%I64d\n", s[0] * s[2]);
      }
    } else {
      printf("1\n");
      printf("%I64d\n", s[0] * s[2]);
    }
  }
}
