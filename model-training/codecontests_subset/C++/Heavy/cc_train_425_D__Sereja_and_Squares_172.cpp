#include <bits/stdc++.h>
using namespace std;
inline long long myHash(long long x, long long y) { return (x << 20) + y; }
unordered_set<long long> have;
struct point {
  int x, y;
  point *nextSameX, *nextSameY;
  int nNextX, nNextY;
  point() {
    nextSameX = nextSameY = NULL;
    nNextX = nNextY = 0;
  }
} * P[100001];
bool byX(point *a, point *b) {
  if (a->x != b->x) return a->x < b->x;
  return a->y < b->y;
}
bool byY(point *a, point *b) {
  if (a->y != b->y) return a->y < b->y;
  return a->x < b->x;
}
int n;
inline bool check(int x, int y, int x2, int y2) {
  int a = x2 + y2 - x - y;
  if (have.count(myHash(x + a, y + a)))
    if (have.count(myHash(x + a, y)))
      if (have.count(myHash(x, y + a))) return true;
  return false;
}
int MAIN() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    P[i] = new point();
    cin >> P[i]->x >> P[i]->y;
    have.insert(myHash(P[i]->x, P[i]->y));
  }
  sort(P + 1, P + 1 + n, byX);
  for (int i = n - 1; i >= 1; i--)
    if (P[i]->x == P[i + 1]->x) {
      P[i]->nextSameX = P[i + 1];
      P[i]->nNextX = P[i + 1]->nNextX + 1;
    }
  sort(P + 1, P + 1 + n, byY);
  for (int i = n - 1; i >= 1; i--)
    if (P[i]->y == P[i + 1]->y) {
      P[i]->nextSameY = P[i + 1];
      P[i]->nNextY = P[i + 1]->nNextY + 1;
    }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (P[i]->nNextX < P[i]->nNextY) {
      point *p = P[i];
      for (int j = 1; j <= P[i]->nNextX; j++) {
        p = p->nextSameX;
        ans += check(P[i]->x, P[i]->y, p->x, p->y);
      }
    } else {
      point *p = P[i];
      for (int j = 1; j <= P[i]->nNextY; j++) {
        p = p->nextSameY;
        ans += check(P[i]->x, P[i]->y, p->x, p->y);
      }
    }
  }
  cout << ans << endl;
  return 0;
}
int main() {
  ios ::sync_with_stdio(false);
  cout << fixed << setprecision(16);
  return MAIN();
}
