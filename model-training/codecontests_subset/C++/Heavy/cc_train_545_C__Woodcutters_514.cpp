#include <bits/stdc++.h>
using namespace std;
typedef struct {
  int x;
  int h;
} point;
int main() {
  int n;
  cin >> n;
  list<point> tree;
  point x;
  for (int i = 0; i < n; i++) {
    cin >> x.x >> x.h;
    tree.push_back(x);
  }
  x = tree.front();
  x.x = x.x - x.h;
  x.h = 0;
  tree.push_front(x);
  int count = 1;
  list<point>::iterator i = tree.begin(), j, k;
  i++;
  j = i;
  i++;
  k = i;
  k++;
  for (; k != tree.end(); i++, j++, k++) {
    if ((*i).h > 0) {
      if (((*i).x - (*i).h) > (*j).x) {
        count++;
        x = *i;
        x.x = x.x - x.h;
        x.h = 0;
        tree.insert(i, x);
        j++;
      } else if (((*i).x + (*i).h) < (*k).x) {
        count++;
        x = *i;
        x.x = x.x + x.h;
        x.h = 0;
        tree.insert(k, x);
        j++;
        i++;
      }
    }
  }
  if (n > 1) count++;
  cout << count;
  return 0;
}
