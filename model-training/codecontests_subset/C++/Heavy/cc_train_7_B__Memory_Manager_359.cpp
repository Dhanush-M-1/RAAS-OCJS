#include <bits/stdc++.h>
using namespace std;
struct Elem {
  int ind, f, l;
  Elem(int ind, int f, int l) {
    this->ind = ind;
    this->f = f;
    this->l = l;
  }
};
ifstream fin("/home/home/cf7/input.txt");
int n, nn, ss;
string com;
list<Elem> m;
list<Elem>::iterator it1, it2, pos;
int comx;
int q, i, j, d;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> nn >> ss;
  m.push_back(Elem(0, 0, 0));
  for (q = 0; q < nn; q++) {
    cin >> com;
    if (com[0] == 'a') {
      cin >> comx;
      pos = m.end();
      for (it2 = m.begin(), it2++; it2 != m.end(); it2++) {
        it1 = it2;
        it1--;
        d = it2->f - it1->l - 1;
        if (d >= comx) {
          pos = it1;
          break;
        }
      }
      if (pos == m.end()) {
        it1 = m.end();
        it1--;
        d = ss - it1->l;
        if (d >= comx) {
          pos = it1;
        }
      }
      if (pos != m.end()) {
        it1 = pos;
        it1++;
        n++;
        m.insert(it1, Elem(n, pos->l + 1, pos->l + comx));
        cout << n << endl;
      } else
        cout << "NULL\n";
    } else if (com[0] == 'd') {
      for (it2 = m.begin(), it2++; it2 != m.end(); it2++) {
        it1 = it2;
        it1--;
        d = it2->l - it2->f;
        it2->f = it1->l + 1;
        it2->l = it2->f + d;
      }
    } else if (com[0] == 'e') {
      cin >> comx;
      for (it2 = m.begin(), it2++; it2 != m.end(); it2++) {
        if (it2->ind == comx) break;
      }
      if (it2 != m.end())
        m.erase(it2);
      else
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
    }
  }
  return 0;
}
