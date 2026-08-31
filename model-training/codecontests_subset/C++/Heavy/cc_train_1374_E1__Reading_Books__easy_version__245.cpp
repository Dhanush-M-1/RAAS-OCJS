#include <bits/stdc++.h>
using namespace std;
const int INF = 2147483640;
const int MAXN = 2e5 + 5;
const int R = 1e4 + 5;
int n, m, k;
int tot[10];
struct node {
  int t, i;
} A[MAXN], B[MAXN], C[MAXN], D[MAXN], E[MAXN << 2];
bool cmp(node x, node y) { return x.t < y.t; }
struct tree {
  int sum, w;
} tr[R << 2];
void modify(int x, int l, int r, int pos, int k) {
  if (l == r) {
    tr[x].sum += k * l;
    tr[x].w += k;
    return;
  }
  int mid = (l + r) / 2;
  if (pos <= mid) modify(x * 2, l, mid, pos, k);
  if (pos > mid) modify(x * 2 + 1, mid + 1, r, pos, k);
  tr[x].sum = tr[x * 2].sum + tr[x * 2 + 1].sum;
  tr[x].w = tr[x * 2].w + tr[x * 2 + 1].w;
}
int query(int x, int l, int r, int kth) {
  int ans = 0;
  if (kth == tr[x].w) return tr[x].sum;
  if (l == r) return kth * l;
  int mid = (l + r) / 2;
  if (tr[x * 2].w < kth)
    ans = tr[x * 2].sum + query(x * 2 + 1, mid + 1, r, kth - tr[x * 2].w);
  else
    ans = query(x * 2, l, mid, kth);
  return ans;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= n; i++) {
    int t, a, b;
    scanf("%d%d%d", &t, &a, &b);
    if (a == 1 && b == 1) A[++tot[1]] = (node){t, i};
    if (a == 0 && b == 1) B[++tot[2]] = (node){t, i};
    if (a == 1 && b == 0) C[++tot[3]] = (node){t, i};
    if (a == 0 && b == 0) D[++tot[4]] = (node){t, i};
  }
  if (min(tot[2], tot[3]) + tot[1] < k) {
    printf("-1");
    return 0;
  }
  sort(A + 1, A + tot[1] + 1, cmp);
  sort(B + 1, B + tot[2] + 1, cmp);
  sort(C + 1, C + tot[3] + 1, cmp);
  sort(D + 1, D + tot[4] + 1, cmp);
  int cost = 0, num = 0;
  for (int i = 1; i <= min(m, tot[1]); i++) cost += A[i].t, num++;
  int now = 0;
  for (int i = 1; i <= k - tot[1]; i++)
    now++, cost += (B[now].t + C[now].t), num += 2;
  for (int i = m + 1; i <= tot[1]; i++) modify(1, 1, R, A[i].t, 1);
  for (int i = now + 1; i <= tot[2]; i++) modify(1, 1, R, B[i].t, 1);
  for (int i = now + 1; i <= tot[3]; i++) modify(1, 1, R, C[i].t, 1);
  for (int i = 1; i <= tot[4]; i++) modify(1, 1, R, D[i].t, 1);
  if (num > m) {
    printf("-1");
    return 0;
  }
  int minn = INF, ans_A = 0, ans_B = 0;
  for (int i = min(m, tot[1]); i >= 0; i--) {
    if (num > m) break;
    int ans = cost + query(1, 1, R, m - num);
    if (ans < minn) minn = ans, ans_A = i, ans_B = now;
    modify(1, 1, R, A[i].t, 1);
    cost -= A[i].t;
    num--;
    if (now > min(tot[2], tot[3])) break;
    if (i <= k) {
      num += 2;
      now++;
      if (now > min(tot[2], tot[3])) break;
      modify(1, 1, R, B[now].t, -1);
      modify(1, 1, R, C[now].t, -1);
      cost += (B[now].t + C[now].t);
    }
  }
  int ans = 0;
  printf("%d\n", minn);
  for (int i = 1; i <= ans_A; i++) ans += A[i].t;
  for (int i = 1; i <= ans_B; i++) ans += (B[i].t + C[i].t);
  int cnt = 0;
  for (int i = ans_A + 1; i <= min(m, tot[1]); i++) E[++cnt] = A[i];
  for (int i = ans_B + 1; i <= tot[2]; i++) E[++cnt] = B[i];
  for (int i = ans_B + 1; i <= tot[3]; i++) E[++cnt] = C[i];
  for (int i = 1; i <= tot[4]; i++) E[++cnt] = D[i];
  sort(E + 1, E + cnt + 1, cmp);
  for (int i = 1; i <= ans_A; i++) printf("%d ", A[i].i);
  for (int i = 1; i <= ans_B; i++) printf("%d %d ", B[i].i, C[i].i);
  for (int i = 1; i <= m - ans_A - ans_B * 2; i++) printf("%d ", E[i].i);
  return 0;
}
