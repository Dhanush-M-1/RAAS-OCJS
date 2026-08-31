#include <bits/stdc++.h>
using namespace std;
inline void pisz(int n) { printf("%d\n", n); }
template <typename T, typename TT>
ostream& operator<<(ostream& s, pair<T, TT> t) {
  return s << "(" << t.first << "," << t.second << ")";
}
template <typename T>
ostream& operator<<(ostream& s, vector<T> t) {
  for (int(i) = 0; (i) < (t.size()); ++(i)) s << t[i] << " ";
  return s;
}
bool check(long long cx, long long cy, long long ux, long long uy) {
  if (cx == 0 && cy == 0) {
    return (cx == ux && cy == uy);
  }
  long long detA = -cx * cx - cy * cy;
  long long detA1 = -cx * ux - cy * uy;
  long long detA2 = cx * uy - ux * cy;
  if (detA1 % detA != 0) return false;
  if (detA2 % detA != 0) return false;
  return true;
}
int main() {
  int(ax1), (ay1);
  scanf("%d %d", &(ax1), &(ay1));
  int(bx1), (by1);
  scanf("%d %d", &(bx1), &(by1));
  int(cx1), (cy1);
  scanf("%d %d", &(cx1), &(cy1));
  long long ax = ax1, bx = bx1, cx = cx1, ay = ay1, by = by1, cy = cy1;
  vector<pair<long long, long long> > v;
  v.push_back(make_pair(bx - ax, by - ay));
  v.push_back(make_pair(bx - ay, by + ax));
  v.push_back(make_pair(bx + ax, by + ay));
  v.push_back(make_pair(bx + ay, by - ax));
  for (int(j) = 0; (j) < (4); ++(j))
    if (check(cx, cy, v[j].first, v[j].second)) {
      printf("YES\n");
      return 0;
    }
  printf("NO\n");
}
