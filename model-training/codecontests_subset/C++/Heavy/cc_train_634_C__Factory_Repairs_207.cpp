#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200005;
int n, k, a, b, q, t, A, B, BITA[MAXN], BITB[MAXN], tot[MAXN];
int query1(int index) {
  if (index >= MAXN) index = MAXN - 1;
  int sum = 0;
  for (; index > 0; index -= index & -index) sum += BITA[index];
  return sum;
}
void set1(int index, int value) {
  int val = -(query1(index) - query1(index - 1)) + value;
  for (; index < MAXN; index += index & -index) BITA[index] += val;
}
int query2(int index) {
  int sum = 0;
  for (; index > 0; index -= index & -index) sum += BITB[index];
  return sum;
}
void set2(int index, int value) {
  int val = -(query2(index) - query2(index - 1)) + value;
  for (; index < MAXN; index += index & -index) BITB[index] += val;
}
int main() {
  scanf("%i%i%i%i%i", &n, &k, &a, &b, &q);
  while (q--) {
    scanf("%i", &t);
    if (t == 1) {
      scanf("%i%i", &A, &B);
      tot[A] += B;
      set1(A, min(tot[A], a));
      set2(A, min(tot[A], b));
    } else {
      scanf("%i", &A);
      printf("%i\n", query1(MAXN - 1) - query1(A + k - 1) + query2(A - 1));
    }
  }
}
