#include <bits/stdc++.h>
const int MOD = 1000000007;
using namespace std;
const int MX = 100010;
const int SZ = 350;
long long ans;
vector<int> pts[MX];
int N;
bool is(int x, int y) {
  if (y < 0 || y >= MX) return false;
  auto it = lower_bound(pts[y].begin(), pts[y].end(), x);
  return it != pts[y].end() && *it == x;
}
int main() {
  scanf("%d", &(N));
  for (int k = (0); k < (N); k++) {
    int x;
    scanf("%d", &(x));
    ;
    int y;
    scanf("%d", &(y));
    ;
    pts[y].push_back(x);
  }
  for (int i = (0); i < (MX); i++) sort(pts[i].begin(), pts[i].end());
  vector<int> large;
  for (int ypos = (0); ypos < (MX); ypos++) {
    if (pts[ypos].size() > SZ)
      large.push_back(ypos);
    else {
      auto& V = pts[ypos];
      for (int i = (0); i < (V.size()); i++)
        for (int j = (i + 1); j < (V.size()); j++) {
          int d = V[j] - V[i];
          if (ypos - d >= 0 && pts[ypos - d].size() > SZ)
            ans += is(V[i], ypos - d) && is(V[j], ypos - d);
          ans += is(V[i], ypos + d) && is(V[j], ypos + d);
        }
    }
  }
  for (int i = (0); i < (large.size()); i++)
    for (int j = (i + 1); j < (large.size()); j++) {
      int a = large[i];
      int b = large[j];
      auto& A = pts[a];
      auto& B = pts[b];
      int d = b - a;
      int l1 = 0;
      int r1 = 0;
      int r2 = 0;
      for (int l2 = 0; l2 < A.size(); l2++) {
        int p = A[l2];
        while (p - A[l1] > d) l1++;
        while (r2 < B.size() && p > B[r2]) r2++;
        if (r2 == B.size()) break;
        while (p - B[r1] > d) r1++;
        ans += A[l2] == B[r2] && B[r1] == p - d && A[l1] == p - d;
      }
    }
  printf("%lld\n", ans);
}
