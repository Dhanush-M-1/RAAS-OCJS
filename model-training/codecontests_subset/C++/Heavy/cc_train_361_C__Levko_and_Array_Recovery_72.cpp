#include <bits/stdc++.h>
using namespace std;
struct data {
  int type;
  int a, b, c;
};
pair<int, int> dp[5000 + 8];
int path[5000 + 8];
int main() {
  int n, m;
  scanf("%d", &n);
  scanf("%d", &m);
  data A[m + 8];
  for (int i = 0; i < m; i++) {
    scanf("%d", &A[i].type);
    scanf("%d", &A[i].a);
    scanf("%d", &A[i].b);
    scanf("%d", &A[i].c);
  }
  int M = -1000000001;
  for (int i = 0; i < n + 1; i++) {
    dp[i].first = dp[i].second = M;
    dp[i].second = M;
  }
  for (int i = 0; i < m; i++) {
    if (A[i].type == 1) {
      for (int j = A[i].a; j < A[i].b + 1; j++) {
        path[j] += A[i].c;
      }
    } else {
      for (int j = A[i].a; j < A[i].b + 1; j++) {
        if (dp[j].first == M) {
          dp[j].first = A[i].c - path[j];
        } else {
          if (dp[j].first > A[i].c - path[j]) {
            dp[j].first = A[i].c - path[j];
          }
        }
      }
    }
  }
  int maxi;
  for (int i = 0; i < n + 1; i++) {
    dp[i].second = dp[i].first;
  }
  for (int i = 0; i < m; i++) {
    if (A[i].type == 1) {
      for (int j = A[i].a; j < A[i].b + 1; j++) {
        dp[j].first += A[i].c;
      }
    } else if (A[i].type == 2) {
      maxi = INT_MIN;
      for (int j = A[i].a; j < A[i].b + 1; j++) {
        maxi = max(maxi, dp[j].first);
      }
      if (maxi != A[i].c) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 0; i < n; i++) {
    if (dp[i + 1].second == M) {
      printf("%d ", -1);
      ;
    } else
      printf("%d ", dp[i + 1].second);
    ;
  }
  printf("\n");
  return 0;
}
