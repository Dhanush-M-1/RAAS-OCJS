#include <bits/stdc++.h>
using namespace std;
const int MAX = 200005;
struct BIT {
  int tree[200005];
  BIT() { memset(tree, 0, sizeof(tree)); }
  void add(int i, int val) {
    while (i < MAX) {
      tree[i] += val;
      i += (i & -i);
    }
  }
  int read(int i) {
    int sm = 0;
    while (i > 0) {
      sm += tree[i];
      i -= (i & -i);
    }
    return sm;
  }
};
int ord[200005];
int main() {
  memset(ord, 0, sizeof(ord));
  int n, k, a, b, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  BIT t1;
  BIT t2;
  while (q--) {
    int c;
    scanf("%d", &c);
    if (c == 1) {
      int d, ai;
      scanf("%d %d", &d, &ai);
      int olda, oldb;
      olda = ord[d];
      oldb = olda;
      if (olda >= b) olda = b;
      if (oldb >= a) oldb = a;
      ord[d] += ai;
      int nw = ord[d];
      int nwa = min(b, nw);
      int nwb = min(a, nw);
      t1.add(d, nwa - olda);
      t2.add(d, nwb - oldb);
    } else {
      int p;
      scanf("%d", &p);
      int sm = t1.read(p - 1);
      p += k - 1;
      sm += t2.read(200003) - t2.read(p);
      printf("%d\n", sm);
    }
  }
}
