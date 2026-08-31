#include <bits/stdc++.h>
using namespace std;
const int maxN = 111;
int from[maxN], len[maxN], N, mem[maxN], idA;
void alloc(int n) {
  for (int i = 0; i < (N); ++i)
    if (mem[i] == 0) {
      int l = 1;
      while (l < n && i + l <= N && !mem[i + l]) l++;
      if (i + l <= N && l >= n) {
        idA++;
        from[idA] = i;
        len[idA] = n;
        for (int k = 0; k < (n); ++k) mem[i + k] = idA;
        printf("%d\n", idA);
        return;
      }
      i += l - 1;
    }
  printf("NULL\n");
}
void erase(int n) {
  if (!(0 <= (n) && (n) < (maxN)) || !len[n]) {
    printf("ILLEGAL_ERASE_ARGUMENT\n");
    return;
  }
  for (int i = 0; i < (len[n]); ++i) mem[from[n] + i] = 0;
  len[n] = 0;
}
void defragment() {
  vector<int> ord;
  for (int i = 0; i < (N); ++i)
    if (mem[i] && (ord.empty() || ord.back() != mem[i])) ord.push_back(mem[i]);
  int f = 0;
  memset(mem, 0, sizeof(mem));
  for (__typeof((ord).begin()) i = ((ord).begin()); i != (ord).end(); ++i) {
    from[*i] = f;
    for (int j = 0; j < (len[*i]); ++j) mem[f + j] = *i;
    f += len[*i];
  }
}
int main() {
  int t, x;
  string cmd;
  cin >> t >> N;
  for (int i = 0; i < (t); ++i) {
    cin >> cmd;
    if (cmd[0] != 'd') {
      cin >> x;
      if (cmd[0] == 'a')
        alloc(x);
      else
        erase(x);
    } else
      defragment();
  }
  return 0;
}
