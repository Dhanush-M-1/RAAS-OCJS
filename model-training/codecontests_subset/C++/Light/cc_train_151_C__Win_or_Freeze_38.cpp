#include <bits/stdc++.h>
using namespace std;
using namespace std;
const int inf = 0x3f3f3f3f;
vector<long long> v;
int main() {
  long long n;
  scanf("%lld", &n);
  long long q = sqrt(n);
  for (int i = 2; i < q + 1; ++i)
    if (n % i == 0)
      while (n % i == 0) n /= i, v.push_back(i);
  if (n > 1) v.push_back(n);
  if (v.size() < 2)
    printf("1\n0\n");
  else if (v.size() == 2)
    printf("2\n");
  else
    printf("1\n%lld\n", v[0] * v[1]);
}
