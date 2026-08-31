#include <bits/stdc++.h>
using namespace std;
using LL = long long;
const LL INF = INT_MAX;
const int N = 1e5 + 7;
const LL MOD = 1e9 + 7;
void ArrayIn(int size, int a[]) {
  for (int i = 0; i < size; i++) scanf("%d", &a[i]);
}
void ArrayOut(int size, int a[]) {
  for (int i = 0; i < size; i++) printf("%d ", a[i]);
  printf("\n");
}
int main() {
  int n, m, i;
  scanf("%d", &n);
  vector<pair<int, int>> ar(n + 1);
  for (i = 1; i <= n; i++) {
    int item;
    scanf("%d", &item);
    ar[i] = make_pair(item, i);
  }
  sort(ar.rbegin(), ar.rend() - 1);
  for (i = 1; i <= n; i++) {
    int j = i;
    while (ar[j].first == ar[j + 1].first && j < n) j++;
    reverse(ar.begin() + i, ar.begin() + j + 1);
    i = j;
  }
  scanf("%d", &m);
  while (m--) {
    vector<pair<int, int>> cur = ar;
    int k, pos;
    scanf("%d%d", &k, &pos);
    for (i = 1; i <= k; i++) {
      swap(cur[i].first, cur[i].second);
    }
    sort(cur.begin() + 1, cur.begin() + 1 + k);
    printf("%d\n", cur[pos].second);
  }
  return 0;
}
