#include <bits/stdc++.h>
using namespace std;
struct inp {
  int a, b, c, d;
};
int n, m, a[5005], inc[5005], maks[5005];
int kom;
int l, r, incc, makss;
vector<inp> v;
inp vv;
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    inc[i] = 0;
    maks[i] = 1000000000;
  }
  for (int i = 1; i <= m; i++) {
    scanf("%d", &kom);
    vv.a = kom;
    if (kom == 1) {
      scanf("%d %d %d", &l, &r, &incc);
      vv.b = l;
      vv.c = r;
      vv.d = incc;
      for (int j = l; j <= r; j++) {
        inc[j] += incc;
      }
    }
    if (kom == 2) {
      scanf("%d %d %d", &l, &r, &makss);
      vv.b = l;
      vv.c = r;
      vv.d = makss;
      for (int j = l; j <= r; j++) {
        maks[j] = min(maks[j], makss - inc[j]);
      }
    }
    v.push_back(vv);
  }
  for (int i = 1; i <= n; i++) {
    a[i] = maks[i];
  }
  bool moze = true;
  for (int i = 0; i < m; i++) {
    if (v[i].a == 1) {
      for (int j = v[i].b; j <= v[i].c; j++) {
        a[j] += v[i].d;
      }
    }
    if (v[i].a == 2) {
      int tempmaks = a[v[i].b];
      for (int j = v[i].b; j <= v[i].c; j++) {
        tempmaks = max(tempmaks, a[j]);
      }
      if (tempmaks != v[i].d) {
        moze = false;
        break;
      }
    }
  }
  if (!moze)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    for (int i = 1; i <= n; i++) cout << maks[i] << " ";
  }
  return 0;
}
