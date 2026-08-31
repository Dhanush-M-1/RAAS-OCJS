#include <bits/stdc++.h>
using namespace std;
long long n, l, r;
int Go() {
  scanf("%lld %lld %lld", &n, &l, &r);
  long long len = r - l + 1;
  long long x = n;
  long long y = 0;
  long long start = 0;
  while (1) {
    y += 2 * (x - 1);
    x--;
    start++;
    if (x <= 0 || y >= l) break;
  }
  long long k = y - 2 * x;
  long long d = (l - k + 1) / 2;
  long long add = start + d;
  vector<long long> Ans;
  long long count = 0;
  if (l % 2 == 0) {
    Ans.push_back(add++);
    count++;
  }
  while (count < len) {
    if (add == n + 1) {
      start++;
      add = start + 1;
    }
    Ans.push_back(start);
    count++;
    if (count == len) break;
    Ans.push_back(add);
    count++;
    add++;
  }
  if (r == n * (n - 1) + 1) {
    Ans.pop_back();
    Ans.push_back(1);
  }
  for (int i = 0; i < Ans.size(); ++i) printf("%lld ", Ans[i]);
  puts("");
  return 0;
}
int main() {
  int t;
  if (1)
    scanf("%d", &t);
  else
    t = 1;
  while (t--) Go();
}
