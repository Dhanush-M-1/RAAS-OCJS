#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
int stack_A[MAXN];
int stack_B[MAXN];
int stack_AB[MAXN];
int main() {
  ios ::sync_with_stdio(false);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  int a_cnt = 0;
  int b_cnt = 0;
  int ab_cnt = 0;
  int x, y, z;
  for (int i = 0; i < n; ++i) {
    cin >> x >> y >> z;
    if (y & z) {
      stack_AB[ab_cnt] = x;
      ab_cnt += 1;
    } else if (y) {
      stack_A[a_cnt] = x;
      a_cnt += 1;
    } else if (z) {
      stack_B[b_cnt] = x;
      b_cnt += 1;
    }
  }
  if (a_cnt + ab_cnt < k || b_cnt + ab_cnt < k) {
    cout << -1 << endl;
    return 0;
  }
  sort(stack_A, stack_A + a_cnt);
  sort(stack_B, stack_B + b_cnt);
  sort(stack_AB, stack_AB + ab_cnt);
  int a = 0;
  int b = 0;
  int ab = 0;
  int a_k = 0;
  int b_k = 0;
  int ans = 0;
  while (!(a_k >= k && b_k >= k)) {
    if (a < a_cnt && b < b_cnt && ab < ab_cnt) {
      if (a_k < k && b_k < k) {
        if (stack_AB[ab] <= stack_A[a] + stack_B[b]) {
          ans += stack_AB[ab];
          ab += 1;
        } else {
          ans += stack_A[a] + stack_B[b];
          a += 1;
          b += 1;
        }
        a_k += 1;
        b_k += 1;
      } else if (a_k < k) {
        if (stack_A[a] <= stack_AB[ab]) {
          ans += stack_A[a];
          a += 1;
          a_k += 1;
        } else {
          ans += stack_AB[ab];
          ab += 1;
          a_k += 1;
          b_k += 1;
        }
      } else if (b_k < k) {
        if (stack_B[b] <= stack_AB[ab]) {
          ans += stack_B[b];
          b += 1;
          b_k += 1;
        } else {
          ans += stack_AB[ab];
          ab += 1;
          a_k += 1;
          b_k += 1;
        }
      }
    } else if (a < a_cnt && b < b_cnt) {
      if (a_k < k && b_k < k) {
        ans += stack_A[a] + stack_B[b];
        a += 1;
        b += 1;
        a_k += 1;
        b_k += 1;
      } else if (a_k < k) {
        ans += stack_A[a];
        a += 1;
        a_k += 1;
      } else if (b_k < k) {
        ans += stack_B[b];
        b += 1;
        b_k += 1;
      }
    } else if (a < a_cnt && ab < ab_cnt) {
      if (a_k < k && b_k >= k && stack_A[a] <= stack_AB[ab]) {
        ans += stack_A[a];
        a += 1;
        a_k += 1;
      } else {
        ans += stack_AB[ab];
        ab += 1;
        a_k += 1;
        b_k += 1;
      }
    } else if (b < b_cnt && ab < ab_cnt) {
      if (b_k < k && a_k >= k && stack_B[b] <= stack_AB[ab]) {
        ans += stack_B[b];
        b += 1;
        b_k += 1;
      } else {
        ans += stack_AB[ab];
        ab += 1;
        a_k += 1;
        b_k += 1;
      }
    } else if (ab < ab_cnt) {
      ans += stack_AB[ab];
      ab += 1;
      a_k += 1;
      b_k += 1;
    } else if (a < a_cnt) {
      ans += stack_A[a];
      a += 1;
      a_k += 1;
    } else if (b < b_cnt) {
      ans += stack_B[b];
      b += 1;
      b_k += 1;
    }
  }
  cout << ans << endl;
  return 0;
}
