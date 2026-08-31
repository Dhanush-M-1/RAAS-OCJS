#include <bits/stdc++.h>
using namespace std;
stack<pair<int, int> > s0, s1, s2, s3, s4, s5;
std::vector<std::vector<std::vector<int> > > a(200005), w(200005);
int n, m, k;
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i <= n + 1; i++) {
    a[i].resize(m + 5);
    w[i].resize(m + 5);
  }
  for (int i = 0; i <= n + 1; i++)
    for (int j = 0; j <= m + 1; j++) {
      a[i][j].resize(k + 5);
      w[i][j].resize(k + 5);
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++)
      for (int l = 1; l <= k; l++) a[i][j][l] = -1;
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= k; j++) {
      s0.push(make_pair(i, j));
      scanf("%d", &a[0][i][j]);
      w[0][i][j] = 1;
    }
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= k; j++) {
      s1.push(make_pair(i, j));
      scanf("%d", &a[n + 1][i][j]);
      w[n + 1][i][j] = n;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++) {
      s2.push(make_pair(i, j));
      scanf("%d", &a[i][0][j]);
      w[i][0][j] = 1;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++) {
      s3.push(make_pair(i, j));
      scanf("%d", &a[i][m + 1][j]);
      w[i][m + 1][j] = m;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      s4.push(make_pair(i, j));
      scanf("%d", &a[i][j][0]);
      w[i][j][0] = 1;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      s5.push(make_pair(i, j));
      scanf("%d", &a[i][j][k + 1]);
      w[i][j][k + 1] = k;
    }
  bool change = true;
  while (change) {
    change = false;
    while (!s0.empty()) {
      int I = s0.top().first, J = s0.top().second;
      s0.pop();
      for (;; w[0][I][J]++) {
        int *D = &w[0][I][J], *C = &a[0][I][J], *W = &a[w[0][I][J]][I][J];
        int X = w[0][I][J], Y = I, Z = J;
        if (*D == n + 1) {
          if (*C) {
            printf("-1");
            return 0;
          } else
            break;
        }
        if (*W == -1) {
          *W = *C;
          change = true;
          if (*C) break;
        } else if (*W == 0) {
          continue;
        } else if (*W == *C) {
          if (*C) break;
        } else {
          *W = 0;
          change = true;
          s1.push(make_pair(Y, Z));
          s2.push(make_pair(X, Z));
          s3.push(make_pair(X, Z));
          s4.push(make_pair(X, Y));
          s5.push(make_pair(X, Y));
        }
        if (*D == n && *C) {
          printf("-1");
          return 0;
        }
      }
    }
    while (!s1.empty()) {
      int I = s1.top().first, J = s1.top().second;
      s1.pop();
      for (;; w[n + 1][I][J]--) {
        int *D = &w[n + 1][I][J], *C = &a[n + 1][I][J],
            *W = &a[w[n + 1][I][J]][I][J];
        int X = w[n + 1][I][J], Y = I, Z = J;
        if (*D == 0) {
          if (*C) {
            printf("-1");
            return 0;
          } else
            break;
        }
        if (*W == -1) {
          *W = *C;
          change = true;
          if (*C) break;
        } else if (*W == 0) {
          continue;
        } else if (*W == *C) {
          if (*C) break;
        } else {
          *W = 0;
          change = true;
          s0.push(make_pair(Y, Z));
          s2.push(make_pair(X, Z));
          s3.push(make_pair(X, Z));
          s4.push(make_pair(X, Y));
          s5.push(make_pair(X, Y));
        }
        if (*D == 0 && *C) {
          printf("-1");
          return 0;
        }
      }
    }
    while (!s2.empty()) {
      int I = s2.top().first, J = s2.top().second;
      s2.pop();
      for (;; w[I][0][J]++) {
        int *D = &w[I][0][J], *C = &a[I][0][J], *W = &a[I][w[I][0][J]][J];
        int X = I, Y = w[I][0][J], Z = J;
        if (*D == m + 1) {
          if (*C) {
            printf("-1");
            return 0;
          } else
            break;
        }
        if (*W == -1) {
          *W = *C;
          change = true;
          if (*C) break;
        } else if (*W == 0) {
          continue;
        } else if (*W == *C) {
          if (*C) break;
        } else {
          *W = 0;
          change = true;
          s0.push(make_pair(Y, Z));
          s1.push(make_pair(Y, Z));
          s3.push(make_pair(X, Z));
          s4.push(make_pair(X, Y));
          s5.push(make_pair(X, Y));
        }
      }
    }
    while (!s3.empty()) {
      int I = s3.top().first, J = s3.top().second;
      s3.pop();
      for (;; w[I][m + 1][J]--) {
        int *D = &w[I][m + 1][J], *C = &a[I][m + 1][J],
            *W = &a[I][w[I][m + 1][J]][J];
        int X = I, Y = w[I][m + 1][J], Z = J;
        if (*D == 0) {
          if (*C) {
            printf("-1");
            return 0;
          } else
            break;
        }
        if (*W == -1) {
          *W = *C;
          change = true;
          if (*C) break;
        } else if (*W == 0) {
          continue;
        } else if (*W == *C) {
          if (*C) break;
        } else {
          *W = 0;
          change = true;
          s0.push(make_pair(Y, Z));
          s1.push(make_pair(Y, Z));
          s2.push(make_pair(X, Z));
          s4.push(make_pair(X, Y));
          s5.push(make_pair(X, Y));
        }
        if (*D == 0 && *C) {
          printf("-1");
          return 0;
        }
      }
    }
    while (!s4.empty()) {
      int I = s4.top().first, J = s4.top().second;
      s4.pop();
      for (;; w[I][J][0]++) {
        int *D = &w[I][J][0], *C = &a[I][J][0], *W = &a[I][J][w[I][J][0]];
        int X = I, Y = J, Z = w[I][J][0];
        if (*D == k + 1) {
          if (*C) {
            printf("-1");
            return 0;
          } else
            break;
        }
        if (*W == -1) {
          *W = *C;
          change = true;
          if (*C) break;
        } else if (*W == 0) {
          continue;
        } else if (*W == *C) {
          if (*C) break;
        } else {
          *W = 0;
          change = true;
          s0.push(make_pair(Y, Z));
          s1.push(make_pair(Y, Z));
          s2.push(make_pair(X, Z));
          s3.push(make_pair(X, Z));
          s5.push(make_pair(X, Y));
        }
        if (*D == k && *C) {
          printf("-1");
          return 0;
        }
      }
    }
    while (!s5.empty()) {
      int I = s5.top().first, J = s5.top().second;
      s5.pop();
      for (;; w[I][J][k + 1]--) {
        int *D = &w[I][J][k + 1], *C = &a[I][J][k + 1],
            *W = &a[I][J][w[I][J][k + 1]];
        int X = I, Y = J, Z = w[I][J][k + 1];
        if (*D == 0) {
          if (*C) {
            printf("-1");
            return 0;
          } else
            break;
        }
        if (*W == -1) {
          *W = *C;
          change = true;
          if (*C) break;
        } else if (*W == 0) {
          continue;
        } else if (*W == *C) {
          if (*C) break;
        } else {
          *W = 0;
          change = true;
          s0.push(make_pair(Y, Z));
          s1.push(make_pair(Y, Z));
          s2.push(make_pair(X, Z));
          s3.push(make_pair(X, Z));
          s4.push(make_pair(X, Y));
        }
        if (*D == 0 && *C) {
          printf("-1");
          return 0;
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
      for (int l = 1; l <= k; l++) {
        if (~a[i][j][l])
          printf("%d ", a[i][j][l]);
        else
          printf("0 ");
      }
      printf("\n");
    }
    printf("\n");
  }
  return 0;
}
