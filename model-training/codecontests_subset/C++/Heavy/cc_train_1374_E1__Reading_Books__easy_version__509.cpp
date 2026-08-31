#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long f = 1, ans = 0;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    ans = ans * 10 + c - '0';
    c = getchar();
  }
  return f * ans;
}
const long long MAXN = 4e5 + 11;
long long N, M, K, na, nb, nc, nd, Minn = LLONG_MAX, SA[MAXN], SB[MAXN],
                                   SC[MAXN], SD[MAXN];
long long tmp1[MAXN], tmp2[MAXN], tmp3[MAXN], tmp4[MAXN];
pair<long long, long long> A[MAXN], B[MAXN], C[MAXN], D[MAXN];
long long sta1[MAXN], sta2[MAXN], sta3[MAXN], sta4[MAXN];
long long QA(long long x) {
  return lower_bound(tmp1 + 1, tmp1 + N + 1, x + 1) - tmp1 - 1;
}
long long QB(long long x) {
  return lower_bound(tmp2 + 1, tmp2 + N + 1, x + 1) - tmp2 - 1;
}
long long QD(long long x) {
  return lower_bound(tmp4 + 1, tmp4 + N + 1, x + 1) - tmp4 - 1;
}
signed main() {
  N = read(), M = read(), K = read();
  for (long long i = 1; i <= N; i++) {
    long long t = read(), a = read(), b = read();
    pair<long long, long long> p = make_pair(t, i);
    if (a && b) C[++nc] = p;
    if (a && (!b)) A[++na] = p;
    if ((!a) && b) B[++nb] = p;
    if ((!a) && (!b)) D[++nd] = p;
  }
  for (long long i = na + 1; i <= N; i++) A[i] = make_pair(INT_MAX, 0);
  for (long long i = nb + 1; i <= N; i++) B[i] = make_pair(INT_MAX, 0);
  for (long long i = nc + 1; i <= N; i++) C[i] = make_pair(INT_MAX, 0);
  for (long long i = nd + 1; i <= N; i++) D[i] = make_pair(INT_MAX, 0);
  sort(A + 1, A + N + 1), sort(B + 1, B + N + 1), sort(C + 1, C + N + 1),
      sort(D + 1, D + N + 1);
  for (long long i = 1; i <= N; i++)
    SA[i] = SA[i - 1] + A[i].first, SB[i] = SB[i - 1] + B[i].first,
    SC[i] = SC[i - 1] + C[i].first, SD[i] = SD[i - 1] + D[i].first;
  for (long long i = 1; i <= N; i++)
    tmp1[i] = A[i].first, tmp2[i] = B[i].first, tmp3[i] = C[i].first,
    tmp4[i] = D[i].first;
  for (long long i = 0; i <= N; i++) {
    long long res = (max(K - i, 0ll)) * 2 + i;
    if (res > M) continue;
    if (res < 0) continue;
    long long ps1 = max(K - i, 0ll), ps2 = max(K - i, 0ll), l = 0, r = 10000,
              Ans = -1;
    long long Res = M - res;
    long long u1 = 0, u2 = 0, u4 = 0;
    while (l <= r) {
      long long mid = (l + r) >> 1;
      long long X = max(QA(mid) - ps1, 0ll), Y = max(QB(mid) - ps2, 0ll),
                Z = QD(mid);
      if (X + Y + Z >= Res)
        Ans = mid, u1 = X, u2 = Y, u4 = Z, r = mid - 1;
      else
        l = mid + 1;
    }
    if (Ans == -1) continue;
    long long W = SA[u1 + ps1] + SB[u2 + ps2] + SC[i] + SD[u4];
    long long Ha = (u1 + ps1 + u2 + ps2 + i + u4) - M;
    W -= Ha * Ans;
    Minn = min(Minn, W);
  }
  if (Minn > 2000000000) {
    printf("-1\n");
    return 0;
  }
  printf("%lld\n", Minn);
  for (long long i = 0; i <= N; i++) {
    long long res = (max(K - i, 0ll)) * 2 + i;
    if (res > M) continue;
    if (res < 0) continue;
    long long ps1 = max(K - i, 0ll), ps2 = max(K - i, 0ll), l = 0, r = 10000,
              Ans = -1;
    long long Res = M - res;
    long long u1 = 0, u2 = 0, u4 = 0;
    while (l <= r) {
      long long mid = (l + r) >> 1;
      long long X = max(QA(mid) - ps1, 0ll), Y = max(QB(mid) - ps2, 0ll),
                Z = QD(mid);
      if (X + Y + Z >= Res)
        Ans = mid, u1 = X, u2 = Y, u4 = Z, r = mid - 1;
      else
        l = mid + 1;
    }
    if (Ans == -1) continue;
    long long W = SA[u1 + ps1] + SB[u2 + ps2] + SC[i] + SD[u4];
    long long Ha = (u1 + ps1 + u2 + ps2 + i + u4) - M;
    W -= Ha * Ans;
    if (Minn == W) {
      long long tot1 = 0, tot2 = 0, tot3 = 0, tot4 = 0;
      for (long long j = 1; j <= u1 + ps1; j++) {
        if (A[j].first != Ans)
          printf("%lld ", A[j].second), tot1++;
        else
          sta1[++sta1[0]] = A[j].second;
      }
      for (long long j = 1; j <= u2 + ps2; j++) {
        if (B[j].first != Ans)
          printf("%lld ", B[j].second), tot2++;
        else
          sta2[++sta2[0]] = B[j].second;
      }
      for (long long j = 1; j <= u4; j++) {
        if (D[j].first != Ans)
          printf("%lld ", D[j].second), tot4++;
        else
          sta4[++sta4[0]] = D[j].second;
      }
      for (long long j = 1; j <= i; j++) {
        if (C[j].first != Ans)
          printf("%lld ", C[j].second), tot3++;
        else
          sta3[++sta3[0]] = C[j].second;
      }
      long long E = M - tot1 - tot2 - tot3 - tot4, ps1 = 1, ps2 = 1, ps3 = 1,
                ps4 = 1;
      for (long long i = 1; i <= E; i++) {
        if (tot1 < tot2 && ps1 <= sta1[0]) {
          printf("%lld ", sta1[ps1]);
          ps1++;
          tot1++;
          continue;
        }
        if (tot1 > tot2 && ps2 <= sta2[0]) {
          printf("%lld ", sta2[ps2]);
          ps2++;
          tot2++;
          continue;
        }
        if (ps3 <= sta3[0]) {
          printf("%lld ", sta3[ps3]);
          ps3++;
          continue;
        }
        if (ps1 <= sta1[0]) {
          printf("%lld ", sta1[ps1]);
          ps1++;
          continue;
        }
        if (ps2 <= sta2[0]) {
          printf("%lld ", sta2[ps2]);
          ps2++;
          continue;
        }
        if (ps4 <= sta4[0]) {
          printf("%lld ", sta4[ps4]);
          ps4++;
          continue;
        }
      }
      printf("\n");
      return 0;
    }
  }
  return 0;
}
