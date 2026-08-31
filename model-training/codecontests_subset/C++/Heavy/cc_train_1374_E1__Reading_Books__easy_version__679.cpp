#include <bits/stdc++.h>
using namespace std;
int Alice[200005], Bob[200005], Both[200005];
int PA[200005], PB[200005];
int FindMinReadingTime(int k, int a, int b, int bo) {
  int i, Ans = 0;
  if (a > 0) sort(Alice + 1, Alice + a + 1);
  if (b > 0) sort(Bob + 1, Bob + b + 1);
  if (bo > 0) sort(Both + 1, Both + bo + 1);
  for (i = 1; i <= a; ++i) PA[i] = PA[i - 1] + Alice[i];
  for (i = 1; i <= a; ++i) PB[i] = PB[i - 1] + Bob[i];
  if (a >= k && b >= k)
    Ans = PA[k] + PB[k];
  else
    Ans = 2000000001;
  int Value = 0;
  for (i = 1; i <= min(k, bo); ++i) {
    Value += Both[i];
    if (i + a >= k && i + b >= k) Ans = min(Ans, Value + PA[k - i] + PB[k - i]);
  }
  return Ans;
}
int main() {
  int N, k, i, j, p, q;
  int t, a, b;
  scanf("%d%d", &N, &k);
  j = p = q = 0;
  for (i = 1; i <= N; ++i) {
    scanf("%d%d%d", &t, &a, &b);
    if (a == 1) {
      if (b == 1)
        Both[++q] = t;
      else
        Alice[++j] = t;
    } else if (b == 1)
      Bob[++p] = t;
  }
  if (j + q < k || p + q < k)
    puts("-1");
  else
    printf("%d\n", FindMinReadingTime(k, j, p, q));
  return 0;
}
