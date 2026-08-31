#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int n, k;
struct Book {
  int t, a, b;
  bool operator<(const Book &w) const { return t < w.t; }
} books[N];
vector<int> a, b;
bool st[N];
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> books[i].t >> books[i].a >> books[i].b;
  }
  sort(books, books + n);
  int cnta = 0, cntb = 0;
  for (int i = 0; i < n; i++) {
    int t = books[i].t, x = books[i].a, y = books[i].b;
    if (!x && !y) {
      continue;
    } else if (x && y) {
      if (cnta < k && cntb < k) {
        cnta++, cntb++;
        st[i] = true;
      } else if (cnta < k && cntb >= k) {
        cnta++;
        st[i] = true;
        int c = b[b.size() - 1];
        b.pop_back();
        st[c] = false;
      } else if (cnta >= k && cntb < k) {
        cntb++;
        st[i] = true;
        int c = a[a.size() - 1];
        a.pop_back();
        st[c] = false;
      } else {
        if (!a.size() || !b.size()) {
          break;
        }
        int t1 = books[a[a.size() - 1]].t, t2 = books[b[b.size() - 1]].t;
        if (t < t1 + t2) {
          st[i] = true;
          int c = b[b.size() - 1];
          b.pop_back();
          st[c] = false;
          c = a[a.size() - 1];
          a.pop_back();
          st[c] = false;
        } else {
          break;
        }
      }
    } else if (x && !y && cnta < k) {
      cnta++;
      a.push_back(i);
      st[i] = true;
    } else if (!x && y && cntb < k) {
      cntb++;
      b.push_back(i);
      st[i] = true;
    }
  }
  if (cnta < k || cntb < k) {
    cout << -1 << endl;
  } else {
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (st[i]) {
        res += books[i].t;
      }
    }
    cout << res << endl;
  }
  return 0;
}
