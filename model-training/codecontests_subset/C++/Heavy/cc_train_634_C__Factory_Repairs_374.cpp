#include <bits/stdc++.h>
using namespace std;
class Summator {
 private:
  int n;
  vector<int> s;
  inline int prev(int x) { return x & (x - 1); }
  inline int next(int x) { return (x << 1) - (x & (x - 1)); }

 public:
  Summator(int n) {
    this->n = n;
    s.resize(n + 1, 0);
  }
  void modify(int pos, int diff) {
    pos++;
    int x = pos;
    while (x <= n) {
      s[x] += diff;
      x = next(x);
    }
  }
  int sum(int l, int r) {
    l++;
    r++;
    int sum = 0;
    int x = r;
    while (x > 0) {
      sum += s[x];
      x = prev(x);
    }
    x = l - 1;
    while (x > 0) {
      sum -= s[x];
      x = prev(x);
    }
    return sum;
  }
};
int main() {
  int n, k, A, B, q;
  int key, d, x, p;
  cin >> n >> k >> A >> B >> q;
  Summator a(n), b(n);
  vector<int> aa(n, 0), bb(n, 0);
  for (int qq = 0; qq < q; qq++) {
    cin >> key;
    if (key == 1) {
      cin >> d >> x;
      d--;
      if (aa[d] < A) {
        int diff = min(A - aa[d], x);
        a.modify(d, diff);
        aa[d] += diff;
      }
      if (bb[d] < B) {
        int diff = min(B - bb[d], x);
        b.modify(d, diff);
        bb[d] += diff;
      }
    } else if (key == 2) {
      cin >> p;
      p--;
      int rez = (p - 1 >= 0 ? b.sum(0, p - 1) : 0) +
                (p + k <= n - 1 ? a.sum(p + k, n - 1) : 0);
      cout << rez << endl;
    }
  }
  return 0;
}
