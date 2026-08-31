#include <bits/stdc++.h>
using namespace std;
const int MAXN = 900000;
int papa[MAXN], peso[MAXN], custo[MAXN];
int k;
bool obg[MAXN];
int find(int a) {
  if (papa[a] == -1) return a;
  return papa[a] = find(papa[a]);
}
bool juntos(int a, int b) { return find(a) == find(b); }
void uni(int a, int b) {
  a = find(a);
  b = find(b);
  if (peso[a] < peso[b]) swap(a, b);
  peso[a] += peso[b];
  papa[b] = a;
  custo[a] += custo[b];
  obg[a] = obg[a] || obg[b];
}
int con(int a) {
  int aa = find(a + k);
  a = find(a);
  if (obg[a]) return custo[a];
  if (obg[aa]) return custo[aa];
  return min(custo[a], custo[aa]);
}
char word[MAXN];
vector<int> lam[MAXN];
int main() {
  int n;
  scanf("%d%d", &n, &k);
  scanf("%s", word);
  for (int i = 0; i < k; i++) {
    int c;
    scanf("%d", &c);
    for (int j = 0; j < c; j++) {
      int num;
      scanf("%d", &num);
      lam[num - 1].emplace_back(i);
    }
  }
  memset(papa, -1, sizeof papa);
  int res = 0;
  for (int i = 0; i < k; i++) custo[i] = 1;
  for (int i = 0; i < n; i++) {
    if (lam[i].size() == 0) {
    } else if (lam[i].size() == 1) {
      int a = lam[i][0];
      res -= con(a);
      obg[find(word[i] == '0' ? a : a + k)] = true;
      res += con(a);
    } else if (lam[i].size() == 2) {
      int a = lam[i][0];
      int b = lam[i][1];
      if (!juntos(a, b) && !juntos(a, b + k)) {
        res -= con(a) + con(b);
        if (word[i] == '0') {
          uni(a, b + k);
          uni(b, a + k);
        } else {
          uni(a, b);
          uni(a + k, b + k);
        }
        res += con(a);
      }
    }
    printf("%d\n", res);
  }
  return 0;
}
