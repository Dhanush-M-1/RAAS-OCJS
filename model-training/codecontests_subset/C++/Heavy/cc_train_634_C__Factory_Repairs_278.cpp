#include <bits/stdc++.h>
using namespace std;
long long fg[200001], fb[200001];
long long arr[200001];
long long n, k, a, b, q;
void update(int index, long long amount) {
  long long good, bad;
  if (arr[index] + amount <= b)
    good = amount;
  else
    good = max(0LL, b - arr[index]);
  for (int i = index; i <= n; i += (i & -i)) fg[i] += good;
  if (arr[index] + amount <= a)
    bad = amount;
  else
    bad = max(0LL, a - arr[index]);
  for (int i = index; i <= n; i += (i & -i)) fb[i] += bad;
  arr[index] += amount;
}
long long get(int index, bool isGood) {
  if (index <= 0) return 0;
  long long sum = 0;
  if (isGood) {
    while (index > 0) {
      sum += fg[index];
      index -= (index & -index);
    }
  } else {
    while (index > 0) {
      sum += fb[index];
      index -= (index & -index);
    }
  }
  return sum;
}
int main() {
  scanf("%I64d %I64d %I64d %I64d %I64d", &n, &k, &b, &a, &q);
  while (q--) {
    int which;
    scanf("%d", &which);
    if (which == 2) {
      int day;
      scanf("%d", &day);
      printf("%I64d\n",
             get(day - 1, false) + get(n, true) - get(day + k - 1, true));
    } else {
      int day;
      long long amount;
      scanf("%d %I64d", &day, &amount);
      update(day, amount);
    }
  }
  return 0;
}
