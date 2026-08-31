#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, a, b, c = 2, n1, i;
  vector<pair<long long int, long long int> > x;
  scanf("%lld", &n1);
  n = n1;
  while (n--) {
    scanf("%lld%lld", &a, &b);
    x.push_back(make_pair(a, b));
  }
  if (n1 == 1) {
    printf("1\n");
    return 0;
  }
  for (i = 1; i < x.size() - 1; i++) {
    if (x[i].first - x[i].second > x[i - 1].first) {
      c++;
    } else if (x[i].first + x[i].second < x[i + 1].first) {
      c++;
      x[i].first += x[i].second;
    }
  }
  printf("%lld\n", c);
  return 0;
}
