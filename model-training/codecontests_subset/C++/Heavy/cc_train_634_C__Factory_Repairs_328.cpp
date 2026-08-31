#include <bits/stdc++.h>
using namespace std;
class SumSegmentTree {
  int *st;
  int n;
  int getMid(int s, int e) { return s + (e - s) / 2; }
  int constructSTUtil(int arr[], int ss, int se, int *st, int si) {
    if (ss == se) {
      st[si] = arr[ss];
      return st[si];
    }
    int mid = getMid(ss, se);
    st[si] = constructSTUtil(arr, ss, mid, st, si * 2 + 1) +
             constructSTUtil(arr, mid + 1, se, st, si * 2 + 2);
    return st[si];
  }
  void updateValue(int *st, int ss, int se, int i, int v, int si) {
    if (i < ss || i > se) return;
    if (ss == se) {
      st[si] = v;
      return;
    }
    int mid = getMid(ss, se);
    updateValue(st, ss, mid, i, v, si * 2 + 1);
    updateValue(st, mid + 1, se, i, v, si * 2 + 2);
    st[si] = st[si * 2 + 1] + st[si * 2 + 2];
  }
  int getVector(int *st, int ss, int se, int qs, int qe, int si) {
    if (qs <= ss && qe >= se) {
      return st[si];
    }
    if (se < qs || ss > qe) {
      return 0;
    }
    int mid = getMid(ss, se);
    return getVector(st, ss, mid, qs, qe, si * 2 + 1) +
           getVector(st, mid + 1, se, qs, qe, si * 2 + 2);
  }

 public:
  SumSegmentTree(int arr[], int n) {
    int x = (int)(ceil(log2(n)));
    int max_size = 2 * (int)pow(2, x) - 1;
    this->st = new int[max_size];
    this->n = n;
    constructSTUtil(arr, 0, n - 1, st, 0);
  }
  void update(int i, int v) {
    this->updateValue(this->st, 0, this->n - 1, i, v, 0);
  }
  int query(int qs, int qe) {
    return this->getVector(this->st, 0, this->n - 1, qs, qe, 0);
  }
};
int main() {
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  int *v1 = new int[n];
  int *v2 = new int[n];
  for (int i = 0; i < n; i++) {
    v1[i] = 0;
    v2[i] = 0;
  }
  SumSegmentTree s1 = SumSegmentTree(v1, n);
  SumSegmentTree s2 = SumSegmentTree(v2, n);
  for (int i = 0; i < q; i++) {
    int l;
    cin >> l;
    if (l == 1) {
      int d, v;
      cin >> d >> v;
      d--;
      int novo_v1 = min(b, v1[d] + v);
      v1[d] = novo_v1;
      s1.update(d, novo_v1);
      int novo_v2 = min(a, v2[d] + v);
      v2[d] = novo_v2;
      s2.update(d, novo_v2);
    } else {
      int p;
      cin >> p;
      p--;
      int resposta = 0;
      if (p > 0) resposta += s1.query(0, p - 1);
      if (p + k < n) resposta += s2.query(p + k, n);
      cout << resposta << endl;
    }
  }
  return 0;
}
