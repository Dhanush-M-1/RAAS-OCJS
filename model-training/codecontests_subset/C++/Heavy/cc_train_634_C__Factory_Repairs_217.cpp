#include <bits/stdc++.h>
using namespace std;
struct seg {
  int long long sum, sum2;
  seg(int long long sum = 0, int long long sum2 = 0) : sum(sum), sum2(sum2) {}
};
int long long x, y;
vector<seg> t;
void update(int long long l, int long long r, int long long pos,
            int long long v, int long long w) {
  if (l > pos || r < pos) return;
  if (l == r) {
    t[v].sum = min(x, t[v].sum + w);
    t[v].sum2 = min(y, t[v].sum2 + w);
    return;
  }
  int long long m = (l + r) / 2;
  update(l, m, pos, v * 2 + 1, w);
  update(m + 1, r, pos, v * 2 + 2, w);
  t[v].sum = t[v * 2 + 1].sum + t[v * 2 + 2].sum;
  t[v].sum2 = t[v * 2 + 1].sum2 + t[v * 2 + 2].sum2;
}
seg find_sum(int long long l, int long long r, int long long lt,
             int long long rt, int long long v) {
  if (l > rt || r < lt) {
    return seg();
  }
  if (l >= lt && r <= rt) return t[v];
  int long long m = (l + r) / 2;
  seg L = find_sum(l, m, lt, rt, v * 2 + 1);
  seg R = find_sum(m + 1, r, lt, rt, v * 2 + 2);
  return seg(L.sum + R.sum, L.sum2 + R.sum2);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie();
  cout.tie();
  int long long n, k, q, mode, z, w;
  cin >> n >> k >> x >> y >> q;
  t.resize(n * 4);
  for (int i = 0; i < q; i++) {
    cin >> mode;
    if (mode == 1) {
      cin >> z >> w;
      z--;
      update(0, n - 1, z, 0, w);
    } else {
      cin >> z;
      z--;
      cout << find_sum(0, n - 1, 0, z - 1, 0).sum2 +
                  find_sum(0, n - 1, z + k, n - 1, 0).sum
           << endl;
    }
  }
}
