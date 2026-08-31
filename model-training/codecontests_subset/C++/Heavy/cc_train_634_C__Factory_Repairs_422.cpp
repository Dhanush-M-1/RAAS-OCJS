#include <bits/stdc++.h>
using namespace std;
const int BASE = 1 << 18;
int n, k, a, b, q, d, val, p, type;
int TreeA[1000000];
int TreeB[1000000];
void UpdateA(int, int);
void UpdateB(int, int);
int QueryA(int, int, int, int, int);
int QueryB(int, int, int, int, int);
int main() {
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int i = 1; i <= q; i++) {
    scanf("%d", &type);
    if (type == 1) {
      scanf("%d %d", &d, &val);
      UpdateA(d, val);
      UpdateB(d, val);
    } else {
      scanf("%d", &p);
      printf("%d\n", QueryB(1, 0, BASE - 1, 0, p - 1) +
                         QueryA(1, 0, BASE - 1, p + k, n));
    }
  }
}
void UpdateA(int x, int val) {
  x += BASE;
  if (TreeA[x] != a) {
    TreeA[x] += val;
    TreeA[x] = min(a, TreeA[x]);
    do {
      x /= 2;
      TreeA[x] = TreeA[x * 2] + TreeA[x * 2 + 1];
    } while (x != 1);
  }
}
void UpdateB(int x, int val) {
  x += BASE;
  if (TreeB[x] != b) {
    TreeB[x] += val;
    TreeB[x] = min(b, TreeB[x]);
    do {
      x /= 2;
      TreeB[x] = TreeB[x * 2] + TreeB[x * 2 + 1];
    } while (x != 1);
  }
}
int QueryA(int i, int pocz, int kon, int a, int b) {
  if (a <= pocz && kon <= b) {
    return TreeA[i];
  } else {
    int sum = 0;
    int sr = (pocz + kon) / 2;
    if (a <= sr) {
      sum += QueryA(i * 2, pocz, sr, a, b);
    }
    if (sr + 1 <= b) {
      sum += QueryA(i * 2 + 1, sr + 1, kon, a, b);
    }
    return sum;
  }
}
int QueryB(int i, int pocz, int kon, int a, int b) {
  if (a <= pocz && kon <= b) {
    return TreeB[i];
  } else {
    int sum = 0;
    int sr = (pocz + kon) / 2;
    if (a <= sr) {
      sum += QueryB(i * 2, pocz, sr, a, b);
    }
    if (sr + 1 <= b) {
      sum += QueryB(i * 2 + 1, sr + 1, kon, a, b);
    }
    return sum;
  }
}
