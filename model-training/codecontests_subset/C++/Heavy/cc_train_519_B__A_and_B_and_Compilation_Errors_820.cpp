#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int seq1[n], seq2[n], seq3[n];
  for (int i = 0; i < n; i++) scanf("%d", &seq1[i]);
  for (int i = 0; i < n - 1; i++) scanf("%d", &seq2[i]);
  for (int i = 0; i < n - 2; i++) scanf("%d", &seq3[i]);
  sort(seq1, seq1 + n);
  sort(seq2, seq2 + n - 1);
  sort(seq3, seq3 + n - 2);
  int f = -1, s = -1, dif = 0;
  for (int i = 0; i < n - 1; i++)
    if (seq1[i] != seq2[i]) {
      f = seq1[i];
      break;
    }
  if (f == -1) f = seq1[n - 1];
  for (int i = 0; i < n - 2; i++)
    if (seq2[i] != seq3[i]) {
      s = seq2[i];
      break;
    }
  if (s == -1) s = seq2[n - 2];
  printf("%d\n%d\n", f, s);
  return 0;
}
