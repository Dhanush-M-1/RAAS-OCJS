#include <bits/stdc++.h>
const int MAX_N = 200000;
int v[1 + MAX_N], poz[1 + MAX_N], sorted[1 + MAX_N];
bool cmp(int a, int b) { return v[a] < v[b]; }
std::vector<int> src[1 + MAX_N], target[1 + MAX_N];
void normalize(int n) {
  std::sort(poz + 1, poz + 1 + n, cmp);
  int last = v[poz[1]], j = 1;
  for (int i = 1; i <= n; ++i)
    if (v[poz[i]] == last)
      v[poz[i]] = j;
    else {
      last = v[poz[i]];
      v[poz[i]] = ++j;
    }
}
int sef[1 + MAX_N], sizeSet[1 + MAX_N];
int edge[1 + MAX_N];
int getSef(int nod) {
  if (nod == sef[nod])
    return nod;
  else {
    sef[nod] = getSef(sef[nod]);
    return sef[nod];
  }
}
bool myUnion(int a, int b) {
  int sa = getSef(a), sb = getSef(b);
  if (sa != sb) {
    sef[sa] = sb;
    sizeSet[sb] += sizeSet[sa];
    return true;
  }
  return false;
}
int startcycle[MAX_N];
void buildCycles(int n, int &cycles, int rupturi) {
  int top = 0, ruptureCycle = 0;
  for (int i = 1; i <= n; ++i) {
    sef[i] = i;
    sizeSet[i] = 1;
  }
  for (int i = 1; i <= n; ++i)
    for (int j = 0; j < src[i].size(); ++j) {
      edge[src[i][j]] = target[i][j];
      cycles -= myUnion(src[i][j], target[i][j]);
    }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j < src[i].size(); ++j)
      if (getSef(src[i][0]) != getSef(src[i][j])) {
        cycles -= myUnion(src[i][0], src[i][j]);
        std::swap(edge[src[i][0]], edge[src[i][j]]);
      }
  for (int i = 1; i <= n; ++i)
    if (i == sef[i] && sizeSet[i] > 1) startcycle[top++] = i;
  if (cycles > 1 && rupturi > 1) {
    ruptureCycle = std::min(cycles, rupturi);
    if (ruptureCycle > 1) {
      ++cycles;
      int aux = edge[startcycle[ruptureCycle - 1]];
      for (int i = ruptureCycle - 1; i > 0; --i) {
        edge[startcycle[i]] = edge[startcycle[i - 1]];
        --cycles;
      }
      edge[startcycle[0]] = aux;
    }
  }
  printf("%d\n", cycles);
  if (ruptureCycle > 1) {
    printf("%d\n", ruptureCycle);
    for (int i = 0; i < ruptureCycle; ++i) printf("%d ", startcycle[i]);
    printf("\n");
  }
}
int rez[MAX_N];
void printCycle(int nod) {
  int top = 0;
  while (edge[nod] != 0) {
    int aux = edge[nod];
    rez[top++] = nod;
    edge[nod] = 0;
    nod = aux;
  }
  if (top != 0) {
    printf("%d\n", top);
    for (int i = 0; i < top; ++i) printf("%d ", rez[i]);
    printf("\n");
  }
}
int main() {
  int n, s, cycles;
  scanf("%d%d", &n, &s);
  cycles = n;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &v[i]);
    poz[i] = i;
  }
  normalize(n);
  for (int i = 1; i <= n; ++i) sorted[i] = v[poz[i]];
  for (int i = 1; i <= n; ++i)
    if (v[i] != sorted[i]) {
      src[v[i]].push_back(i);
      target[sorted[i]].push_back(i);
    } else {
      ++s;
      --cycles;
    }
  if (s < n)
    printf("-1");
  else {
    buildCycles(n, cycles, s - n);
    for (int i = 1; i <= n; ++i) printCycle(i);
  }
  return 0;
}
