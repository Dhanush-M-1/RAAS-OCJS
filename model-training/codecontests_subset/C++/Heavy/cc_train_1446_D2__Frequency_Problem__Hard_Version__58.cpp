#include <bits/stdc++.h>
using namespace std;
int n, A[200005], S[200005], s;
int pre[200005 << 1], ans = 0;
void Solve1(int x) {
  for (int i = 1; i <= n; i++) pre[n - i] = pre[n + i] = -1;
  pre[n] = 0;
  int now = 0;
  for (int i = 1; i <= n; i++) {
    if (A[i] == x)
      now++;
    else if (A[i] == s)
      now--;
    if (pre[n + now] == -1)
      pre[n + now] = i;
    else
      ans = max(ans, i - pre[n + now]);
  }
}
void Solve2(int x) {
  for (int i = 1; i <= n; i++) S[i] = 0;
  int l = 1, tot = 0;
  S[A[l]]++;
  if (S[A[l]] == x) tot++;
  for (int i = 2; i <= n; i++) {
    S[A[i]]++;
    if (S[A[i]] == x)
      tot++;
    else if (S[A[i]] > x) {
      if (S[A[i]] == x + 1) tot--;
      while (S[A[i]] > x) {
        S[A[l]]--;
        if (S[A[l]] == x) tot++;
        if (S[A[l]] == x - 1) tot--;
        l++;
      }
    }
    if (tot >= 2) ans = max(ans, i - l + 1);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &A[i]);
    S[A[i]]++;
    if (S[s] < S[A[i]]) s = A[i];
  }
  int lim = int(sqrt(n) + 0.5);
  for (int i = 1; i <= n; i++)
    if (S[i] >= lim && i != s) Solve1(i);
  for (int i = 1; i < lim; i++) Solve2(i);
  printf("%d\n", ans);
}
