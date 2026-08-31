#include <bits/stdc++.h>
using namespace std;
int gInt() {
  int i;
  scanf("%d", &i);
  return i;
}
long long int gLong() {
  long long int i;
  scanf("%lld", &i);
  return i;
}
double gDouble() {
  double i;
  scanf("%lf", &i);
  return i;
}
void quit() {
  fflush(stdout);
  exit(0);
}
int rngminl[5005];
int rngminr[5005];
int rngminv[5005];
int rngmax[5005];
int hist[5005][5005];
int added[5005];
int n, m;
int main(int argc, char** argv) {
  n = gInt();
  m = gInt();
  for (int i = 0; i < n; i++) rngmax[i] = 1000000000;
  int t = 0;
  while (m--) {
    int type = gInt();
    int l = gInt() - 1;
    int r = gInt();
    int val = gInt();
    if (type == 1) {
      for (int i = l; i < r; i++) added[i] += val;
    } else {
      rngminl[t] = l;
      rngminr[t] = r;
      rngminv[t] = val;
      for (int i = l; i < r; i++) {
        int newrngmax = val - added[i];
        if (newrngmax < rngmax[i]) {
          rngmax[i] = newrngmax;
        }
      }
      for (int i = l; i < r; i++) hist[t][i] = added[i];
      t++;
    }
  }
  for (int i = 0; i < t; i++) {
    int l = rngminl[i];
    int r = rngminr[i];
    int v = rngminv[i];
    bool good = false;
    for (int j = l; j < r; j++) {
      if (rngmax[j] + hist[i][j] >= v) {
        good = true;
        break;
      }
    }
    if (!good) {
      printf("NO\n");
      quit();
    }
  }
  printf("YES\n");
  for (int i = 0; i < n; i++) printf("%d ", rngmax[i]);
  printf("\n");
  quit();
}
