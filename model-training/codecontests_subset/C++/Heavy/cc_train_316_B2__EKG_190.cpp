#include <bits/stdc++.h>
using namespace std;
const int N = 1001;
int a[N];
int n, x;
vector<int> za[N];
int deg[N];
vector<int> dls;
int bPos;
bool F[N];
int main() {
  scanf("%d %d", &n, &x);
  for (int i = 0; i < (n); ++i) {
    scanf("%d", &a[i + 1]);
    ++deg[a[i + 1]];
  }
  for (int i = 1; i <= (n); ++i) {
    if (deg[i] == 0) {
      int cur = i;
      int dl = 0;
      int posX = -1;
      while (a[cur] != 0) {
        if (cur == x) posX = dl;
        ++dl;
        cur = a[cur];
      }
      if (cur == x) posX = dl;
      ++dl;
      if (posX != -1) {
        bPos = dl - posX;
      } else {
        dls.push_back(dl);
      }
    }
  }
  F[0] = true;
  for (typeof((dls).begin()) p = ((dls).begin()); p != (dls).end(); ++p) {
    for (int i = n; i >= (*p); --i) F[i] |= F[i - *p];
  }
  for (int i = 0; i < (n + 1); ++i)
    if (F[i]) printf("%d\n", i + bPos);
}
