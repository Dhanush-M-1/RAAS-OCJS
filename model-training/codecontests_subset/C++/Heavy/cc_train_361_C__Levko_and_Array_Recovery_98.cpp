#include <bits/stdc++.h>
using namespace std;
int n, m;
struct quer {
  int type;
  int r, l;
  int val;
};
vector<quer> inp;
vector<long long> bords;
void modbd(quer q) {
  if (q.type == 1) {
    for (int a = q.l; a <= q.r; ++a) {
      bords[a] += q.val;
    }
  } else {
    for (int a = q.l; a <= q.r; ++a) {
      bords[a] = min(bords[a], (long long)q.val);
    }
  }
}
bool lookup(quer q) {
  if (q.type == 1) {
    for (int a = q.l; a <= q.r; ++a) {
      bords[a] -= q.val;
    }
  } else {
    long long mv = -2e15;
    for (int a = q.l; a <= q.r; ++a) {
      mv = max(bords[a], mv);
    }
    if (mv != q.val) return false;
  }
  return true;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < m; ++i) {
    quer b;
    scanf("%d%d%d%d", &b.type, &b.l, &b.r, &b.val);
    b.l -= 1;
    b.r -= 1;
    inp.push_back(b);
  }
  bords = vector<long long>(n, 1e9);
  for (int i = 0; i < m; ++i) {
    modbd(inp[i]);
  }
  bool bad = false;
  for (int i = m - 1; i >= 0; --i) {
    if (!lookup(inp[i])) {
      bad = true;
      break;
    }
  }
  if (bad) {
    puts("NO");
    return 0;
  }
  puts("YES");
  for (int i = 0; i < bords.size(); ++i) {
    long long pv = bords[i];
    long long inf = 1000000000;
    if (pv > inf) {
      pv = inf;
    }
    if (pv < -inf) {
      pv = -inf;
    }
    int resv = pv;
    printf("%d ", resv);
  }
  return 0;
}
