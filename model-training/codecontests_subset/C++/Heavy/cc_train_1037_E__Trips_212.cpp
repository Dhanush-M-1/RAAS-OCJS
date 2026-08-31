#include <bits/stdc++.h>
using namespace std;
int l[200100], r[200100];
int n, m, k;
int de[200100];
bool ex[200100];
struct ind {
  int id, de;
  ind(int a, int b) : id(a), de(b) {}
  bool operator<(const ind &b) const {
    return de != b.de ? de < b.de : id < b.id;
  }
};
vector<int> pa[200100];
set<ind> S;
int fd(int id, int x) { return l[id] == x ? r[id] : l[id]; }
void erase(int x) {
  if (de[x] < k) return;
  S.erase(ind(x, de[x]));
  de[x]--;
  S.insert(ind(x, de[x]));
}
void dele(int x) {
  S.erase(ind(x, de[x]));
  for (auto y : pa[x])
    if (!ex[y] && de[fd(y, x)] >= k) erase(fd(y, x));
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  int a, b;
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d", &a, &b);
    ++de[a], ++de[b];
    l[i] = a, r[i] = b;
    pa[a].push_back(i);
    pa[b].push_back(i);
  }
  for (int i = 1; i <= n; ++i) S.insert(ind(i, de[i]));
  int as[200100];
  for (int i = m; i >= 1; --i) {
    while (S.size()) {
      if ((*S.begin()).de < k)
        dele((*S.begin()).id);
      else
        break;
    }
    as[i] = S.size();
    int x = l[i], y = r[i];
    if (de[x] >= k && de[y] >= k) erase(x), erase(y);
    ex[i] = 1;
  }
  for (int i = 1; i <= m; ++i) printf("%d\n", as[i]);
  return 0;
}
